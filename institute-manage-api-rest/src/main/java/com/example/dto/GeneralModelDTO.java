package com.example.dto;

public abstract class GeneralModelDTO {
	/*Properties*/
	private String name;

	/*Constructs*/
	public GeneralModelDTO() {
		
	}
	public GeneralModelDTO(String name) {
		this.name = name;
	}
	
	/*Methods*/
	public String getName() {
		return name;
	}
}
