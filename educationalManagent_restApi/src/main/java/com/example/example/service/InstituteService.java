package com.example.practica4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practica4.dto.aula.ClassroomDTOGet;
import com.example.practica4.dto.instituto.InstituteDTOGet;
import com.example.practica4.dto.instituto.InstituteDTOPost;
import com.example.practica4.dto.instituto.InstituteDTOUpdate;
import com.example.practica4.entities.ClassroomEntity;
import com.example.practica4.entities.InstituteEntity;
import com.example.practica4.mappers.dtoMappers.ClassroomDTOMapper;
import com.example.practica4.repository.ClassroomRepository;
import com.example.practica4.repository.IntermediaryTableRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Service
public class InstituteService extends AbstractServiceModel<InstituteEntity, InstituteDTOPost, InstituteDTOGet, InstituteDTOUpdate> {
	
	/*Dependencies*/
	private final ClassroomRepository classroomRepository;
	private final ClassroomDTOMapper classroomDTOMapper;
	private final IntermediaryTableRepository intermediaryTableRepository;

	/*Constructs*/
	@Autowired
	public InstituteService(ClassroomRepository classroomRepository, ClassroomDTOMapper classroomDTOMapper, IntermediaryTableRepository intermediaryTableRepository) {
		this.classroomRepository = classroomRepository;
		this.classroomDTOMapper = classroomDTOMapper;
		this.intermediaryTableRepository = intermediaryTableRepository;
	}

	/*Methods*/
	@Override
	public InstituteEntity createResource(@Valid InstituteDTOPost instituteDTO) throws ConstraintViolationException, EntityNotFoundException {
		InstituteEntity institute = getEntityMapper().apply(instituteDTO);
		getRepository().save(institute);
		
		for(int i = 0; i < instituteDTO.getNumberClassrooms(); i++) {
			ClassroomEntity classroom = new ClassroomEntity(institute);
			institute.addRelations(classroom);
			classroomRepository.save(classroom);
		}
		
		return institute;
	}

	@Override
	public void deleteResource(@NotNull @Positive Long id) throws ConstraintViolationException, EntityNotFoundException, RuntimeException {
		InstituteEntity institute = findResource(id);
		for(ClassroomEntity classroom : institute.getClassrooms()) {
			intermediaryTableRepository.deleteIntermediaryRelation("profesores_aulas", "aula_id", classroom.getId());
		}
		
		intermediaryTableRepository.deleteIntermediaryRelation("profesores_institutos", "instituto_id", id);
		
		getRepository().delete(institute);
	}

	public ClassroomDTOGet getInstituteClassroom(@NotNull @Positive Long instituteId, @NotNull @Positive Integer classroomNumber)
			throws ConstraintViolationException, EntityNotFoundException {
		InstituteEntity institute = findResource(instituteId);
		
		for(ClassroomEntity aula : institute.getClassrooms()) {
			if(aula.getClassroomNumber() == classroomNumber) {
				return classroomDTOMapper.apply(aula);
			}
		}
		return null;
	}

	public List<ClassroomDTOGet> findAllInstituteClassroom(@NotNull @Positive Long id) throws ConstraintViolationException, EntityNotFoundException {
		return findResource(id)
				.getClassrooms()
				.stream()
				.map(classroomDTOMapper)
				.toList();
	}
}

















