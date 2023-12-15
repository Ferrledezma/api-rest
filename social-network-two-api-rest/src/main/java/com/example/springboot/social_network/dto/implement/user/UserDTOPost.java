package com.example.springboot.social_network.dto.implement.user;

import java.time.LocalDate;
import java.util.List;

import com.example.springboot.social_network.dto.models.UserDTOModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTOPost extends UserDTOModel {
	@JsonProperty(value = "friends_id")
	private List<Long> idFriendsAdd;

	public UserDTOPost(String surName, String forName, Character sex, LocalDate birthDate, List<Long> idFriendsAdd) {
		super(surName, forName, sex, birthDate);
		this.idFriendsAdd = idFriendsAdd;
	}

	public List<Long> getIdFriendsAdd() {
		return idFriendsAdd;
	}
}
