package com.example.demo.practice1.dto.comment;

import java.util.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CommentDTOGet extends CommentDTOUpdate {
	/*Properties*/
	private String publicationTitle;
	private Date creationDate;

	/*Constructs*/
	public CommentDTOGet() {
		// TODO Auto-generated constructor stub
	}
	
	public CommentDTOGet(String userName, String content, String publicationTitle, Date creationDate) {
		super(userName, content);
		this.publicationTitle = publicationTitle;
		this.creationDate = creationDate;
	}

	/*Methods*/
	public String getPublicationTitle() {
		return publicationTitle;
	}

	public Date getCreationDate() {
		return creationDate;
	}

}
