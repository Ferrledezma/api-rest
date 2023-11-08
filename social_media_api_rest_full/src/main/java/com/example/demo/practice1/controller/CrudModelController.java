package com.example.demo.practice1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.practice1.constant.ConstantParamName;
import com.example.demo.practice1.constant.ConstantRoute;
import com.example.demo.practice1.entities.EntityModel;
import com.example.demo.practice1.exception.ResourceNotFoundException;
import com.example.demo.practice1.service.ServiceInterface;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
public abstract class CrudModelController<Entity extends EntityModel, DTOPost, DTOGet, DTOUpdate> {
	
	@Autowired
	private ServiceInterface<Entity, DTOPost, DTOGet, DTOUpdate> service;

	@PostMapping(value = ConstantRoute.CREATED_ROUTE)
	public ResponseEntity<DTOGet> created(@Valid @RequestBody DTOPost dtoPost, HttpServletRequest request) throws ConstraintViolationException{
		DTOGet dtoGet = service.createResource(dtoPost);
		
		HttpHeaders header = new HttpHeaders();
		String location = request.getRequestURI();
		header.add("location", location);
		
		return new ResponseEntity<>(dtoGet, header, HttpStatus.CREATED);
	}
	
	@PatchMapping(value = ConstantRoute.UPDATE_ROUTE)
	public ResponseEntity<DTOGet> update(
			@PathVariable(name = ConstantParamName.ID_NAME) @NotNull @Positive Long id,
			@RequestBody @Valid DTOUpdate dtoUpdate) throws ConstraintViolationException, ResourceNotFoundException {
		
		DTOGet dtoGet = service.updateResource(id, dtoUpdate);
		return new ResponseEntity<>(dtoGet, HttpStatus.OK);
	}
	
	@DeleteMapping(value = ConstantRoute.DELETE_ROUTE)
	public ResponseEntity<?> delete(@PathVariable(name = ConstantParamName.ID_NAME) @NotNull @Positive Long id)
	throws ConstraintViolationException, ResourceNotFoundException {
		service.deleteResource(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = ConstantRoute.FIND_ROUTE)
	public ResponseEntity<DTOGet> find(@PathVariable(name = ConstantParamName.ID_NAME) @NotNull @Positive Long id)
	throws ConstraintViolationException, ResourceNotFoundException {
		DTOGet dtoGet = service.findResourceAsDTO(id);
		return new ResponseEntity<>(dtoGet, HttpStatus.OK);
	}
	
	@GetMapping(value = ConstantRoute.FIND_ALL_ROUTE)
	public ResponseEntity<List<DTOGet>> findAll(){
		List<DTOGet> dtoList = service.findAllResource();
		if(dtoList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}
}














