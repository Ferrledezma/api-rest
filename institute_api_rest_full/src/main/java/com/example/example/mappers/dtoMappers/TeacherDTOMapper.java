package com.example.practica4.mappers.dtoMappers;

import org.springframework.stereotype.Component;

import com.example.practica4.dto.profesor.TeacherDTOGet;
import com.example.practica4.entities.TeacherEntity;

@Component
public class TeacherDTOMapper implements DTOMapperInterface<TeacherEntity, TeacherDTOGet> {

	@Override
	public TeacherDTOGet apply(TeacherEntity teacher) {
		return new TeacherDTOGet(
				teacher.getSurName(),
				teacher.getName(),
				teacher.getSex(),
				teacher.getBirthDate(),
				teacher.getDni(),
				teacher.getSubject().toString(),
				teacher.getExperience(),
				teacher.getSalary(),
				teacher.getInstitutes().size(),
				teacher.getClassrooms().size()
				);
	}

}
