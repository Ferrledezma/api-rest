package com.example.practica4.mappers.updateEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.practica4.dto.estudiantes.StudentDTOUpdate;
import com.example.practica4.entities.StudentEntity;
import com.example.practica4.extras.RelateInstituteAndClassrooms;
import com.example.practica4.status.Desempenio;

@Component
public class UpdateStudentEntity extends AbstractPersonUpdateModel<StudentEntity, StudentDTOUpdate> {
	@Autowired
	private RelateInstituteAndClassrooms relateEntities;
	
	@Override
	protected void updateInformation() {
		if(dtoEntityUpdate.getGrade() != null) {
			entity.setGrade(dtoEntityUpdate.getGrade());
		}
		
		if(dtoEntityUpdate.getPerformance() != null) {
			Desempenio desempenio = Desempenio.valueOf(dtoEntityUpdate.getPerformance().toUpperCase());
			if(desempenio == null) {
				throw new RuntimeException("No existe la materia '" + dtoEntityUpdate.getPerformance() + "'");
			}
			entity.setPerformance(desempenio);
		}
	}

	@Override
	protected void updateRelations() {
		relateEntities.relate(entity::setInstitute, entity::setClassroom, dtoEntityUpdate.getInstituteId(), List.of(dtoEntityUpdate.getClassroomNumber()));
	}
}













