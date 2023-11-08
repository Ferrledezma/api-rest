package com.example.demo.practice1.dto.publication;

import jakarta.validation.constraints.NotBlank;

public class PublicationDTOPost {
	/*Properties*/
	@NotBlank
	private String title;
	@NotBlank
	private String description;
	@NotBlank
	private String content;

	/*Constructs*/
	public PublicationDTOPost() {
		
	}

	public PublicationDTOPost(String title, String description, String content) {
		this.title = title;
		this.description = description;
		this.content = content;
	}

	/*Methods*/
	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getContent() {
		return content;
	}
	
}
