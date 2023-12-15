package com.example.mappers.entityMappers;

import java.util.function.Function;

import com.example.entities.AbstractGeneralEntityModel;

public interface MapperInterface<DtoGet, Entity extends AbstractGeneralEntityModel> extends Function<DtoGet, Entity> {
	
}
