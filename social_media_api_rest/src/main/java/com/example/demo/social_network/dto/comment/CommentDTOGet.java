package com.example.demo.social_network.dto.comment;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotBlank;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommentDTOGet {
	/*Properties*/
	@NotBlank
	private String userIdentifier;
	@NotBlank
	private String publicationTitle;
	@NotBlank
	private String content;

	/*Constructs*/
	public CommentDTOGet() {
		
	}

	public CommentDTOGet(String userIdentifier, String publicationTitle, String content) {
		this.userIdentifier = userIdentifier;
		this.publicationTitle = publicationTitle;
		this.content = content;
	}

	/*Methods*/
	public String getUserIdentifier() {
		return userIdentifier;
	}

	public String getPublicationTitle() {
		return publicationTitle;
	}

	public String getContent() {
		return content;
	}
	
}
