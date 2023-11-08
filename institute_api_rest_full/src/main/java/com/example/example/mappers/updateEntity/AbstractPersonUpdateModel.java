package com.example.practica4.mappers.updateEntity;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.practica4.dto.PersonDTO;
import com.example.practica4.entities.PersonEntityModel;
import com.example.practica4.service.InstituteService;

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










