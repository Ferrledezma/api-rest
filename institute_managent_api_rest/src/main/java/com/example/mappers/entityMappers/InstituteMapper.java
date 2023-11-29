package com.example.mappers.entityMappers;

import org.springframework.stereotype.Component;

import com.example.dto.instituto.InstituteDTOPost;
import com.example.entities.InstituteEntity;


@Component
public class InstituteMapper implements MapperInterface<InstituteDTOPost, InstituteEntity> {
	@Override
	public InstituteEntity apply(InstituteDTOPost institutoDTOPost) {
		return new InstituteEntity(institutoDTOPost.getName());
	}
}













