package com.example.demo.social_network.mapper.update_entity;

import org.springframework.stereotype.Component;

import com.example.demo.social_network.dto.publication.PublicationDTOUpdate;
import com.example.demo.social_network.entities.PublicationEntity;

@Component
public class PublicationUpdate implements EntityUpdateInterface<PublicationEntity, PublicationDTOUpdate> {

	@Override
	public void accept(PublicationEntity publication, PublicationDTOUpdate publicationDTO) {
		if(publicationDTO.getTitle() != null && !publicationDTO.getTitle().isBlank()) {
			publication.setTitle(publicationDTO.getTitle());
		}
		if(publicationDTO.getContent() != null && !publicationDTO.getContent().isBlank()) {
			publication.setContent(publicationDTO.getContent());
		}
	}
}
