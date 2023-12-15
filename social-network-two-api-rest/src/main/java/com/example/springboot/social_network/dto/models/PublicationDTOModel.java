package com.example.springboot.social_network.dto.models;

import jakarta.validation.constraints.NotBlank;

public abstract class PublicationDTOModel {
	@NotBlank
	private String title;
	@NotBlank
	private String content;

	public PublicationDTOModel() {
		
	}
	public PublicationDTOModel(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}

}
