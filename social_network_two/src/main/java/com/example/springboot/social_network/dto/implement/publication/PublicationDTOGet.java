package com.example.springboot.social_network.dto.implement.publication;

import com.example.springboot.social_network.dto.models.PublicationDTOModel;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublicationDTOGet extends PublicationDTOModel {
	@NotBlank
	private String userIdentifier;
	@NotNull
	private Integer numberComments;

	public PublicationDTOGet(String title, String content, String userIdentifier, Integer numberComments) {
		super(title, content);
		this.userIdentifier = userIdentifier;
		this.numberComments = numberComments;
	}

	public String getUserIdentifier() {
		return userIdentifier;
	}
	public Integer getNumberComments() {
		return numberComments;
	}
}
