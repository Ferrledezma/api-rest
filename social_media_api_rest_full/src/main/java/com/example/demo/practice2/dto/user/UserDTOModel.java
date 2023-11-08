package com.example.demo.practice2.dto.user;

import jakarta.validation.constraints.NotBlank;

public abstract class UserDTOModel {
	/*Properties*/
	@NotBlank
	private String userIdentifier;
	@NotBlank
	private String userName;

	/*Constructs*/
	public UserDTOModel() {
		
	}
	public UserDTOModel(String userIdentifier, String userName) {
		this.userIdentifier = userIdentifier;
		this.userName = userName;
	}

	/*Methods*/
	public String getUserIdentifier() {
		return userIdentifier;
	}
	public String getUserName() {
		return userName;
	}
}
