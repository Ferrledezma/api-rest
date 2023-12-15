package com.example.springboot.social_network.service.type.repository.model;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.springboot.social_network.entities.model.GeneralEntityModel;
import com.example.springboot.social_network.exception.ResourceNotFoundException;
import com.example.springboot.social_network.request.id.RequestId;
import com.example.springboot.social_network.request.response.PageResponseBody;

public interface RepositoryServiceInterface<Entity extends GeneralEntityModel, DTOPost, DTOGet, DTOUpdate> {
	public Entity create(DTOPost dtoPost) throws ResourceNotFoundException;
	
	public DTOGet update(RequestId containerId, DTOUpdate dtoUpdate) throws ResourceNotFoundException;
	
	public void delete(RequestId containerId) throws ResourceNotFoundException;
	
	public Entity find(RequestId containerId) throws ResourceNotFoundException;
	
	public DTOGet findAsDTO(RequestId containerId) throws ResourceNotFoundException;
	
	public List<Entity> findAll(RequestId containerId);
	
	public List<DTOGet> findAllAsDTO(RequestId containerId);
	
	public PageResponseBody<DTOGet> findByPage(Pageable pageRequest);
}
