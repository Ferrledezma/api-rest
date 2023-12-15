package com.example.springboot.social_network.dto.implement.publication;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PublicationDTOUpdate {
	private String title;
	private String content;
	@JsonProperty(value = "id_comments_delete")
	private List<Long> idCommentsDelete;

	public PublicationDTOUpdate(String title, String content, List<Long> idCommentsDelete) {
		this.title = title;
		this.content = content;
		this.idCommentsDelete = idCommentsDelete;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public List<Long> getIdCommentsDelete() {
		return idCommentsDelete;
	}
	
}
