package com.example.springboot.social_network.mapper.update.model;

import java.util.function.BiConsumer;

import com.example.springboot.social_network.entities.model.GeneralEntityModel;

public interface EntityUpdateInterface<Entity extends GeneralEntityModel, DTOUpdate> extends BiConsumer<Entity, DTOUpdate> {

}
