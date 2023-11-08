package com.example.demo.practice2.dto.user;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDTOUpdate {
	/*Properties*/
	private String userName;
	private List<Long> friendUsers = new ArrayList<>();
	private List<Long> friendUsersDelete = new ArrayList<>();
	private List<Long> publicationDelete = new ArrayList<>();

	/*Constructs*/
	public UserDTOUpdate(String userName, List<Long> friendUsers, List<Long> friendlyUserIdDelete) {
		this.userName = userName;
		this.friendUsers = friendUsers;
		this.friendUsersDelete = friendlyUserIdDelete;
	}

	/*Methods*/
	public String getUserName() {
		return userName;
	}

	public List<Long> getFriendUsers() {
		return friendUsers;
	}

	public List<Long> getFriendUsersDelete() {
		return friendUsersDelete;
	}

	public List<Long> getPublicationDelete() {
		return publicationDelete;
	}
	
}
