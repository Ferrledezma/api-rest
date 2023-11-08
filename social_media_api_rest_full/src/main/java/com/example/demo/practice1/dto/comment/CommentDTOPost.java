package com.example.demo.practice1.dto.comment;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotBlank;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommentDTOPost {
	/*Properties*/
	@NotBlank
	private String userName;
	
	@NotBlank
	private String content;

	/*Constructs*/
	public CommentDTOPost() {
		
	}
	
	public CommentDTOPost(String userName, String content) {
		this.userName = userName;
		this.content = content;
	}

	/*Methods*/
	public String getUserName() {
		return userName;
	}
	public String getContent() {
		return content;
	}
	
}
