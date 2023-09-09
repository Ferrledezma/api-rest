package com.example.practica4.mappers.entityMappers;

import org.springframework.stereotype.Component;

import com.example.practica4.dto.instituto.InstituteDTOPost;
import com.example.practica4.entities.InstituteEntity;

@Component
public class InstituteMapper implements MapperInterface<InstituteDTOPost, InstituteEntity> {
	@Override
	public InstituteEntity apply(InstituteDTOPost institutoDTOPost) {
		return new InstituteEntity(institutoDTOPost.getName());
	}
}













