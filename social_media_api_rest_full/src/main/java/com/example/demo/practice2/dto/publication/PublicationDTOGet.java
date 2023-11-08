package com.example.demo.practice2.dto.publication;

import java.util.Map;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublicationDTOGet extends PublicationDTO {
	/*Properties*/
	private String userIdentifier;
	
	private Map<String, String> commentList;
	
	/*Constructs*/
	public PublicationDTOGet() {
		// TODO Auto-generated constructor stub
	}

	public PublicationDTOGet(String title, String content, String userIdentifier, Map<String, String> commentList) {
		super(title, content);
		this.userIdentifier = userIdentifier;
		this.commentList = commentList;
	}

	/*Methods*/
	public String getUserIdentifier() {
		return userIdentifier;
	}
	public Map<String, String> getCommentList(){
		return commentList;
	}
}
