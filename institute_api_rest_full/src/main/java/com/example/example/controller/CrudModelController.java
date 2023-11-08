package com.example.practica4.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.practica4.entities.AbstractGeneralEntityModel;
import com.example.practica4.service.ServiceInterface;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Getter;

import org.springframework.web.bind.annotation.RequestBody;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public abstract class CrudModelController
<Entity extends AbstractGeneralEntityModel, DtoPost, DtoGet, DtoUpdate> 
implements CrudInterface<Entity, DtoPost, DtoGet, DtoUpdate> {
	@Autowired
	ServiceInterface<Entity, DtoPost, DtoGet, DtoUpdate> service;
	
	@Override
	@PostMapping("/create")
	public ResponseEntity<Entity> create(@RequestBody DtoPost dtoPost) {
		Entity entity = service.createResource(dtoPost);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("{id}")
				.buildAndExpand(entity.getId())
				.toUri();
		
		HttpHeaders header = new HttpHeaders();
		header.add("location", location.toString());
		
		return new ResponseEntity<>(entity, header, HttpStatus.CREATED);
	}

	@Override
	@PatchMapping("/update/{id}")
	public ResponseEntity<DtoGet> update(@PathVariable Long id, @RequestBody DtoUpdate dtoUpdate) {
		DtoGet dtoGet = service.updateResource(id, dtoUpdate);
		return new ResponseEntity<>(dtoGet, HttpStatus.OK);
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(Long id) {
		service.deleteResource(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	@GetMapping("/find/{id}")
	public ResponseEntity<DtoGet> find(Long id) {
		DtoGet dtoGet = service.findAndMap(id);
		return new ResponseEntity<>(dtoGet, HttpStatus.OK);
	}

	@Override
	@GetMapping("/findAll")
	public ResponseEntity<List<DtoGet>> findAll() {
		List<DtoGet> dtoGetList = service.findAllResource();
		
		if(!dtoGetList.isEmpty()) {
			return new ResponseEntity<>(dtoGetList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}
