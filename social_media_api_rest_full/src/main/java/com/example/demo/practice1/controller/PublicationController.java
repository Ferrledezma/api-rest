package com.example.demo.practice1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.practice1.constant.ConstantParamName;
import com.example.demo.practice1.constant.ConstantRoute;
import com.example.demo.practice1.dto.publication.PublicationDTOGet;
import com.example.demo.practice1.dto.publication.PublicationDTOPost;
import com.example.demo.practice1.dto.publication.PublicationDTOUpdate;
import com.example.demo.practice1.entities.PublicationEntity;
import com.example.demo.practice1.service.PublicationService;

@RestController
@RequestMapping(value = ConstantRoute.PUBLICATION_ROUTE)

public class PublicationController extends CrudModelController<PublicationEntity, PublicationDTOPost, PublicationDTOGet, PublicationDTOUpdate> {
	@Autowired
	PublicationService publicationService;

	@GetMapping(value = ConstantRoute.FIND_BY_PAGE)
	public ResponseEntity<List<PublicationDTOGet>> findByPage(
			@RequestParam(value = ConstantParamName.PAGE_NUMBER_PARAM_NAME, defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = ConstantParamName.PAGE_SIZE_PARAM_NAME, defaultValue = "5", required = false) Integer pageSize,
			@RequestParam(value = ConstantParamName.PAGE_ORDER_PARAM_NAME, defaultValue = ConstantParamName.ID_NAME, required = false) String columnNameToSort) {
		
		List<PublicationDTOGet> publicationDTOList = publicationService.findPublicationByPage(pageNumber, pageSize, columnNameToSort);
		
		if(publicationDTOList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(publicationDTOList);
	}
}


















