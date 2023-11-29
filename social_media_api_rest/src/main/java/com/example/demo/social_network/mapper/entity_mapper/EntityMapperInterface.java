package com.example.demo.social_network.mapper.entity_mapper;

import java.util.function.Function;

import com.example.demo.social_network.entities.EntityModel;

public interface EntityMapperInterface<DTOPost, Entity extends EntityModel> extends Function<DTOPost, Entity> {

}
