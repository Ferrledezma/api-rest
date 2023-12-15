package com.example.springboot.social_network.service.type.response.model;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springboot.social_network.constant.ConstantParam;
import com.example.springboot.social_network.entities.model.GeneralEntityModel;
import com.example.springboot.social_network.request.id.RequestId;
import com.example.springboot.social_network.request.response.PageResponseBody;
import com.example.springboot.social_network.service.type.repository.model.RepositoryServiceInterface;

public abstract class ResponseServiceModel<Entity extends GeneralEntityModel, DTOPost, DTOGet, DTOUpdate>
implements ResponseServiceInterface<Entity, DTOPost, DTOGet, DTOUpdate> {
	@Autowired
	private RepositoryServiceInterface<Entity, DTOPost, DTOGet, DTOUpdate> repositoryService;

	@Override
	public ResponseEntity<Entity> create(DTOPost dtoPost) {
		
		Entity entity = repositoryService.create(dtoPost);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path(ConstantParam.ID_PARAM_IDENTIFIER)
				.buildAndExpand(entity.getId())
				.toUri();
		
		return ResponseEntity.created(location).body(entity);
	}
	
	@Override
	public ResponseEntity<DTOGet> update(RequestId containerId, DTOUpdate dtoUpdate) {
		DTOGet dtoGet = repositoryService.update(containerId, dtoUpdate);
		
		return ResponseEntity.ok(dtoGet);
	}
	
	@Override
	public ResponseEntity<?> delete(RequestId idContainer) {
		repositoryService.delete(idContainer);
		
		return ResponseEntity.noContent().build();
	}
	
	@Override
	public ResponseEntity<DTOGet> findAsDTO(RequestId idContainer) {
		DTOGet dtoGet = repositoryService.findAsDTO(idContainer);
		
		return ResponseEntity.ok(dtoGet);
	}
	
	@Override
	public ResponseEntity<List<DTOGet>> findAllAsDTO(RequestId idContainer) {
		List<DTOGet> list = repositoryService.findAllAsDTO(idContainer);
		
		if(list.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(list);
	}
	
	@Override
	public ResponseEntity<PageResponseBody<DTOGet>> findByPage(Integer pageNumber, Integer pageSize, String columnSort){
		
		Pageable pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(columnSort));
		
		PageResponseBody<DTOGet> pageResponse = repositoryService.findByPage(pageRequest);
		
		if(pageResponse.getListResult().isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(pageResponse);
	}
}




























