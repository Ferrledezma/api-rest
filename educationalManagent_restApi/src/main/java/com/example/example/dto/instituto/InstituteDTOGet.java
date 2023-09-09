 package com.example.practica4.dto.instituto;

import com.example.practica4.dto.GeneralModelDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class InstituteDTOGet extends GeneralModelDTO {
	/*Properties*/
	private int numberClassrooms = 0;
	private int numberTeachers = 0;
	private int numberStudents = 0;
	
	/*Constructs*/
	public InstituteDTOGet() {
		// TODO Auto-generated constructor stub
	}

	public InstituteDTOGet(
			@JsonProperty(value = "institute_name") String name,
			int numberClassrooms,
			int numberTeachers,
			int numberStudents) {
		super(name);
		this.numberClassrooms = numberClassrooms;
		this.numberTeachers = numberTeachers;
		this.numberStudents = numberStudents;
	}

	/*Getters*/
	public int getNumberClassrooms() {
		return numberClassrooms;
	}
	public int getNumberTeachers() {
		return numberTeachers;
	}
	public int getNumberStudents() {
		return numberStudents;
	}
}









