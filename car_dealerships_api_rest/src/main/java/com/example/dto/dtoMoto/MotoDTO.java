package com.example.dto.dtoMoto;

import com.example.dto.MotorVehicleDTO;

public abstract class MotoDTO extends MotorVehicleDTO {
	/*Properties*/
	private Boolean casco;
	
	/*Constructs*/
	public MotoDTO() {
		// TODO Auto-generated constructor stub
	}
	public MotoDTO(String brand, Integer model, String matricula, Boolean licencia,
			Boolean seguro, Boolean casco) {
		super(brand, model, matricula, licencia, seguro);
		this.casco = casco;
	}

	/*Getters*/
	public Boolean getCasco() {
		return casco;
	}

	
}
