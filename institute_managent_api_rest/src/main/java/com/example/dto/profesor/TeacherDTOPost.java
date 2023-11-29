package com.example.dto.profesor;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TeacherDTOPost extends TeacherDTOModel {
	/*Properties*/
	
	@JsonProperty(value = "institute_Id")
	@Positive
	private Long instituteId;
	
	@JsonProperty(value = "classroom_list")
	private List<Integer> classroomNumberList;
	
	/*Constructs*/
	public TeacherDTOPost() {
		// TODO Auto-generated constructor stub
	}

	public TeacherDTOPost(
			@NotBlank String forName,
			@NotBlank String surName,
			@NotNull Character sex,
			@NotNull LocalDate birthDate,
			@NotNull @Positive Integer dni,
			@NotBlank String subject,
			@NotNull Integer experience,
			@NotNull Double salary,
			Long instituteId,
			List<Integer> classroomNumberList
			) {
		super(forName, surName, sex, birthDate, dni, subject, experience, salary);
		this.instituteId = instituteId;
		this.classroomNumberList = classroomNumberList;
	}

	/*Getters*/
	public Long getInstituteId() {
		return instituteId;
	}
	public List<Integer> getClassroomNumberList() {
		return classroomNumberList;
	}

}
















