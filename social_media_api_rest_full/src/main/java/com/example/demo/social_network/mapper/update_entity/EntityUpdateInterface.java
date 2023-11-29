package com.example.demo.social_network.mapper.update_entity;

import java.util.function.BiConsumer;

import com.example.demo.social_network.entities.EntityModel;

public interface EntityUpdateInterface<Entity extends EntityModel, DTOUpdate> extends BiConsumer<Entity, DTOUpdate> {

}
