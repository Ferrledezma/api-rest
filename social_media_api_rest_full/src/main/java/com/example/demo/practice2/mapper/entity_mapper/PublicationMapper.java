package com.example.demo.practice2.mapper.entity_mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.practice1.exception.ResourceNotFoundException;
import com.example.demo.practice2.constant.ConstantErrorMessage;
import com.example.demo.practice2.dto.publication.PublicationDTOPost;
import com.example.demo.practice2.entities.PublicationEntity;
import com.example.demo.practice2.entities.UserEntity;
import com.example.demo.practice2.repository.UserRepository;

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
