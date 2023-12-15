package com.example.springboot.social_network.mapper.dto.implement;

import org.springframework.stereotype.Component;

import com.example.springboot.social_network.dto.implement.comment.CommentDTOGet;
import com.example.springboot.social_network.entities.implement.CommentEntity;
import com.example.springboot.social_network.mapper.dto.model.DTOMapperInterface;

@Component
public class CommentDTOMapper implements DTOMapperInterface<CommentEntity, CommentDTOGet> {

	@Override
	public CommentDTOGet apply(CommentEntity comment) {
		return new CommentDTOGet(
				comment.getContent(),
				comment.getUser().getIdentifier(),
				comment.getPublication().getTitle(),
				comment.getPublication().getUser().getIdentifier()
				);
	}

}
