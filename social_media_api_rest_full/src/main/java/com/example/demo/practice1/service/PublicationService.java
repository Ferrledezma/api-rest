package com.example.demo.practice1.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.practice1.dto.publication.PublicationDTOGet;
import com.example.demo.practice1.dto.publication.PublicationDTOPost;
import com.example.demo.practice1.dto.publication.PublicationDTOUpdate;
import com.example.demo.practice1.entities.PublicationEntity;

@Service
public class PublicationService extends ServiceModel<PublicationEntity, PublicationDTOPost, PublicationDTOGet, PublicationDTOUpdate> {
	
	public List<PublicationDTOGet> findPublicationByPage(Integer pageNumber, Integer pageSize, String columnNameToSort){
		//Forma de hacer consulta a través de la url: http://localhost:8080/api/publicacion/findByPage?numero_pagina=0&tamaño_pagina=2&ordenamiento=id
		//Sort sorted = Sort.by(Sort.Order.asc(columnNameToSort));
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(columnNameToSort).ascending());
		
		return getRepository().findAll(pageable)
				.map(getDtoMapper())
				.getContent();
	}
}
