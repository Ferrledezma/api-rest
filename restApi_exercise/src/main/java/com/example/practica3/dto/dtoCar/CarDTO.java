package com.example.practica3.dto.dtoCar;

import com.example.practica3.dto.MotorVehicleDTO;


public abstract class CarDTO extends MotorVehicleDTO {
	/*Properties*/
	private Boolean rto;
	
	/*Constructs*/
	public CarDTO() {
		// TODO Auto-generated constructor stub
	}

	public CarDTO(String brand, Integer model, String matricula, Boolean licencia, Boolean seguro, Boolean rto) {
		super(brand, model, matricula, licencia, seguro);
		this.rto = rto;
	}

	/*Getters*/
	public Boolean getRto() {
		return rto;
	}

	
}
