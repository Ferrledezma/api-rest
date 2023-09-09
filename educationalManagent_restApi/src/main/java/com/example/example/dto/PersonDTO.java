package com.example.practica4.dto;

import java.time.LocalDate;

public abstract class PersonDTO extends GeneralModelDTO {
	/*Properties*/
	private String surName;
	private Character sex;
	private LocalDate birthDate;
	private Integer dni;
	
	/*Constructs*/
	public PersonDTO() {
		
	}
	public PersonDTO(String forName, String surName, Character sex, LocalDate birthDate, Integer dni) {
		super(forName);
		this.surName = surName;
		this.sex = sex;
		this.birthDate = birthDate;
		this.dni = dni;
	}
	/*Getters*/
	public String getSurName() {
		return surName;
	}

	public Character getSex() {
		return sex;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public Integer getDni() {
		return dni;
	}
}

















