package com.example.demo.social_network.dto.publication;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PublicationDTOPost extends PublicationDTO {
	/*Properties*/
	@JsonIgnore
	private Long userId;

	/*Constructs*/
	public PublicationDTOPost() {
		// TODO Auto-generated constructor stub
	}

	public PublicationDTOPost(String title, String content, Long userId) {
		super(title, content);
		this.userId = userId;
		// TODO Auto-generated constructor stub
	}

	/*Methods*/
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
