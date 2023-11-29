package com.example.dto.profesor;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TeacherDTOGet extends TeacherDTOModel {
	/*Properties*/
	private Integer numberInstitutes = 0;
	private Integer numberClassrooms = 0;

	/*Constructs*/
	public TeacherDTOGet() {
		// TODO Auto-generated constructor stub
	}

	public TeacherDTOGet(
			String forName,
			String surName,
			Character sex,
			LocalDate birthDate,
			Integer dni,
			String subject,
			Integer experience,
			Double salary,
			Integer numberInstitutes,
			Integer numberClassrooms) {
		super(forName,surName, sex, birthDate, dni, subject, experience, salary);
		this.numberInstitutes = numberInstitutes;
		this.numberClassrooms = numberClassrooms;
	}

	/*Getters*/
	public Integer getNumberInstitutes() {
		return numberInstitutes;
	}

	public Integer getNumberClassroom() {
		return numberClassrooms;
	}

}
