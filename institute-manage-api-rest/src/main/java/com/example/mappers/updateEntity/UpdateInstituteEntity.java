package com.example.mappers.updateEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.instituto.InstituteDTOUpdate;
import com.example.entities.ClassroomEntity;
import com.example.entities.InstituteEntity;
import com.example.repository.ClassroomRepository;
import com.example.repository.IntermediaryTableRepository;

@Component
public class UpdateInstituteEntity extends AbstractEntityUpdateModel<InstituteEntity, InstituteDTOUpdate> {
	/*Dependencies*/
	@Autowired
	private ClassroomRepository classroomRepository;
	
	@Autowired
	private IntermediaryTableRepository intermediaryTableRepository;

	/*Methods*/
	@Override
	@Transactional
	protected void updateRelations() {
		if(dtoEntityUpdate.getClassroomsAdd() != null) {
			addClassrooms();
		}
		if(dtoEntityUpdate.getClassroomsDeleteList() != null && !dtoEntityUpdate.getClassroomsDeleteList().isEmpty()) {
			deleteClassrooms();
		}
		if(dtoEntityUpdate.getClassroomsAdd() != null || dtoEntityUpdate.getClassroomsDeleteList() != null) {
			resetClassroomNumbers();
		}
	}

	private void addClassrooms() {
		for(int i = 0; i < dtoEntityUpdate.getClassroomsAdd(); i++) {
			ClassroomEntity classroom = new ClassroomEntity(entity);
			entity.addRelations(classroom);
			classroomRepository.save(classroom);
		}
	}

	private void deleteClassrooms() {
		for(Integer number : dtoEntityUpdate.getClassroomsDeleteList()) {
			for(ClassroomEntity classroom : entity.getClassrooms()) {
				if(classroom.getClassroomNumber() == number) {
					intermediaryTableRepository.deleteIntermediaryRelation("profesores_aulas", "aula_id", classroom.getId());
					entity.removeRelations(classroom);
					classroomRepository.deleteClassroomInstitute(number, entity.getId());
					break;
				}
			}
		}
	}

	private void resetClassroomNumbers() {
		int number = 1;
		for(ClassroomEntity classroom : entity.getClassrooms()) {
			classroom.setClassroomNumber(number);
			number++;
		}
	}
}












