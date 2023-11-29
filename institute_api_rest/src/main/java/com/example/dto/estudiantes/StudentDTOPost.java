package com.example.dto.estudiantes;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class StudentDTOPost extends StudentDTOModel {
	/*Properties*/
	@JsonProperty(value = "institute_id")
	@Positive
	private Long instituteId;
	
	@JsonProperty(value = "classroom_id")
	@Positive
	private Integer classroomNumber;
	
	/*Constructs*/
	public StudentDTOPost() {
		// TODO Auto-generated constructor stub
	}

	public StudentDTOPost(
			@NotBlank String forName,
			@NotBlank String surName,
			@NotNull Character sex,
			@NotNull LocalDate birthDate,
			@NotNull @Positive Integer dni,
			@NotNull @Positive Integer grade,
			@NotBlank String performance,
			Long instituteId,
			Integer classroomNumber
			) {
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



















