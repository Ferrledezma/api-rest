package com.example.practica4.mappers.updateEntity;

import java.util.function.Consumer;

import com.example.practica4.entities.AbstractGeneralEntityModel;

public interface UpdateEntityInterface <Entity extends AbstractGeneralEntityModel, DTOUpdate> extends Consumer<ContainerEntityAndDTO<Entity, DTOUpdate>> {
	
}
