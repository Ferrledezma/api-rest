package com.example.practica4.entities;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import com.example.practica4.status.Desempenio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "estudiante")
@NoArgsConstructor
@Getter
public class StudentEntity extends PersonEntityModel {
	/*Properties*/
	@Column(name = "grado", nullable = false)
	@Setter
	private Integer grade;
	
	@Column(name = "desempeño", nullable = false)
	@Enumerated(EnumType.STRING)
	@Setter
	private Desempenio performance;
	
	@ManyToOne
	@JoinColumn(name = "instituto_id", referencedColumnName = "id")
	private InstituteEntity institute;
	
	@ManyToOne
	@JoinColumn(name = "classroom_id", referencedColumnName = "id")
	private ClassroomEntity classroom;

	/*Constructs*/
	public StudentEntity(
			String forName,
			String surName,
			Character sex,
			LocalDate birthDate,
			Integer dni,
			Integer grade,
			Desempenio performance) {
		super(forName, surName, sex, birthDate, dni);
		this.grade = grade;
		this.performance = performance;
	}

	/*Setter*/
	public void setInstitute(InstituteEntity institute) {
		this.institute = institute;
		if(classroom != null) {
			this.classroom = null;
		}
	}
	public void setClassroom(Set<ClassroomEntity> classroomList) {
		if(classroomList.size() < 1) {
			Optional<ClassroomEntity> optionalClassroom = classroomList.stream().findFirst();
			this.classroom = optionalClassroom.get();
		}
	}
}














