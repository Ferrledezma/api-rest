package com.example.springboot.social_network.mapper.dto.implement;

import org.springframework.stereotype.Component;

import com.example.springboot.social_network.dto.implement.publication.PublicationDTOGet;
import com.example.springboot.social_network.entities.implement.PublicationEntity;
import com.example.springboot.social_network.mapper.dto.model.DTOMapperInterface;

@Component
public class PublicationDTOMapper implements DTOMapperInterface<PublicationEntity, PublicationDTOGet> {

	@Override
	public PublicationDTOGet apply(PublicationEntity publication) {
		return new PublicationDTOGet(
				publication.getTitle(),
				publication.getContent(),
				publication.getUser().getIdentifier(),
				publication.getComments().size()
				);
	}

}
