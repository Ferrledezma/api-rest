package com.example.demo.social_network.mapper.entity_mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.social_network.exception.personalizate_exception.ResourceNotFoundException;
import com.example.demo.social_network.constant.ConstantErrorMessage;
import com.example.demo.social_network.dto.publication.PublicationDTOPost;
import com.example.demo.social_network.entities.PublicationEntity;
import com.example.demo.social_network.entities.UserEntity;
import com.example.demo.social_network.repository.UserRepository;

@Component
public class PublicationMapper implements EntityMapperInterface<PublicationDTOPost, PublicationEntity> {
	@Autowired
	private UserRepository userRepository;

	@Override
	public PublicationEntity apply(PublicationDTOPost publicationDTO) {
		UserEntity user = userRepository.findById(publicationDTO.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException(String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND, publicationDTO.getUserId())));
		
		return PublicationEntity.builder()
					.user(user)
					.title(publicationDTO.getTitle())
					.content(publicationDTO.getContent())
					.build();
	}

}
