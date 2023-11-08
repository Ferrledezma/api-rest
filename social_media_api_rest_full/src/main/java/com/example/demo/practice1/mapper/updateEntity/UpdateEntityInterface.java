package com.example.demo.practice1.mapper.updateEntity;

import java.util.function.BiConsumer;

import com.example.demo.practice1.entities.EntityModel;

public interface UpdateEntityInterface<Entity extends EntityModel, DTOUpdate> extends BiConsumer<Entity, DTOUpdate> {

}
