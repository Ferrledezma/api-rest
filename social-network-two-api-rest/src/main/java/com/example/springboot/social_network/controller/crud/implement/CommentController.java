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
import com.example.springboot.social_network.dto.implement.comment.CommentDTOGet;
import com.example.springboot.social_network.dto.implement.comment.CommentDTOPost;
import com.example.springboot.social_network.dto.implement.comment.CommentDTOUpdate;
import com.example.springboot.social_network.entities.implement.CommentEntity;
import com.example.springboot.social_network.request.id.RequestId;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping(ConstantPath.COMMENT_PATH)
@Validated
public class CommentController extends CrudModelController<CommentEntity, CommentDTOPost, CommentDTOGet, CommentDTOUpdate> {
	
	@PostMapping(ConstantPath.CREATE)
	public ResponseEntity<CommentEntity> create(
			@NotNull @Positive @PathVariable(name = ConstantParam.USER_PARAM_NAME) Long userId,
			@NotNull @Positive @PathVariable(name = ConstantParam.PUBLICATION_PARAM_NAME) Long publicationId,
			@Valid @RequestBody CommentDTOPost commentDTO
			) {
		
		commentDTO.setUserId(userId);
		commentDTO.setPublicationId(publicationId);
		
		return responseService.create(commentDTO);
	}
	
	@PatchMapping(ConstantPath.UPDATE_BY_IDENTIFIER)
	public ResponseEntity<CommentDTOGet> update(
			@NotNull @Positive @PathVariable(name = ConstantParam.USER_PARAM_NAME) Long userId,
			@NotNull @Positive @PathVariable(name = ConstantParam.PUBLICATION_PARAM_NAME) Long publicationId,
			@NotNull @Positive @PathVariable(name = ConstantParam.MAIN_ID_PARAM) Long commentId,
			@Valid @RequestBody CommentDTOUpdate commentDTO
			){
		
		RequestId containerId = new RequestId(userId, publicationId, commentId);
		
		return responseService.update(containerId, commentDTO);
	}
	
	@DeleteMapping(ConstantPath.DELETE_BY_IDENTIFIER)
	public ResponseEntity<?> delete(
			@NotNull @Positive @PathVariable(name = ConstantParam.USER_PARAM_NAME) Long userId,
			@NotNull @Positive @PathVariable(name = ConstantParam.PUBLICATION_PARAM_NAME) Long publicationId,
			@NotNull @Positive @PathVariable(name = ConstantParam.MAIN_ID_PARAM) Long commentId
			){
		
		RequestId containerId = new RequestId(userId, publicationId, commentId);
		
		return responseService.delete(containerId);
	}
	
	@GetMapping(ConstantPath.FIND_BY_IDENTIFIER)
	public ResponseEntity<CommentDTOGet> find(
			@NotNull @Positive @PathVariable(name = ConstantParam.USER_PARAM_NAME) Long userId,
			@NotNull @Positive @PathVariable(name = ConstantParam.PUBLICATION_PARAM_NAME) Long publicationId,
			@NotNull @Positive @PathVariable(name = ConstantParam.MAIN_ID_PARAM) Long commentId
			){
		
		RequestId containerId = new RequestId(userId, publicationId, commentId);
		
		return responseService.findAsDTO(containerId);
	}
	
	@GetMapping(ConstantPath.FIND_ALL)
	public ResponseEntity<List<CommentDTOGet>> findAll(
			@NotNull @Positive @PathVariable(name = ConstantParam.USER_PARAM_NAME) Long userId,
			@NotNull @Positive @PathVariable(name = ConstantParam.PUBLICATION_PARAM_NAME) Long publicationId
			){
		
		RequestId containerId = new RequestId(userId, publicationId);
		
		return responseService.findAllAsDTO(containerId);
	}
}





















