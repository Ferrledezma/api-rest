package com.example.springboot.social_network.mapper.entities.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springboot.social_network.constant.ConstantErrorMessage;
import com.example.springboot.social_network.constant.ConstantTableName;
import com.example.springboot.social_network.dto.implement.publication.PublicationDTOPost;
import com.example.springboot.social_network.entities.implement.PublicationEntity;
import com.example.springboot.social_network.entities.implement.UserEntity;
import com.example.springboot.social_network.exception.ResourceNotFoundException;
import com.example.springboot.social_network.mapper.entities.model.EntityMapperInterface;
import com.example.springboot.social_network.repository.implement.UserRepository;

@Component
public class PublicationMapper implements EntityMapperInterface<PublicationDTOPost, PublicationEntity> {
	@Autowired
	private UserRepository userRepository;

	@Override
	public PublicationEntity apply(PublicationDTOPost publicationDTO) throws ResourceNotFoundException {
		UserEntity user = userRepository.findById(publicationDTO.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException(
						String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, ConstantTableName.PUBLICATION_TABLE_NAME + " " + publicationDTO.getUserId())
						));
		
		return PublicationEntity.builder()
				.title(publicationDTO.getTitle())
				.content(publicationDTO.getContent())
				.user(user)
				.build();
	}

}


























