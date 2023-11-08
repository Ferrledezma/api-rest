package com.example.demo.practice1.dto.publication;

import java.util.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublicationDTOGet extends PublicationDTOPost {
	/*Properties*/
	@NotNull
	private Integer amountComments;
	
	@NotNull
	private Date creationDate;

	/*Constructs*/
	public PublicationDTOGet() {
		
	}
	public PublicationDTOGet(String title, String description, String content, Integer amountComments, Date creationDate) {
		super(title, description, content);
		this.amountComments = amountComments;
		this.creationDate = creationDate;
	}

	/*Methods*/
	public Integer getAmountComments() {
		return amountComments;
	}
	public Date getCreationDate() {
		return creationDate;
	}

}
