package com.example.demo.practice1.mapper.entityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.practice1.dto.comment.CommentDTOPost;
import com.example.demo.practice1.entities.CommentEntity;
import com.example.demo.practice1.exception.ResourceNotFoundException;
import com.example.demo.practice1.service.PublicationService;

@Component
public class CommentMapper implements EntityMapperInterface<CommentDTOPost, CommentEntity> {
	@Autowired
	PublicationService publicationService;

	@Override
	public CommentEntity apply(CommentDTOPost commentDTO) throws ResourceNotFoundException{
		return CommentEntity.builder()
				.userName(commentDTO.getUserName())
				.content(commentDTO.getContent())
				.build();
	}

}
