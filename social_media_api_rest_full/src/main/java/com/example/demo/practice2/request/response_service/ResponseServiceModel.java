package com.example.demo.practice2.request.response_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.practice2.constant.ConstantParamName;
import com.example.demo.practice2.constant.ConstantPath;
import com.example.demo.practice2.entities.EntityModel;
import com.example.demo.practice2.exception.personalizate_exception.NoRelationException;
import com.example.demo.practice2.exception.personalizate_exception.ResourceNotFoundException;
import com.example.demo.practice2.request.container_request_id.ContainerIdModel;
import com.example.demo.practice2.request.response_body.PageResponseBody;
import com.example.demo.practice2.service.ServiceInterface;

public abstract class ResponseServiceModel<Entity extends EntityModel, DTOPost, DTOGet, DTOUpdate, ContainerID extends ContainerIdModel>
implements ResponseServiceInterface<Entity, DTOPost, DTOGet, DTOUpdate, ContainerID>{
	@Autowired
	private ServiceInterface<Entity, DTOPost, DTOGet, DTOUpdate, ContainerID> service;

	@Override
	public ResponseEntity<Entity> create(DTOPost dtoPost) {
		Entity entity = service.createResource(dtoPost);
		
		HttpHeaders header = new HttpHeaders();
		
		String location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path(ConstantPath.MAIN_ID_IDENTIFIER)
				.buildAndExpand(ConstantParamName.MAIN_ID_NAME)
				.toString();
		
		header.add("location", location);
		
		return new ResponseEntity<>(entity, header, HttpStatus.CREATED);
	}
	
	@Override
	public ResponseEntity<DTOGet> update(ContainerID containerId, DTOUpdate dtoupdate) throws ResourceNotFoundException, NoRelationException {
		DTOGet dtoGet = service.updateResource(containerId, dtoupdate);
		
		return new ResponseEntity<>(dtoGet, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<?> delete(ContainerID containerId) throws ResourceNotFoundException , NoRelationException{
		service.deleteResource(containerId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@Override
	public ResponseEntity<DTOGet> find(ContainerID containerId) throws ResourceNotFoundException, NoRelationException {
		DTOGet dtoGet = service.findResourceAsDTO(containerId);
		return new ResponseEntity<>(dtoGet, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<List<DTOGet>> findAll(){
		List<DTOGet> dtoList = service.findAllResourceAsDTO();
		
		if(dtoList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<List<DTOGet>> findAll(ContainerID containerID) throws ResourceNotFoundException, NoRelationException {
		List<DTOGet> dtoList = service.findAllResourceAsDTO(containerID);
		
		if(dtoList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<PageResponseBody<DTOGet>> findByPage(Integer pageNumber, Integer pageSize, String columnSort){
		
		PageResponseBody<DTOGet> pageResponse = service.findByPage(pageNumber, pageSize, columnSort);
		
		if(pageResponse.getDtoList().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(pageResponse, HttpStatus.OK);
	}
}











