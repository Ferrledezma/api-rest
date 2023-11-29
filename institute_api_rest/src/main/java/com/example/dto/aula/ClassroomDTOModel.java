package com.example.dto.aula;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ClassroomDTOModel {
	/*Properties*/
	@JsonProperty(value = "institute_id")
	private Long instituteId;
	
	/*Constructs*/
	public ClassroomDTOModel() {
		
	}
	public ClassroomDTOModel(@NotNull @Positive Long instituteId) {
		this.instituteId = instituteId;
	}
	
	/*Getter*/
	public Long getInstituteId() {
		return instituteId;
	}
}














