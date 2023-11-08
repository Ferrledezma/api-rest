package com.example.demo.practice2.dto.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommentDTOPost {
	/*Properties*/
	@JsonIgnore
	@Positive
	private Long userId;
	
	@JsonIgnore
	@Positive
	private Long publicationId;
	
	@NotBlank
	private String content;

	/*Constructs*/
	public CommentDTOPost() {
		
	}

	public CommentDTOPost(Long userId, Long publicationId, String content) {
		this.userId = userId;
		this.publicationId = publicationId;
		this.content = content;
	}

	/*Getters*/
	public Long getUserId() {
		return userId;
	}
	public Long getPublicationId() {
		return publicationId;
	}
	public String getContent() {
		return content;
	}

	/*Setters*/
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setPublicationId(Long publicationId) {
		this.publicationId = publicationId;
	}
	
}
