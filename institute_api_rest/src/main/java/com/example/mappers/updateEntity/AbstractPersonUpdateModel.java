package com.example.mappers.updateEntity;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dto.PersonDTO;
import com.example.entities.PersonEntityModel;
import com.example.service.InstituteService;

import lombok.Getter;

@Getter
public abstract class AbstractPersonUpdateModel<Person extends PersonEntityModel, DTOPerson extends PersonDTO>
extends AbstractEntityUpdateModel<Person, DTOPerson> {
	@Autowired
	private InstituteService instituteService;
	
	@Override
	protected void updateInformation() {
		if(dtoEntityUpdate.getSurName() != null) {
			entity.setSurName(dtoEntityUpdate.getSurName());
		}
		if(dtoEntityUpdate.getSex() != null) {
			entity.setSex(dtoEntityUpdate.getSex());
		}
		if(dtoEntityUpdate.getBirthDate() != null) {
			entity.setBirthDate(dtoEntityUpdate.getBirthDate());
		}
		if(dtoEntityUpdate.getDni() != null) {
			entity.setDni(dtoEntityUpdate.getDni());
		}
	}
}










