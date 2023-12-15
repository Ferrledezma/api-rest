package com.example.springboot.social_network.mapper.update.implement;

import org.springframework.stereotype.Component;

import com.example.springboot.social_network.dto.implement.comment.CommentDTOUpdate;
import com.example.springboot.social_network.entities.implement.CommentEntity;
import com.example.springboot.social_network.mapper.update.model.EntityUpdateInterface;

@Component
public class CommentEntityUpdate implements EntityUpdateInterface<CommentEntity, CommentDTOUpdate> {

	@Override
	public void accept(CommentEntity comment, CommentDTOUpdate commentDTOUpdate) {
		if(commentDTOUpdate.getContent() != null && !commentDTOUpdate.getContent().isBlank()) {
			comment.setContent(commentDTOUpdate.getContent());
		}
	}
}
