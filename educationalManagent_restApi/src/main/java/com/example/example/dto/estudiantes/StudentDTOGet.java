package com.example.practica4.dto.estudiantes;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentDTOGet extends StudentDTOModel {
	/*Properties*/
	@JsonProperty(value = "institute_name")
	private String instituteName;
	
	@JsonProperty(value = "classroom_number")
	private Integer classroomNumber;

	/*Constructs*/
	public StudentDTOGet() {
		// TODO Auto-generated constructor stub
	}

	public StudentDTOGet(String forName, String surName, Character sex, LocalDate birthDate, Integer dni,
			Integer grade, String performance, String instituteName, Integer classroomNumber) {
		super(forName, surName, sex, birthDate, dni, grade, performance);
		this.instituteName = instituteName;
		this.classroomNumber = classroomNumber;
	}

	/*Getters*/
	public String getInstituteName() {
		return instituteName;
	}

	public Integer getClassroomNumber() {
		return classroomNumber;
	}

}
