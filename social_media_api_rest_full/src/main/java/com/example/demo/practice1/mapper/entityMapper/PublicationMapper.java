package com.example.demo.practice1.mapper.entityMapper;

import org.springframework.stereotype.Component;

import com.example.demo.practice1.dto.publication.PublicationDTOPost;
import com.example.demo.practice1.entities.PublicationEntity;

@Component
public class PublicationMapper implements EntityMapperInterface<PublicationDTOPost, PublicationEntity> {

	@Override
	public PublicationEntity apply(PublicationDTOPost publicationDTO) {
		return PublicationEntity.builder()
				.title(publicationDTO.getTitle())
				.description(publicationDTO.getDescription())
				.content(publicationDTO.getContent())
				.build();
	}
}
