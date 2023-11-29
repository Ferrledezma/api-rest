package com.example.mappers.updateEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dto.estudiantes.StudentDTOUpdate;
import com.example.entities.StudentEntity;
import com.example.extras.RelateInstituteAndClassrooms;
import com.example.status.Desempenio;


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













