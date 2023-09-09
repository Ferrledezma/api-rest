package com.example.practica4.mappers.entityMappers;

import java.util.function.Function;

import com.example.practica4.entities.AbstractGeneralEntityModel;

public interface MapperInterface<DtoGet, Entity extends AbstractGeneralEntityModel> extends Function<DtoGet, Entity> {
	
}
