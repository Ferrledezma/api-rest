package com.example.demo.practice2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.practice2.constant.ConstantParamName;
import com.example.demo.practice2.constant.ConstantPath;
import com.example.demo.practice2.constant.ConstantTableName;
import com.example.demo.practice2.dto.publication.PublicationDTOGet;
import com.example.demo.practice2.dto.publication.PublicationDTOPost;
import com.example.demo.practice2.dto.publication.PublicationDTOUpdate;
import com.example.demo.practice2.entities.PublicationEntity;
import com.example.demo.practice2.exception.personalizate_exception.NoRelationException;
import com.example.demo.practice2.exception.personalizate_exception.ResourceNotFoundException;
import com.example.demo.practice2.request.container_request_id.ContainerPublicationId;
import com.example.demo.practice2.request.response_service.PublicationResponseService;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping(value = ConstantPath.PUBLICATION_PATH)
@Validated
public class PublicationController {
	@Autowired
	private PublicationResponseService publicationResponseService;

	@PostMapping(value = ConstantPath.CREATE_PATH)
	public ResponseEntity<PublicationEntity> create(
			@NotNull @Positive @PathVariable(name = ConstantParamName.SUB_SECOND_ID) @RequestParam(value = ConstantTableName.USER_COLUMN_ID) long userId,
			@Valid @RequestBody PublicationDTOPost publicationDTO) throws ConstraintViolationException {
		
		publicationDTO.setUserId(userId);
		
		return publicationResponseService.create(publicationDTO);
	}
	
	@PatchMapping(value = ConstantPath.UPDATE_PATH)
	public ResponseEntity<PublicationDTOGet> update(
			@NotNull @Positive  @PathVariable(name = ConstantParamName.SUB_SECOND_ID) @RequestParam(value = ConstantTableName.USER_COLUMN_ID) Long userId,
			@NotNull @Positive @PathVariable(name = ConstantParamName.MAIN_ID_NAME) @RequestParam(value = ConstantTableName.PUBLICATION_COLUMN_ID) Long publicationId,
			@Valid @RequestBody PublicationDTOUpdate publicationDTO) throws ConstraintViolationException, ResourceNotFoundException, NoRelationException {
		
		ContainerPublicationId containerId = new ContainerPublicationId(userId, publicationId);
		
		return publicationResponseService.update(containerId, publicationDTO);
	}
	
	@DeleteMapping(value = ConstantPath.DELETE_PATH)
	public ResponseEntity<?> delete(
			@NotNull @Positive @PathVariable(name = ConstantParamName.SUB_SECOND_ID) @RequestParam(value = ConstantTableName.USER_COLUMN_ID) Long userId,
			@NotNull @Positive @PathVariable(name = ConstantParamName.MAIN_ID_NAME) @RequestParam(value = ConstantTableName.PUBLICATION_COLUMN_ID) Long publicationId)
	throws ConstraintViolationException, ResourceNotFoundException, NoRelationException {
		
		ContainerPublicationId containerId = new ContainerPublicationId(userId, publicationId);
		
		return publicationResponseService.delete(containerId);
	}
	
	@GetMapping(value = ConstantPath.FIND_PATH)
	public ResponseEntity<PublicationDTOGet> find(
			@NotNull @Positive @PathVariable(name = ConstantParamName.SUB_SECOND_ID) @RequestParam(value = ConstantTableName.USER_COLUMN_ID) Long userId,
			@NotNull @Positive @PathVariable(name = ConstantParamName.MAIN_ID_NAME) @RequestParam(value = ConstantTableName.PUBLICATION_COLUMN_ID) Long publicationId
			) throws ConstraintViolationException, ResourceNotFoundException, NoRelationException {
		
		ContainerPublicationId containerId = new ContainerPublicationId(userId, publicationId);
		
		return publicationResponseService.find(containerId);
	}
	
	@GetMapping(value = ConstantPath.FIND_ALL_PATH)
	public ResponseEntity<List<PublicationDTOGet>> findAll(
			@NotNull @Positive @PathVariable(name = ConstantParamName.SUB_SECOND_ID) @RequestParam(value = ConstantTableName.USER_COLUMN_ID) Long userId)
	throws ConstraintViolationException, ResourceNotFoundException, NoRelationException {
		
		ContainerPublicationId containerId = new ContainerPublicationId(userId);
		
		return publicationResponseService.findAll(containerId);
	}
}



















