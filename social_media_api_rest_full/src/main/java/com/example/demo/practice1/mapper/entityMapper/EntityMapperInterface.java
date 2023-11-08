package com.example.demo.practice1.mapper.entityMapper;

import java.util.function.Function;

import com.example.demo.practice1.entities.EntityModel;

public interface EntityMapperInterface<DTOPost, Entity extends EntityModel> extends Function<DTOPost, Entity> {
	
}
