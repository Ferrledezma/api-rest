package com.example.demo.social_network.mapper.dto_mapper;

import java.util.function.Function;

import com.example.demo.social_network.entities.EntityModel;

public interface DTOMapperInterface<Entity extends EntityModel, DTOGet> extends Function<Entity, DTOGet> {

}
