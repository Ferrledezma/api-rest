package com.example.springboot.social_network.dto.implement.comment;

import com.example.springboot.social_network.dto.models.CommentDTOModel;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommentDTOGet extends CommentDTOModel {
	private String userIdentifier;
	private String publicationTitle;
	private String publicationUserIdentifier;

	public CommentDTOGet(String content, String userIdentifier, String publicationTitle, String publicationUserIdentifier) {
		super(content);
		this.userIdentifier = userIdentifier;
		this.publicationTitle = publicationTitle;
		this.publicationUserIdentifier = publicationUserIdentifier;
	}

	public String getUserIdentifier() {
		return userIdentifier;
	}

	public String getPublicationTitle() {
		return publicationTitle;
	}
	
	public String getPublicationUserIdentifier() {
		return publicationUserIdentifier;
	}
}
