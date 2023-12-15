package com.example.springboot.social_network.dto.models;

import jakarta.validation.constraints.NotBlank;

public abstract class CommentDTOModel{
	@NotBlank
	private String content;

	public CommentDTOModel() {
		
	}
	public CommentDTOModel(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}
