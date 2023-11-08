package com.example.practica4.mappers.updateEntity;

import org.springframework.stereotype.Component;

import com.example.practica4.entities.AbstractGeneralEntityModel;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class ContainerEntityAndDTO<Entity extends AbstractGeneralEntityModel, DTOUpdate> {
	private Entity entity;
	private DTOUpdate dtoUpdate;
}
