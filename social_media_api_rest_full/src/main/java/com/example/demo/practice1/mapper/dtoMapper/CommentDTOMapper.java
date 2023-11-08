package com.example.demo.practice1.mapper.dtoMapper;

import org.springframework.stereotype.Component;

import com.example.demo.practice1.dto.comment.CommentDTOGet;
import com.example.demo.practice1.entities.CommentEntity;

@Component
public class CommentDTOMapper implements DTOMapperInterface<CommentEntity, CommentDTOGet> {

	@Override
	public CommentDTOGet apply(CommentEntity comment) {
		return new CommentDTOGet(
				comment.getUserName(),
				comment.getContent(),
				comment.getPublication().getTitle(),
				comment.getCreationDate()
				);
	}

}
