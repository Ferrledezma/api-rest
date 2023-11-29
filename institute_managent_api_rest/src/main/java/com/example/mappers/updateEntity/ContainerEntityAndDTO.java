package com.example.mappers.updateEntity;

import org.springframework.stereotype.Component;

import com.example.entities.AbstractGeneralEntityModel;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class ContainerEntityAndDTO<Entity extends AbstractGeneralEntityModel, DTOUpdate> {
	private Entity entity;
	private DTOUpdate dtoUpdate;
}
