package com.example.dto.aula;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClassroomDTOGet {
	/*Properties*/
	private String instituteName;
	private Integer classroomNumber;
	private Integer numberTeachers;
	private Integer numberStudents;
	
	/*Constructs*/
	public ClassroomDTOGet() {
		// TODO Auto-generated constructor stub
	}

	public ClassroomDTOGet(String instituteName, Integer classroomNumber, Integer numberTeachers, Integer numberStudents) {
		this.instituteName = instituteName;
		this.classroomNumber = classroomNumber;
		this.numberTeachers = numberTeachers;
		this.numberStudents = numberStudents;
	}

	/*Getters*/
	public String getInstituteName() {
		return instituteName;
	}

	public Integer getClassroomNumber() {
		return classroomNumber;
	}

	public Integer getNumberTeachers() {
		return numberTeachers;
	}

	public Integer getNumberStudents() {
		return numberStudents;
	}

}














