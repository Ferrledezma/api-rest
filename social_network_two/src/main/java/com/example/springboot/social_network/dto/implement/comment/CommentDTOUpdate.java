package com.example.springboot.social_network.dto.implement.comment;

public class CommentDTOUpdate {
	private String content;

	public CommentDTOUpdate() {
		
	}
	public CommentDTOUpdate(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}
