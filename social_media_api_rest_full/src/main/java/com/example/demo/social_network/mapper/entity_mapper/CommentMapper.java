package com.example.demo.social_network.mapper.entity_mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.social_network.exception.personalizate_exception.ResourceNotFoundException;
import com.example.demo.social_network.constant.ConstantErrorMessage;
import com.example.demo.social_network.dto.comment.CommentDTOPost;
import com.example.demo.social_network.entities.CommentEntity;
import com.example.demo.social_network.entities.PublicationEntity;
import com.example.demo.social_network.entities.UserEntity;
import com.example.demo.social_network.repository.PublicationRepository;
import com.example.demo.social_network.repository.UserRepository;

@Component
public class CommentMapper implements EntityMapperInterface<CommentDTOPost, CommentEntity> {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PublicationRepository publicationRepository;

	@Override
	public CommentEntity apply(CommentDTOPost commentDTO) {
		
		UserEntity user = userRepository.findById(commentDTO.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException(String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND, commentDTO.getUserId())));
		
		PublicationEntity publication = publicationRepository.findById(commentDTO.getPublicationId())
				.orElseThrow(() -> new ResourceNotFoundException(String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND, commentDTO.getPublicationId())));
		
		return CommentEntity.builder()
				.user(user)
				.publication(publication)
				.content(commentDTO.getContent())
				.build();
	}

}
