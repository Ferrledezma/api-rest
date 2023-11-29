package com.example.practica3.dto;


public abstract class VehicleDTO {
	/*Properties*/
	private String brand;
	private Integer model;
	
	/*Constructs*/
	public VehicleDTO() {
		// TODO Auto-generated constructor stub
	}

	public VehicleDTO(String brand, Integer model) {
		this.brand = brand;
		this.model = model;
	}
	
	/*Getters*/
	public String getBrand() {
		return brand;
	}

	public Integer getModel() {
		return model;
	}

}
