package com.example.entities;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public abstract class PersonEntityModel extends AbstractEntityModel {
	/*Properties*/
	
	@Column(name = "apellido", length = 25, nullable = false)
	private String surName;
	
	@Column(name = "sexo", updatable = false, nullable = false)
	private Character sex;
	
	@Column(name = "fecha_nacimiento", nullable = false)
	private LocalDate birthDate;
	
	@Column(nullable = false, unique = true)
	private Integer dni;
	
	@Transient
	private int age;

	public PersonEntityModel(String forName, String surName, Character sex, LocalDate birthDate, Integer dni) {
		super(forName);
		this.surName = surName;
		this.sex = sex;
		this.birthDate = birthDate;
		this.dni = dni;
		generateAge();
	}

	/*Methods*/
	public void generateAge() {
		age = Period.between(birthDate, LocalDate.now()).getYears();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonEntityModel other = (PersonEntityModel) obj;
		return Objects.equals(dni, other.dni);
	}
}










