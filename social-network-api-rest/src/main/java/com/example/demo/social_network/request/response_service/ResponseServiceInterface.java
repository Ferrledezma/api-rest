package com.example.demo.social_network.request.response_service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.social_network.exception.personalizate_exception.NoRelationException;
import com.example.demo.social_network.exception.personalizate_exception.ResourceNotFoundException;
import com.example.demo.social_network.request.response_body.PageResponseBody;

public interface ResponseServiceInterface<Entity, DTOPost, DTOGet, DTOUpdate, ContainerID> {
	
	public ResponseEntity<Entity> create(DTOPost dtoPost);
	
	public ResponseEntity<DTOGet> update(ContainerID ContainerID, DTOUpdate dtoUpdate) throws ResourceNotFoundException, NoRelationException;
	
	public ResponseEntity<?> delete(ContainerID ContainerID) throws ResourceNotFoundException, NoRelationException;
	
	public ResponseEntity<DTOGet> find(ContainerID ContainerID) throws ResourceNotFoundException, NoRelationException;
	
	public ResponseEntity<List<DTOGet>> findAll();
	
	public ResponseEntity<List<DTOGet>> findAll(ContainerID containerId) throws ResourceNotFoundException, NoRelationException;
	
	public ResponseEntity<PageResponseBody<DTOGet>> findByPage(Integer pageNumber, Integer pageSize, String columnSort);
}
