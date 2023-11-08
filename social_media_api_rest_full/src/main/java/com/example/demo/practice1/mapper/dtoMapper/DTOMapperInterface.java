package com.example.demo.practice1.mapper.dtoMapper;

import java.util.function.Function;

import com.example.demo.practice1.entities.EntityModel;

public interface DTOMapperInterface<Entity extends EntityModel, DTOGet> extends Function<Entity, DTOGet> {

}
