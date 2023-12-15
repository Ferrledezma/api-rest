package com.example.springboot.social_network.dto.implement.user;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.example.springboot.social_network.dto.models.UserDTOModel;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDTOGet extends UserDTOModel {
	private String identifier;
	private Integer numberFriends;
	private List<String> friendList;
	private Map<String, String> publications;
	private Integer numberCommentsMade;

	public UserDTOGet(
			String surName,
			String forName,
			Character sex,
			LocalDate birthDate,
			String identifier,
			Integer numberFriends,
			List<String> friendList,
			Map<String, String> publications,
			Integer numberCommentsMade) {
		super(surName, forName, sex, birthDate);
		this.identifier = identifier;
		this.numberFriends = numberFriends;
		this.friendList = friendList;
		this.publications = publications;
		this.numberCommentsMade = numberCommentsMade;
	}

	public Integer getNumberFriends() {
		return numberFriends;
	}
	public List<String> getFriendList(){
		return friendList;
	}
	public String getIdentifier() {
		return identifier;
	}
	public Map<String, String> getPublications() {
		return publications;
	}
	public Integer getNumberCommentsMade() {
		return numberCommentsMade;
	}

}
