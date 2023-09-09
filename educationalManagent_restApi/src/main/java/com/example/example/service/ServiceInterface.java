package com.example.practica4.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.example.practica4.entities.AbstractGeneralEntityModel;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
public interface ServiceInterface<Entity extends AbstractGeneralEntityModel, DtoPost, DtoGet, DtoUpdate> {
	public void saveResource(Entity entity);
	
	public Entity createResource(@Valid DtoPost dtoPost) throws ConstraintViolationException, EntityNotFoundException;
	
	public DtoGet updateResource(@NotNull @Positive Long id, @Valid DtoUpdate dtoupdate)
			throws ConstraintViolationException, EntityNotFoundException;
	
	public void deleteResource(@NotNull @Positive Long id) throws ConstraintViolationException, EntityNotFoundException;
	
	public Entity findResource(@NotNull @Positive Long id) throws ConstraintViolationException, EntityNotFoundException;
	
	public List<DtoGet> findAllResource();
	
	public DtoGet findAndMap(@NotNull @Positive Long id) throws ConstraintViolationException, EntityNotFoundException;
}
