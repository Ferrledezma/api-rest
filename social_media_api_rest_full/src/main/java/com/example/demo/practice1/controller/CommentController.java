package com.example.demo.practice1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.practice1.constant.ConstantParamName;
import com.example.demo.practice1.constant.ConstantRoute;
import com.example.demo.practice1.dto.comment.CommentDTOGet;
import com.example.demo.practice1.dto.comment.CommentDTOPost;
import com.example.demo.practice1.dto.comment.CommentDTOUpdate;
import com.example.demo.practice1.exception.NotValidRelationException;
import com.example.demo.practice1.exception.ResourceNotFoundException;
import com.example.demo.practice1.repository.PublicationRepository;
import com.example.demo.practice1.service.CommentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping(value = ConstantRoute.COMMENT_ROUTE)
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@Autowired
	PublicationRepository publicationRepository;

	@PostMapping(value = ConstantRoute.CREATED_ROUTE)
	public ResponseEntity<CommentDTOGet> create(
			@PathVariable(name = ConstantParamName.SUB_ID_NAME) @NotNull @Positive Long publicationId,
			@Valid @RequestBody CommentDTOPost commentDTO,
			HttpServletRequest request) throws ConstraintViolationException, ResourceNotFoundException, NotValidRelationException {
		
		CommentDTOGet commentDTOGet = commentService.createResource(publicationId, commentDTO);
		
		HttpHeaders header = new HttpHeaders();
		String location = request.getRequestURI();
		
		header.add("location", location);
		
		return new ResponseEntity<>(commentDTOGet, header, HttpStatus.CREATED);
	}
	
	@PatchMapping(value = ConstantRoute.UPDATE_ROUTE)
	public ResponseEntity<CommentDTOGet> update(
			@PathVariable(name = ConstantParamName.SUB_ID_NAME) @NotNull @Positive Long publicationId,
			@PathVariable(name = ConstantParamName.ID_NAME) @NotNull @Positive Long commentId,
			@RequestBody @Valid CommentDTOUpdate commentDTO) throws ConstraintViolationException, NotValidRelationException, ResourceNotFoundException {
		
		commentService.existsPublicationComment(commentId, publicationId);
		CommentDTOGet commentDTOUpdate = commentService.updateResource(commentId, commentDTO);
		
		return new ResponseEntity<>(commentDTOUpdate, HttpStatus.OK);
	}
	
	@DeleteMapping(value = ConstantRoute.DELETE_ROUTE)
	public ResponseEntity<?> delete(
			@PathVariable(name = ConstantParamName.SUB_ID_NAME) @NotNull @Positive Long publicationId,
			@PathVariable(name = ConstantParamName.ID_NAME) @NotNull @Positive Long commentId)
	throws ConstraintViolationException, NotValidRelationException, ResourceNotFoundException {
		
		commentService.existsPublicationComment(commentId, publicationId);
		commentService.deleteResource(commentId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = ConstantRoute.FIND_ROUTE)
	public ResponseEntity<CommentDTOGet> find(
			@PathVariable(name = ConstantParamName.SUB_ID_NAME) @NotNull @Positive Long publicationId,
			@PathVariable(name = ConstantParamName.ID_NAME) @NotNull @Positive Long commentId)
	throws ConstraintViolationException, NotValidRelationException, ResourceNotFoundException {
		
		commentService.existsPublicationComment(commentId, publicationId);
		CommentDTOGet commentDTO = commentService.findResourceAsDTO(commentId);
		
		return new ResponseEntity<>(commentDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = ConstantRoute.FIND_ALL_ROUTE)
	public ResponseEntity<List<CommentDTOGet>> findPublicationComments(@PathVariable(name = ConstantParamName.SUB_ID_NAME) @NotNull @Positive Long publicationId)
	throws ConstraintViolationException, ResourceNotFoundException{
		List<CommentDTOGet> commentDTOList = commentService.findPublicationComments(publicationId);
		
		if(commentDTOList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(commentDTOList, HttpStatus.OK);
	}
}














