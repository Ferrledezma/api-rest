package com.example.demo.practice2.dto.publication;

import jakarta.validation.constraints.NotBlank;

public abstract class PublicationDTO {
	/*Properties*/
	@NotBlank
	private String title;
	@NotBlank
	private String content;

	/*Constructs*/
	public PublicationDTO() {
		
	}
	public PublicationDTO(@NotBlank String title, @NotBlank String content) {
		this.title = title;
		this.content = content;
	}

	/*Getters*/
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	
}
