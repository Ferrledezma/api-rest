package com.example.demo.social_network.mapper.update_entity;

import org.springframework.stereotype.Component;

import com.example.demo.social_network.dto.comment.CommentDTOUpdate;
import com.example.demo.social_network.entities.CommentEntity;

@Component
public class CommentUpdate implements EntityUpdateInterface<CommentEntity, CommentDTOUpdate> {

	@Override
	public void accept(CommentEntity comment, CommentDTOUpdate commentDTO) {
		if(commentDTO.getContent() != null && !commentDTO.getContent().isBlank()) {
			comment.setContent(commentDTO.getContent());
		}
	}

}
