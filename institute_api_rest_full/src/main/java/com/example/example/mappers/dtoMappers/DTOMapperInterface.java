package com.example.practica4.mappers.dtoMappers;

import java.util.function.Function;

import com.example.practica4.entities.AbstractGeneralEntityModel;

public interface DTOMapperInterface<Entity extends AbstractGeneralEntityModel, DtoGet> extends Function<Entity, DtoGet> {

}
