package com.example.practica4.dto.instituto;

import java.util.List;

import com.example.practica4.dto.GeneralModelDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.Positive;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class InstituteDTOUpdate extends GeneralModelDTO {
	/*Properties*/
	@Positive
	private Integer classroomsAdd;
	
	private List<Integer> classroomsDeleteList;
	
	/*Constructs*/
	public InstituteDTOUpdate() {
		// TODO Auto-generated constructor stub
	}

	public InstituteDTOUpdate(String name, Integer classroomsAdd, List<Integer> classroomsDeleteList) {
		super(name);
		this.classroomsAdd = classroomsAdd;
		this.classroomsDeleteList = classroomsDeleteList;
	}
	
	/*Getters*/
	public Integer getClassroomsAdd() {
		return classroomsAdd;
	}
	public List<Integer> getClassroomsDeleteList() {
		return classroomsDeleteList;
	}
}












