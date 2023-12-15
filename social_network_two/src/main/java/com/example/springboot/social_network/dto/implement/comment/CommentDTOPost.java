package com.example.springboot.social_network.dto.implement.comment;

import com.example.springboot.social_network.dto.models.CommentDTOModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommentDTOPost extends CommentDTOModel {
	@JsonIgnore
	private Long userId;
	@JsonIgnore
	private Long publicationId;

	public CommentDTOPost() {
		
	}
	public CommentDTOPost(String content) {
		super(content);
	}

	public Long getUserId() {
		return userId;
	}

	public Long getPublicationId() {
		return publicationId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setPublicationId(Long publicationId) {
		this.publicationId = publicationId;
	}
	
}
