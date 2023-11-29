package com.example.mappers.dtoMappers;

import java.util.function.Function;

import com.example.entities.AbstractGeneralEntityModel;

public interface DTOMapperInterface<Entity extends AbstractGeneralEntityModel, DtoGet> extends Function<Entity, DtoGet> {

}
