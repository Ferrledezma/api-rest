package com.example.demo.practice2.dto.user;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDTOGet extends UserDTOModel {
	/*Properties*/
	@NotNull
	private Integer friendlyUsers;
	@NotNull
	private List<String> friendlyUserListName = new ArrayList<>();
	@NotNull
	private Integer numberOfPublications;
	@NotNull
	private List<String> publicationTitles = new ArrayList<>();

	/*Constructs*/
	public UserDTOGet() {
		// TODO Auto-generated constructor stub
	}

	public UserDTOGet(
			String userIdentifier,
			String userName,
			Integer friendlyUsers,
			List<String> friendlyUserListName,
			Integer numberOfPublications,
			List<String> publicationTitles
			) {
		super(userIdentifier, userName);
		
		this.friendlyUsers = friendlyUsers;
		this.friendlyUserListName = friendlyUserListName;
		this.numberOfPublications = numberOfPublications;
		this.publicationTitles = publicationTitles;
	}

	public Integer getFriendlyUsers() {
		return friendlyUsers;
	}

	public List<String> getFriendlyUserListName() {
		return friendlyUserListName;
	}

	public Integer getNumberOfPublications() {
		return numberOfPublications;
	}

	public List<String> getPublicationTitles() {
		return publicationTitles;
	}
}




















