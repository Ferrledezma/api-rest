package com.example.practica4.dto.profesor;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.Positive;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TeacherDTOUpdate extends TeacherDTOModel {
	/*Properties*/
	@Positive
	private Long instituteIdAdd;
	
	private List<Integer> classroomListAdd;
	
	@Positive
	private Long instituteId;
	
	private List<Integer> classroomListDelete;
	
	@Positive
	private Long instituteIdDelete;
	/*Constructs*/
	public TeacherDTOUpdate() {
		// TODO Auto-generated constructor stub
	}

	public TeacherDTOUpdate(
			String forName,
			String surName,
			Character sex,
			LocalDate birthDate,
			Integer dni,
			String subject,
			Integer experience,
			Double salary,
			Long instituteIdAdd,
			List<Integer> classroomListAdd,
			Long instituteId,
			List<Integer> classroomListDelete,
			Long instituteIdDelete
			) {
		super(forName, surName, sex, birthDate, dni, subject, experience, salary);
		this.instituteIdAdd = instituteIdAdd;
		this.classroomListAdd = classroomListAdd;
		this.instituteId = instituteId;
		this.classroomListDelete = classroomListDelete;
		this.instituteIdDelete = instituteIdDelete;
	}

	/*Getters*/
	public Long getInstituteIdAdd() {
		return instituteIdAdd;
	}
	public List<Integer> getClassroomListAdd() {
		return classroomListAdd;
	}
	public Long getInstituteId() {
		return instituteId;
	}
	public List<Integer> getClassroomListDelete() {
		return classroomListDelete;
	}
	public Long getInstituteIdDelete() {
		return instituteIdDelete;
	}
}











