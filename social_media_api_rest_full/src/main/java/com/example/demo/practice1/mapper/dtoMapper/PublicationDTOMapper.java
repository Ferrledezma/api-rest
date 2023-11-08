package com.example.demo.practice1.mapper.dtoMapper;

import org.springframework.stereotype.Component;

import com.example.demo.practice1.dto.publication.PublicationDTOGet;
import com.example.demo.practice1.entities.PublicationEntity;

@Component
public class PublicationDTOMapper implements DTOMapperInterface<PublicationEntity, PublicationDTOGet> {

	@Override
	public PublicationDTOGet apply(PublicationEntity publication) {
		return new PublicationDTOGet(
				publication.getTitle(),
				publication.getDescription(),
				publication.getContent(),
				publication.getComments().size(),
				publication.getCreationDate()
				);
	}
}
