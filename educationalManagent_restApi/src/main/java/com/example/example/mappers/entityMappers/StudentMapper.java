package com.example.practica4.mappers.entityMappers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.practica4.dto.estudiantes.StudentDTOPost;
import com.example.practica4.entities.StudentEntity;
import com.example.practica4.extras.RelateInstituteAndClassrooms;
import com.example.practica4.status.Desempenio;

import jakarta.persistence.EntityNotFoundException;

@Component
public class StudentMapper implements MapperInterface<StudentDTOPost, StudentEntity> {
	@Autowired
	private RelateInstituteAndClassrooms relateEntities;
	@Override
	public StudentEntity apply(StudentDTOPost studentDTO) throws EntityNotFoundException, RuntimeException {
		Desempenio performance = Desempenio.valueOf(studentDTO.getPerformance());
		if(performance == null) {
			throw new RuntimeException("No existe el tipo de performance '" + studentDTO.getPerformance() + "'");
		}
		StudentEntity student = new StudentEntity(
				studentDTO.getSurName(),
				studentDTO.getName(),
				studentDTO.getSex(),
				studentDTO.getBirthDate(),
				studentDTO.getDni(),
				studentDTO.getGrade(),
				performance
				);
		
		relateEntities.relate(student::setInstitute, student::setClassroom, studentDTO.getInstituteId(), List.of(studentDTO.getClassroomNumber()));
		
		return student;
	}
}
