package com.example.dto.instituto;

import com.example.dto.GeneralModelDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class InstituteDTOPost extends GeneralModelDTO {
	/*Properties*/
	@JsonProperty(value = "number_classrooms")
	private Integer numberClassrooms;

	/*Constructs*/
	public InstituteDTOPost() {
	
	}
	public InstituteDTOPost(@NotBlank String name, Integer numberClassrooms) {
		super(name);
		this.numberClassrooms = numberClassrooms;
	}

	/*Getters*/
	public Integer getNumberClassrooms() {
		return numberClassrooms;
	}
}
