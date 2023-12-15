package com.example.mappers.updateEntity;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dto.profesor.TeacherDTOUpdate;
import com.example.entities.ClassroomEntity;
import com.example.entities.InstituteEntity;
import com.example.entities.TeacherEntity;
import com.example.extras.RelateInstituteAndClassrooms;
import com.example.status.Materias;

import jakarta.persistence.EntityNotFoundException;

@Component
public class UpdateTeacherEntity extends AbstractPersonUpdateModel<TeacherEntity, TeacherDTOUpdate>  {
	@Autowired
	RelateInstituteAndClassrooms relateInstitute;

	@Override
	public void updateInformation() {
		if(dtoEntityUpdate.getSubject() != null) {
			System.out.println(dtoEntityUpdate.getClassroomListAdd().size());
			
			Materias materia = Materias.valueOf(dtoEntityUpdate.getSubject().toUpperCase());
			if(materia == null) {
				throw new RuntimeException("No existe la materia '" + dtoEntityUpdate.getSubject() + "'");
			}
			entity.setSubject(materia);
		}
		if(dtoEntityUpdate.getExperience() != null) {
			entity.setExperience(dtoEntityUpdate.getExperience());
		}
		if(dtoEntityUpdate.getSalary() != null) {
			entity.setSalary(dtoEntityUpdate.getSalary());
		}
		
	}

	@Override
	protected void updateRelations() throws EntityNotFoundException {
		if(dtoEntityUpdate.getInstituteIdAdd() != null) {
			addInstitute();
		}
		if(dtoEntityUpdate.getInstituteId() != null) {
			removeClassroom();
		}
		if(dtoEntityUpdate.getInstituteIdDelete() != null) {
			removeInstitute();
		}
	}

	private void addInstitute() throws EntityNotFoundException {
		relateInstitute.relate(entity::addInstitute, entity::addClassroomList, dtoEntityUpdate.getInstituteIdAdd(), dtoEntityUpdate.getClassroomListAdd());
	}

	private void removeClassroom() {
		Set<ClassroomEntity> classroomList = dtoEntityUpdate.getClassroomListDelete()
				.stream()
				.map(number ->
					getClassroomRepository()
					.findInstituteClassroom(dtoEntityUpdate.getInstituteId(), number)
					.orElseThrow(() -> new RuntimeException(
							"La entidad instituto no contiene un aula con el numero '" + number + "' en la DB"
							))
				)
				.collect(Collectors.toSet());
		
		entity.getClassrooms().removeAll(classroomList);
	}

	private void removeInstitute() throws EntityNotFoundException {
		InstituteEntity institute = getInstituteService().findResource(dtoEntityUpdate.getInstituteIdDelete());
		entity.removeInstitute(institute);
		
		Set<ClassroomEntity> classroomList = getClassroomRepository()
				.findAllInstituteClassroom(dtoEntityUpdate.getInstituteIdDelete())
				.stream()
				.filter(classroom -> classroom.getTeachers().contains(entity))
				.collect(Collectors.toSet());
		
		entity.removeClassroomList(classroomList);
	}
}













