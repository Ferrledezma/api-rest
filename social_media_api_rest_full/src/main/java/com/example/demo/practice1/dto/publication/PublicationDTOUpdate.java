package com.example.demo.practice1.dto.publication;

public class PublicationDTOUpdate {
	private String title;
	private String description;
	private String content;

	/*Constructs*/
	public PublicationDTOUpdate() {
		
	}

	public PublicationDTOUpdate(String title, String description, String content) {
		this.title = title;
		this.description = description;
		this.content = content;
	}

	/*Methods*/
	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getContent() {
		return content;
	}
}
