package com.example.dto.estudiantes;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Positive;

public class StudentDTOUpdate extends StudentDTOModel {
	/*Properties*/
	@JsonProperty(value = "institute_id")
	@Positive
	private Long instituteId;
	
	@JsonProperty(value = "classroom_number")
	@Positive
	private Integer classroomNumber;
	
	/*Constructs*/
	public StudentDTOUpdate() {
		// TODO Auto-generated constructor stub
	}

	public StudentDTOUpdate(String forName, String surName, Character sex, LocalDate birthDate, Integer dni,
			Integer grade, String performance, Long instituteId, Integer classroomNumber) {
		super(forName, surName, sex, birthDate, dni, grade, performance);
		this.instituteId = instituteId;
		this.classroomNumber = classroomNumber;
	}

	/*Getters*/
	public Long getInstituteId() {
		return instituteId;
	}
	public Integer getClassroomNumber() {
		return classroomNumber;
	}

}
