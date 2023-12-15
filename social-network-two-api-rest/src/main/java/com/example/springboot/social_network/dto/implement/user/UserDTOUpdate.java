package com.example.springboot.social_network.dto.implement.user;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDTOUpdate {
	private String surName;
	private String forName;
	private Character sex;
	
	private List<Long> idFriendsAdd;
	private List<Long> idFriendsDelete;
	private List<Long> idPublicationsDelete;
	private List<Long> idCommentsDelete;

	public UserDTOUpdate(
			String surName,
			String forName,
			Character sex,
			List<Long> idFriendsAdd,
			List<Long> idFriendsDelete,
			List<Long> idPublicationsDelete,
			List<Long> idCommentsDelete) {
		this.surName = surName;
		this.forName = forName;
		this.sex = sex;
		this.idFriendsAdd = idFriendsAdd;
		this.idFriendsDelete = idFriendsDelete;
		this.idPublicationsDelete = idPublicationsDelete;
		this.idCommentsDelete = idCommentsDelete;
	}

	public String getSurName() {
		return surName;
	}
	
	public String getForName() {
		return forName;
	}
	
	public Character getSex() {
		return sex;
	}
	
	public List<Long> getIdFriendsAdd() {
		return idFriendsAdd;
	}
	
	public List<Long> getIdFriendsDelete() {
		return idFriendsDelete;
	}
	
	public List<Long> getIdPublicationsDelete() {
		return idPublicationsDelete;
	}
	
	public List<Long> getIdCommentsDelete(){
		return idCommentsDelete;
	}
}


















