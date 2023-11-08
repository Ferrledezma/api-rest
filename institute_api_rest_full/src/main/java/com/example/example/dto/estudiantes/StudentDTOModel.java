package com.example.practica4.dto.estudiantes;

import java.time.LocalDate;

import com.example.practica4.dto.PersonDTO;

public abstract class StudentDTOModel extends PersonDTO {
	/*Properties*/
	private Integer grade;
	private String performance;
	
	/*Constructs*/
	public StudentDTOModel() {
		// TODO Auto-generated constructor stub
	}

	public StudentDTOModel(String forName, String surName, Character sex, LocalDate birthDate, Integer dni, Integer grade, String performance) {
		super(forName, surName, sex, birthDate, dni);
		this.grade = grade;
		this.performance = performance;
	}

	/*Getters*/
	public Integer getGrade() {
		return grade;
	}

	public String getPerformance() {
		return performance;
	}

}
