package com.example.practica3.dto;

public abstract class MotorVehicleDTO extends VehicleDTO {
	private String matricula;
	private Boolean licencia;
	private Boolean seguro;
	
	/*Constructs*/
	public MotorVehicleDTO() {
		// TODO Auto-generated constructor stub
	}

	public MotorVehicleDTO(String brand, Integer model, String matricula, Boolean licencia, Boolean seguro) {
		super(brand, model);
		this.matricula = matricula;
		this.licencia = licencia;
		this.seguro = seguro;
		// TODO Auto-generated constructor stub
	}

	/*Getters*/
	public String getMatricula() {
		return matricula;
	}

	public Boolean getLicencia() {
		return licencia;
	}

	public Boolean getSeguro() {
		return seguro;
	}
}
