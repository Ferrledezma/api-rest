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

import com.example.demo.practice1.exception.NotValidRelationException;
import com.example.demo.practice1.exception.ResourceNotFoundException;
import com.example.demo.practice2.constant.ConstantParamName;
import com.example.demo.practice2.constant.ConstantPath;
import com.example.demo.practice2.constant.ConstantTableName;
import com.example.demo.practice2.dto.comment.CommentDTOGet;
import com.example.demo.practice2.dto.comment.CommentDTOPost;
import com.example.demo.practice2.dto.comment.CommentDTOUpdate;
import com.example.demo.practice2.entities.CommentEntity;
import com.example.demo.practice2.exception.personalizate_exception.NoRelationException;
import com.example.demo.practice2.request.container_request_id.ContainerCommentId;
import com.example.demo.practice2.request.response_service.CommentResponseService;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping(value = ConstantPath.COMMENT_PATH)
@Validated
public class CommentController {
	@Autowired
	private CommentResponseService commentResponseService;

	@PostMapping(value = ConstantPath.CREATE_PATH)
	public ResponseEntity<CommentEntity> create(
			@NotNull @Positive @PathVariable(name = ConstantParamName.SUB_THIRD_ID) @RequestParam(value = ConstantParamName.USER_POST_COMMENT_JSON_NAME) Long userId,
			@NotNull @Positive @PathVariable(name = ConstantParamName.SUB_SECOND_ID) @RequestParam(value = ConstantTableName.PUBLICATION_COLUMN_ID) Long publicationId,
			@Valid @RequestBody CommentDTOPost commentDTO
			) throws ConstraintViolationException, NoRelationException, ResourceNotFoundException {
		
		commentDTO.setUserId(userId);
		commentDTO.setPublicationId(publicationId);
		
		return commentResponseService.create(commentDTO);
	}
	
	@PatchMapping(value = ConstantPath.UPDATE_PATH)
	public ResponseEntity<CommentDTOGet> update(
			@NotNull @Positive @PathVariable(name = ConstantParamName.SUB_THIRD_ID) @RequestParam(value = ConstantParamName.USER_POST_COMMENT_JSON_NAME) Long userId,
			@NotNull @Positive @PathVariable(name = ConstantParamName.SUB_SECOND_ID) @RequestParam(value = ConstantTableName.PUBLICATION_COLUMN_ID) Long publicationId,
			@NotNull @Positive @PathVariable(name = ConstantParamName.MAIN_ID_NAME) @RequestParam(value = ConstantParamName.COMMENT_JSON_PARAM_NAME) Long commentId,
			@Valid @RequestBody CommentDTOUpdate commentDTO
			) throws ConstraintViolationException, ResourceNotFoundException, NoRelationException {
		
		ContainerCommentId containerId = new ContainerCommentId(userId, publicationId, commentId);
		
		return commentResponseService.update(containerId, commentDTO);
	}
	
	@DeleteMapping(value = ConstantPath.DELETE_PATH)
	public ResponseEntity<?> delete(
			@NotNull @Positive @PathVariable(name = ConstantParamName.SUB_THIRD_ID) @RequestParam(value = ConstantParamName.USER_POST_COMMENT_JSON_NAME) Long userId,
			@NotNull @Positive @PathVariable(name = ConstantParamName.SUB_SECOND_ID) @RequestParam(value = ConstantTableName.PUBLICATION_COLUMN_ID) Long publicationId,
			@NotNull @Positive @PathVariable(name = ConstantParamName.MAIN_ID_NAME) @RequestParam(value = ConstantParamName.COMMENT_JSON_PARAM_NAME) Long commentId
			) throws ConstraintViolationException, ResourceNotFoundException, NotValidRelationException {
		
		ContainerCommentId containerId = new ContainerCommentId(userId, publicationId, commentId);
		
		return commentResponseService.delete(containerId);
	}
	
	@GetMapping(value = ConstantPath.FIND_PATH)
	public ResponseEntity<CommentDTOGet> find(
			@NotNull @Positive @PathVariable(name = ConstantParamName.SUB_THIRD_ID) @RequestParam(value = ConstantParamName.USER_POST_COMMENT_JSON_NAME) Long userId,
			@NotNull @Positive @PathVariable(name = ConstantParamName.SUB_SECOND_ID) @RequestParam(value = ConstantTableName.PUBLICATION_COLUMN_ID) Long publicationId,
			@NotNull @Positive @PathVariable(name = ConstantParamName.MAIN_ID_NAME) @RequestParam(value = ConstantParamName.COMMENT_JSON_PARAM_NAME) Long commentId
			) throws ConstraintViolationException, ResourceNotFoundException, NotValidRelationException {
		
		ContainerCommentId containerId = new ContainerCommentId(userId, publicationId, commentId);
		
		return commentResponseService.find(containerId);
	}
	
	@GetMapping(value = ConstantPath.FIND_ALL_PATH)
	public ResponseEntity<List<CommentDTOGet>> findAll(
			@NotNull @Positive @PathVariable(name = ConstantParamName.SUB_THIRD_ID) @RequestParam(value = ConstantParamName.USER_POST_COMMENT_JSON_NAME) Long userId,
			@NotNull @Positive @PathVariable(name = ConstantParamName.SUB_SECOND_ID) @RequestParam(value = ConstantTableName.PUBLICATION_COLUMN_ID) Long publicationId
			) throws ConstraintViolationException, ResourceNotFoundException, NotValidRelationException {
		
		ContainerCommentId containerId = new ContainerCommentId(userId, publicationId);
		
		return commentResponseService.findAll(containerId);
	}
}




















