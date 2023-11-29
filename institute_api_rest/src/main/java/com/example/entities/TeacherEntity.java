package com.example.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.status.Materias;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "profesor")
@NoArgsConstructor
@Getter
public class TeacherEntity extends PersonEntityModel {
	/*Properties*/
	@Column(name = "materia", nullable = false)
	@Enumerated(EnumType.STRING)
	@Setter
	private Materias subject;
	
	@Column(name = "años_experiencia", nullable = false)
	@PositiveOrZero
	@Setter
	private Integer experience;
	
	@Column(name = "salario", nullable = false)
	@Setter
	private Double salary;
	
	@ManyToMany
	@JsonManagedReference
	@JoinTable(
			name = "profesores_institutos",
			joinColumns = @JoinColumn(name = "profesor_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "instituto_id", referencedColumnName = "id")
			)
	private List<InstituteEntity> institutes = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(
			name = "profesores_aulas",
			joinColumns = @JoinColumn(name = "profesor_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "aula_id", referencedColumnName = "id")
			)
	@JsonBackReference
	private Set<ClassroomEntity> classrooms = new HashSet<>();
	
	/*Constructs*/
	public TeacherEntity(
			String forName,
			String surName,
			Character sex,
			LocalDate birthDate,
			Integer dni,
			Materias subject,
			Integer experience,
			Double salary) {
		super(forName, surName, sex, birthDate, dni);
		this.subject = subject;
		this.experience = experience;
		this.salary = salary;
	}

	/*Methods*/

	public void addInstitute(InstituteEntity institute) {
		if(institute != null) {
			institutes.add(institute);
		}
	}
	public void removeInstitute(InstituteEntity institute) {
		if(institute != null) {
			institutes.remove(institute);
		}
	}
	public void addClassroomList(Set<ClassroomEntity> classroomList) {
		if(classroomList != null) {
			classrooms.addAll(classroomList);
		}
	}
	public void removeClassroomList(Set<ClassroomEntity> classroomList) {
		if(classroomList != null) {
			classrooms.removeAll(classroomList);
		}
	}
}
















