package com.example.demo.practice1.mapper.updateEntity;

import org.springframework.stereotype.Component;

import com.example.demo.practice1.dto.publication.PublicationDTOUpdate;
import com.example.demo.practice1.entities.PublicationEntity;

@Component
public class PublicationUpdate implements UpdateEntityInterface<PublicationEntity, PublicationDTOUpdate> {

	@Override
	public void accept(PublicationEntity publication, PublicationDTOUpdate publicationDTO) {
		if(publicationDTO.getTitle() != null && !publicationDTO.getTitle().isBlank()) {
			publication.setTitle(publicationDTO.getTitle());
		}
		if(publicationDTO.getDescription() != null && !publicationDTO.getDescription().isBlank()) {
			publication.setDescription(publicationDTO.getDescription());
		}
		if(publicationDTO.getContent() != null && !publicationDTO.getContent().isBlank()) {
			publication.setContent(publicationDTO.getContent());
		}
	}
}
