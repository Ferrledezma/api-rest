package com.example.springboot.social_network.controller.crud.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.social_network.constant.ConstantParam;
import com.example.springboot.social_network.constant.ConstantPath;
import com.example.springboot.social_network.controller.crud.model.CrudModelController;
import com.example.springboot.social_network.dto.implement.publication.PublicationDTOGet;
import com.example.springboot.social_network.dto.implement.publication.PublicationDTOPost;
import com.example.springboot.social_network.dto.implement.publication.PublicationDTOUpdate;
import com.example.springboot.social_network.entities.implement.PublicationEntity;
import com.example.springboot.social_network.request.id.RequestId;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping(ConstantPath.PUBLICATION_PATH)
@Validated
public class PublicationCrudController extends CrudModelController<PublicationEntity, PublicationDTOPost, PublicationDTOGet, PublicationDTOUpdate> {
	
	@PostMapping(ConstantPath.CREATE)
	public ResponseEntity<PublicationEntity> create(
			@NotNull @Positive @PathVariable(name = ConstantParam.USER_PARAM_NAME) Long userId,
			@Valid @RequestBody PublicationDTOPost publicationDTO){
		
		publicationDTO.setUserId(userId);
		
		return responseService.create(publicationDTO);
	}
	
	@PatchMapping(ConstantPath.UPDATE_BY_IDENTIFIER)
	public ResponseEntity<PublicationDTOGet> update(
			@NotNull @Positive @PathVariable(name = ConstantParam.USER_PARAM_NAME) Long userId,
			@NotNull @Positive @PathVariable(name = ConstantParam.MAIN_ID_PARAM) Long publicationId,
			@Valid @RequestBody PublicationDTOUpdate publicationDTO){
		
		RequestId containerId = new RequestId(userId, publicationId);
		
		return responseService.update(containerId, publicationDTO);
	}
	
	@DeleteMapping(ConstantPath.DELETE_BY_IDENTIFIER)
	public ResponseEntity<?> delete(
			@NotNull @Positive @PathVariable(name = ConstantParam.USER_PARAM_NAME) Long userId,
			@NotNull @Positive @PathVariable(name = ConstantParam.MAIN_ID_PARAM) Long publicationId
			){
		RequestId containerId = new RequestId(userId, publicationId);
		
		return responseService.delete(containerId);
	}
	
	@GetMapping(ConstantPath.FIND_BY_IDENTIFIER)
	public ResponseEntity<PublicationDTOGet> find(
			@NotNull @Positive @PathVariable(name = ConstantParam.USER_PARAM_NAME) Long userId,
			@NotNull @Positive @PathVariable(name = ConstantParam.MAIN_ID_PARAM) Long publicationId
			){
		RequestId containerId = new RequestId(userId, publicationId);
		
		return responseService.findAsDTO(containerId);
	}
	
	@GetMapping(ConstantPath.FIND_ALL)
	public ResponseEntity<List<PublicationDTOGet>> findAll(
			@NotNull @Positive @PathVariable(name = ConstantParam.USER_PARAM_NAME) Long userId
			){
		RequestId containerId = new RequestId(userId);
		
		return responseService.findAllAsDTO(containerId);
	}
}




















