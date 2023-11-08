package com.example.demo.practice1.service;

import java.util.List;

import com.example.demo.practice1.exception.ResourceNotFoundException;

public interface ServiceInterface<Entity, DTOPost, DTOGet, DTOUpdate> {
	public DTOGet createResource(DTOPost dtoPost);
	
	public DTOGet updateResource(Long id, DTOUpdate dtoUpdate) throws ResourceNotFoundException;
	
	public void deleteResource(Long id) throws ResourceNotFoundException;
	
	public Entity findResource(Long id) throws ResourceNotFoundException;
	
	public DTOGet findResourceAsDTO(Long id) throws ResourceNotFoundException;
	
	public List<DTOGet> findAllResource();
}
