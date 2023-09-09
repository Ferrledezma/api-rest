package com.example.practica4.mappers.updateEntity;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.practica4.dto.GeneralModelDTO;
import com.example.practica4.entities.AbstractEntityModel;
import com.example.practica4.repository.ClassroomRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;

@Getter
public abstract class AbstractEntityUpdateModel<Entity extends AbstractEntityModel, DTOUpdate extends GeneralModelDTO>
implements UpdateEntityInterface<Entity, DTOUpdate> {
	/*Properties*/
	protected Entity entity;
	protected DTOUpdate dtoEntityUpdate;
	
	/*Dependencies*/
	@Autowired
	private ClassroomRepository classroomRepository;

	/*Methods*/
	@Override
	public void accept(ContainerEntityAndDTO<Entity, DTOUpdate> containerUpdate) throws EntityNotFoundException {
		entity = containerUpdate.getEntity();
		dtoEntityUpdate = containerUpdate.getDtoUpdate();
		updateInformation();
		updateRelations();
	}

	protected void updateInformation() {
		if(dtoEntityUpdate.getName() != null) {
			entity.setName(dtoEntityUpdate.getName());
		}
	}
	/*Abstract methods*/
	protected abstract void updateRelations();
}





