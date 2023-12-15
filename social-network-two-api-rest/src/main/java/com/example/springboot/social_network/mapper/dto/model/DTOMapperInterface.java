package com.example.springboot.social_network.mapper.dto.model;

import java.util.function.Function;

import com.example.springboot.social_network.entities.model.GeneralEntityModel;

public interface DTOMapperInterface<Entity extends GeneralEntityModel, DTO> extends Function<Entity, DTO> {

}
