package com.example.mappers.updateEntity;

import java.util.function.Consumer;

import com.example.entities.AbstractGeneralEntityModel;

public interface UpdateEntityInterface <Entity extends AbstractGeneralEntityModel, DTOUpdate> extends Consumer<ContainerEntityAndDTO<Entity, DTOUpdate>> {
	
}
