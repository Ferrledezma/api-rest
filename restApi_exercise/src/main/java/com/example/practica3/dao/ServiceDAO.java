package com.example.practica3.dao;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public interface ServiceDAO <T, P, U, G>{
	public T create(@Valid P p) throws ConstraintViolationException, EntityNotFoundException;
	public G update(@NotNull @Positive Long id, @Valid U u) throws ConstraintViolationException, EntityNotFoundException;
	public void delete(@NotNull @Positive Long id) throws ConstraintViolationException, EntityNotFoundException;
	public T find(@NotNull @Positive Long id) throws ConstraintViolationException, EntityNotFoundException;
	public List<G> findAll();
}











