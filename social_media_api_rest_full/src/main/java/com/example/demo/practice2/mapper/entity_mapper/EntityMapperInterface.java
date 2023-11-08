package com.example.demo.practice2.mapper.entity_mapper;

import java.util.function.Function;

import com.example.demo.practice2.entities.EntityModel;

public interface EntityMapperInterface<DTOPost, Entity extends EntityModel> extends Function<DTOPost, Entity> {

}
