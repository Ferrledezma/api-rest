package com.example.springboot.social_network.dto.models;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public abstract class UserDTOModel{
	@NotBlank
	private String surName;
	@NotBlank
	private String forName;
	@NotNull
	private Character sex;
	@NotNull
	private LocalDate birthDate;

	public UserDTOModel() {
		
	}
	public UserDTOModel(String surName, String forName, Character sex, LocalDate birthDate) {
		this.surName = surName;
		this.forName = forName;
		this.sex = sex;
		this.birthDate = birthDate;
	}

	public String getSurName() {
		return surName;
	}

	public String getForName() {
		return forName;
	}

	public Character getSex() {
		return sex;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}
	
}
