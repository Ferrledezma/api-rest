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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.social_network.constant.ConstantColumnName;
import com.example.springboot.social_network.constant.ConstantParam;
import com.example.springboot.social_network.constant.ConstantPath;
import com.example.springboot.social_network.controller.crud.model.CrudModelController;
import com.example.springboot.social_network.dto.implement.user.UserDTOGet;
import com.example.springboot.social_network.dto.implement.user.UserDTOPost;
import com.example.springboot.social_network.dto.implement.user.UserDTOUpdate;
import com.example.springboot.social_network.entities.implement.UserEntity;
import com.example.springboot.social_network.request.id.RequestId;
import com.example.springboot.social_network.request.response.PageResponseBody;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@RestController
@RequestMapping(value = ConstantPath.USER_PATH)
@Validated
public class UserCrudController extends CrudModelController<UserEntity, UserDTOPost, UserDTOGet, UserDTOUpdate> {
	
	@PostMapping(ConstantPath.CREATE)
	public ResponseEntity<UserEntity> create(@Valid @RequestBody UserDTOPost userDTO) {
		return responseService.create(userDTO);
	}
	
	@PatchMapping(ConstantPath.UPDATE_BY_IDENTIFIER)
	public ResponseEntity<UserDTOGet> update(
			@NotNull @Positive @PathVariable(name = ConstantParam.MAIN_ID_PARAM) Long userId,
			@Valid @RequestBody UserDTOUpdate userDTO) {
		RequestId containerId = new RequestId(userId);
		return responseService.update(containerId, userDTO);
	}
	
	@DeleteMapping(ConstantPath.DELETE_BY_IDENTIFIER)
	public ResponseEntity<?> delete(@NotNull @Positive @PathVariable(name = ConstantParam.MAIN_ID_PARAM) Long userId) {
		RequestId containerId = new RequestId(userId);
		return responseService.delete(containerId);
	}
	
	@GetMapping(ConstantPath.FIND_BY_IDENTIFIER)
	public ResponseEntity<UserDTOGet> find(@NotNull @Positive @PathVariable(name = ConstantParam.MAIN_ID_PARAM) Long userId) {
		RequestId containerId = new RequestId(userId);
		return responseService.findAsDTO(containerId);
	}
	
	@GetMapping(ConstantPath.FIND_ALL)
	public ResponseEntity<List<UserDTOGet>> findAll(){
		return responseService.findAllAsDTO(null);
	}
	
	@GetMapping(ConstantPath.FIND_BY_PAGE)
	public ResponseEntity<PageResponseBody<UserDTOGet>> findByPage(
			@NotNull @PositiveOrZero @RequestParam(value = "page_number", defaultValue = "0", required = false) Integer pageNumber,
			@NotNull @Positive @RequestParam(value = "page_size", defaultValue = "5", required = false) Integer pageSize,
			@NotNull @RequestParam(value = "column_sort", defaultValue = ConstantColumnName.ID_COLUMN_NAME, required = false) String columnSort
			){
		
		return responseService.findByPage(pageNumber, pageSize, columnSort);
	}
}



















