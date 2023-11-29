package com.example.demo.social_network.dto.user;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotBlank;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDTOPost extends UserDTOModel {
	/*Properties*/
	private List<Long> friendList = new ArrayList<>();

	/*Constructs*/
	public UserDTOPost() {
		
	}
	public UserDTOPost(@NotBlank String userIdentifier, @NotBlank String userName, List<Long> userListId) {
		super(userIdentifier, userName);
		this.friendList = userListId;
	}

	/*Methods*/
	public List<Long> getFriendList() {
		return friendList;
	}
	
}
