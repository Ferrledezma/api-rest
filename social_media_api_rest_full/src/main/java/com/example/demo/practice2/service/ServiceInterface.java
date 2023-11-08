package com.example.demo.practice2.service;

import java.util.List;

import com.example.demo.practice2.exception.personalizate_exception.NoRelationException;
import com.example.demo.practice2.exception.personalizate_exception.ResourceNotFoundException;
import com.example.demo.practice2.request.response_body.PageResponseBody;

public interface ServiceInterface<Entity, DTOPost, DTOGet, DTOUpdate, ContainerId> {
	public Entity createResource(DTOPost dtoPost);
	
	public DTOGet updateResource(ContainerId containerId, DTOUpdate dtoUpdate) throws ResourceNotFoundException, NoRelationException;
	
	public void deleteResource(ContainerId containerId) throws ResourceNotFoundException, NoRelationException;
	
	public Entity findResource(ContainerId containerId) throws ResourceNotFoundException, NoRelationException;
	
	public DTOGet findResourceAsDTO(ContainerId containerId) throws ResourceNotFoundException, NoRelationException;
	
	public List<DTOGet> findAllResourceAsDTO();
	
	public List<DTOGet> findAllResourceAsDTO(ContainerId containerId) throws ResourceNotFoundException, NoRelationException;
	
	public PageResponseBody<DTOGet> findByPage(Integer pageNumber, Integer pageSize, String columnSort);
	
	public void existsRelation(ContainerId containerId) throws ResourceNotFoundException, NoRelationException;
}






