package com.example.springboot.social_network.controller.crud.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.springboot.social_network.entities.model.GeneralEntityModel;
import com.example.springboot.social_network.service.type.response.model.ResponseServiceInterface;

public abstract class CrudModelController<Entity extends GeneralEntityModel, DTOPost, DTOGet, DTOUpdate> {
	@Autowired
	protected ResponseServiceInterface<Entity, DTOPost, DTOGet, DTOUpdate> responseService;
}
