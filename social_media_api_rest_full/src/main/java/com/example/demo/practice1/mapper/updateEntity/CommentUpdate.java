package com.example.demo.practice1.mapper.updateEntity;

import org.springframework.stereotype.Component;

import com.example.demo.practice1.dto.comment.CommentDTOUpdate;
import com.example.demo.practice1.entities.CommentEntity;

@Component
public class CommentUpdate implements UpdateEntityInterface<CommentEntity, CommentDTOUpdate> {

	@Override
	public void accept(CommentEntity comment, CommentDTOUpdate commentDTO) {
		if(commentDTO.getUserName() != null && !commentDTO.getUserName().isBlank()) {
			comment.setUserName(commentDTO.getUserName());
		}
		if(commentDTO.getContent() != null && !commentDTO.getContent().isBlank()) {
			comment.setContent(commentDTO.getContent());
		}
	}

}
