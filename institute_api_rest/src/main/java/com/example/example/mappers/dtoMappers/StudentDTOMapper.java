package com.example.practica4.mappers.dtoMappers;

import org.springframework.stereotype.Component;

import com.example.practica4.dto.estudiantes.StudentDTOGet;
import com.example.practica4.entities.StudentEntity;

@Component
public class StudentDTOMapper implements DTOMapperInterface<StudentEntity, StudentDTOGet> {

	@Override
	public StudentDTOGet apply(StudentEntity student) {
		return new StudentDTOGet(
				student.getSurName(),
				student.getName(),
				student.getSex(),
				student.getBirthDate(),
				student.getDni(),
				student.getGrade(),
				student.getPerformance().toString(),
				student.getInstitute().getName(),
				student.getClassroom().getClassroomNumber()
				);
	}

}
