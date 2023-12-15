package com.example.springboot.social_network.service.type.response.model;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.springboot.social_network.entities.model.GeneralEntityModel;
import com.example.springboot.social_network.request.id.RequestId;
import com.example.springboot.social_network.request.response.PageResponseBody;


public interface ResponseServiceInterface<Entity extends GeneralEntityModel, DTOPost, DTOGet, DTOUpdate> {
	public ResponseEntity<Entity> create(DTOPost dtoPost);
	
	public ResponseEntity<DTOGet> update(RequestId containerId, DTOUpdate dtoUpdate);
	
	public ResponseEntity<?> delete(RequestId idContainer);
	
	public ResponseEntity<DTOGet> findAsDTO(RequestId idContainer);
	
	public ResponseEntity<List<DTOGet>> findAllAsDTO(RequestId idContainer);
	
	public ResponseEntity<PageResponseBody<DTOGet>> findByPage(Integer pageNumber, Integer PageSize, String columnSort);
}
