package com.example.springboot.social_network.mapper.entities.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springboot.social_network.constant.ConstantErrorMessage;
import com.example.springboot.social_network.constant.ConstantTableName;
import com.example.springboot.social_network.dto.implement.comment.CommentDTOPost;
import com.example.springboot.social_network.entities.implement.CommentEntity;
import com.example.springboot.social_network.entities.implement.PublicationEntity;
import com.example.springboot.social_network.entities.implement.UserEntity;
import com.example.springboot.social_network.exception.ResourceNotFoundException;
import com.example.springboot.social_network.mapper.entities.model.EntityMapperInterface;
import com.example.springboot.social_network.repository.implement.PublicationRepository;
import com.example.springboot.social_network.repository.implement.UserRepository;

@Component
public class CommentMapper implements EntityMapperInterface<CommentDTOPost, CommentEntity> {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PublicationRepository publicationRepository;

	@Override
	public CommentEntity apply(CommentDTOPost commentDTO) throws ResourceNotFoundException {
		UserEntity user = userRepository.findById(commentDTO.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException(
						String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, ConstantTableName.USER_TABLE_NAME + " " + commentDTO.getUserId())
						));
		
		PublicationEntity publication = publicationRepository.findById(commentDTO.getPublicationId())
				.orElseThrow(() -> new ResourceNotFoundException(
						String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, ConstantTableName.PUBLICATION_TABLE_NAME + " " + commentDTO.getPublicationId())
						));
		
		return CommentEntity.builder()
				.user(user)
				.publication(publication)
				.content(commentDTO.getContent())
				.build();
	}
}


























