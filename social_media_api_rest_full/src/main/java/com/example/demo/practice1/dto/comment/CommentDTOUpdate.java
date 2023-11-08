package com.example.demo.practice1.dto.comment;

public class CommentDTOUpdate {
	/*Properties*/
	private String userName;
	private String content;

	/*Constructs*/
	public CommentDTOUpdate() {
	}
	
	public CommentDTOUpdate(String userName, String content) {
		this.userName = userName;
		this.content = content;
	}

	/*Methods*/
	public String getUserName() {
		return userName;
	}
	public String getContent() {
		return content;
	}
	
}
