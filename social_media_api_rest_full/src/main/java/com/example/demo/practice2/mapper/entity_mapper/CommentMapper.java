package com.example.demo.practice2.mapper.entity_mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.practice1.exception.ResourceNotFoundException;
import com.example.demo.practice2.constant.ConstantErrorMessage;
import com.example.demo.practice2.dto.comment.CommentDTOPost;
import com.example.demo.practice2.entities.CommentEntity;
import com.example.demo.practice2.entities.PublicationEntity;
import com.example.demo.practice2.entities.UserEntity;
import com.example.demo.practice2.repository.PublicationRepository;
import com.example.demo.practice2.repository.UserRepository;

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
