package com.example.mappers.dtoMappers;

import org.springframework.stereotype.Component;

import com.example.dto.estudiantes.StudentDTOGet;
import com.example.entities.StudentEntity;

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
