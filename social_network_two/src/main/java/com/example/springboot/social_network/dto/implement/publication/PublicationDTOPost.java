package com.example.springboot.social_network.dto.implement.publication;

import com.example.springboot.social_network.dto.models.PublicationDTOModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class PublicationDTOPost extends PublicationDTOModel {
	@JsonIgnore
	private Long userId;

	public PublicationDTOPost(String title, String content) {
		super(title, content);
	}

	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
