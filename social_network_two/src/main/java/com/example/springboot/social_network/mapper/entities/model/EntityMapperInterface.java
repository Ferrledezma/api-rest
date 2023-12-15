package com.example.springboot.social_network.mapper.entities.model;

import java.util.function.Function;

import com.example.springboot.social_network.entities.model.GeneralEntityModel;

public interface EntityMapperInterface<DTO, Entity extends GeneralEntityModel> extends Function<DTO, Entity> {

}
