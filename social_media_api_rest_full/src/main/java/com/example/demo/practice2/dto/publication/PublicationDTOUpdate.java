package com.example.demo.practice2.dto.publication;

public class PublicationDTOUpdate {
	/*Properties*/
	private String title;
	private String content;

	/*Constructs*/
	public PublicationDTOUpdate() {
		
	}
	
	public PublicationDTOUpdate(String title, String content) {
		this.title = title;
		this.content = content;
	}

	/*Methods*/
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
}
