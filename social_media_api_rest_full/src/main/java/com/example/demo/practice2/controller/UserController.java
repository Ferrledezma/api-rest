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
import com.example.demo.practice2.dto.user.UserDTOGet;
import com.example.demo.practice2.dto.user.UserDTOPost;
import com.example.demo.practice2.dto.user.UserDTOUpdate;
import com.example.demo.practice2.entities.UserEntity;
import com.example.demo.practice2.exception.personalizate_exception.ResourceNotFoundException;
import com.example.demo.practice2.request.container_request_id.ContainerUserId;
import com.example.demo.practice2.request.response_body.PageResponseBody;
import com.example.demo.practice2.request.response_service.UserResponseService;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping(value = ConstantPath.USER_PATH)
@Validated
public class UserController {
	@Autowired
	UserResponseService userResponseService;

	@PostMapping(value = ConstantPath.CREATE_PATH)
	public ResponseEntity<UserEntity> create(@Valid @RequestBody UserDTOPost userDTO) throws ConstraintViolationException{
		return userResponseService.create(userDTO);
	}
	
	@PatchMapping(value = ConstantPath.UPDATE_PATH)
	public ResponseEntity<UserDTOGet> update(@NotNull @Positive @PathVariable(name = ConstantParamName.MAIN_ID_NAME) Long id, @Valid @RequestBody UserDTOUpdate userDTOUpdate)
	throws ConstraintViolationException, ResourceNotFoundException {
		
		ContainerUserId containerId = new ContainerUserId(id);
		
		return userResponseService.update(containerId, userDTOUpdate);
	}
	
	@DeleteMapping(value = ConstantPath.DELETE_PATH)
	public ResponseEntity<?> delete(@NotNull @Positive @PathVariable(name = ConstantParamName.MAIN_ID_NAME) Long id)
	throws ConstraintViolationException, ResourceNotFoundException {
		
		ContainerUserId containerId = new ContainerUserId(id);
		
		return userResponseService.delete(containerId);
	}
	
	@GetMapping(value = ConstantPath.FIND_PATH)
	public ResponseEntity<UserDTOGet> find(@NotNull @Positive @PathVariable(name = ConstantParamName.MAIN_ID_NAME) Long id)
	throws ConstraintViolationException, ResourceNotFoundException{
		ContainerUserId containerId = new ContainerUserId(id);
		
		return userResponseService.find(containerId);
	}
	
	@GetMapping(value = ConstantPath.FIND_ALL_PATH)
	public ResponseEntity<List<UserDTOGet>> findAll(){
		return userResponseService.findAll();
	}
	
	@GetMapping(value = ConstantPath.FIND_ALL_BY_PAGE_PATH)
	public ResponseEntity<PageResponseBody<UserDTOGet>> findAllasDTOByPage(
			@NotNull @RequestParam(value = "page_number", defaultValue = "0", required = false) Integer pageNumber,
			@NotNull @RequestParam(value = "page_size", defaultValue = "4", required = false) Integer pageSize,
			@NotNull @RequestParam(value = "sort_by", defaultValue = ConstantTableName.ID_NAME, required = false) String columnSort
			) throws ConstraintViolationException {
		
		return userResponseService.findByPage(pageNumber, pageSize, columnSort);
	}
}



















