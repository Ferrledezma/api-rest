package com.example.practica4.mappers.entityMappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.practica4.dto.profesor.TeacherDTOPost;
import com.example.practica4.entities.TeacherEntity;
import com.example.practica4.extras.RelateInstituteAndClassrooms;
import com.example.practica4.status.Materias;

import jakarta.persistence.EntityNotFoundException;

@Component
public class TeacherMapper implements MapperInterface<TeacherDTOPost, TeacherEntity> {
	@Autowired
	private RelateInstituteAndClassrooms relateEntities;
	@Override
	public TeacherEntity apply(TeacherDTOPost teacherDTO) throws EntityNotFoundException, RuntimeException {
		Materias materia = Materias.valueOf(teacherDTO.getSubject().toUpperCase());
		if(materia == null) {
			throw new RuntimeException("No existe la materia '" + teacherDTO.getSubject() + "'");
		}
		
		TeacherEntity teacher = new TeacherEntity(
				teacherDTO.getSurName(),
				teacherDTO.getName(),
				teacherDTO.getSex(),
				teacherDTO.getBirthDate(),
				teacherDTO.getDni(),
				materia,
				teacherDTO.getExperience(),
				teacherDTO.getSalary()
				);
		
		relateEntities.relate(teacher::addInstitute, teacher::addClassroomList, teacherDTO.getInstituteId(), teacherDTO.getClassroomNumberList());
		
		return teacher;
	}
	
}




















