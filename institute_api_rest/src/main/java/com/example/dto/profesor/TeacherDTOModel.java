package com.example.dto.profesor;

import java.time.LocalDate;

import com.example.dto.PersonDTO;

public abstract class TeacherDTOModel extends PersonDTO {
	/*Properties*/
	private String subject;
	private Integer experience;
	private Double salary;
	
	/*Constructs*/
	public TeacherDTOModel() {
		// TODO Auto-generated constructor stub
	}

	public TeacherDTOModel(String forName, String surName, Character sex, LocalDate birthDate, Integer dni, String subject, Integer experience, Double salary) {
		super(forName, surName, sex, birthDate, dni);
		this.subject = subject;
		this.experience = experience;
		this.salary = salary;
	}

	/*Getters*/
	public String getSubject() {
		return subject;
	}
	public Integer getExperience() {
		return experience;
	}
	public Double getSalary() {
		return salary;
	}

}

















