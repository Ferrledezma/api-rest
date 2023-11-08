package com.example.demo.practice2.mapper.dto_mapper;

import java.util.function.Function;

import com.example.demo.practice2.entities.EntityModel;

public interface DTOMapperInterface<Entity extends EntityModel, DTOGet> extends Function<Entity, DTOGet> {

}
