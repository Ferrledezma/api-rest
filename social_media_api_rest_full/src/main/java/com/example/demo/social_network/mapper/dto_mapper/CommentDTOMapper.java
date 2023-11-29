package com.example.demo.social_network.mapper.dto_mapper;

import org.springframework.stereotype.Component;

import com.example.demo.social_network.dto.comment.CommentDTOGet;
import com.example.demo.social_network.entities.CommentEntity;

@Component
public class CommentDTOMapper implements DTOMapperInterface<CommentEntity, CommentDTOGet> {

	@Override
	public CommentDTOGet apply(CommentEntity comment) {
		return new CommentDTOGet(
				comment.getUser().getUserIdentifier(),
				comment.getPublication().getTitle(),
				comment.getContent()
				);
	}
}
