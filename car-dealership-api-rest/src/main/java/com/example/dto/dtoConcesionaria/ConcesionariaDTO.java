package com.example.dto.dtoConcesionaria;

public abstract class ConcesionariaDTO {
	/*Properties*/
	private String name;

	/*Constructs*/
	public ConcesionariaDTO() {
		
	}
	public ConcesionariaDTO(String name) {
		this.name = name;
	}

	/*Getters*/
	public String getName() {
		return name;
	}
	
}
