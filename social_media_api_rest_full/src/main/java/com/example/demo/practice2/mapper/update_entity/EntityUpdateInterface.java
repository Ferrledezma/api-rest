package com.example.demo.practice2.mapper.update_entity;

import java.util.function.BiConsumer;

import com.example.demo.practice2.entities.EntityModel;

public interface EntityUpdateInterface<Entity extends EntityModel, DTOUpdate> extends BiConsumer<Entity, DTOUpdate> {

}
