package com.example.dto.dtoBike;

import com.example.dto.VehicleDTO;

public class BikeDTO extends VehicleDTO {
	/*Properties*/
	private Boolean casco;
	
	/*Constructs*/
	public BikeDTO() {
		// TODO Auto-generated constructor stub
	}

	public BikeDTO(String brand, Integer model, Boolean casco) {
		super(brand, model);
		this.casco = casco;
	}
	
	/*Getters*/
	public Boolean getCasco() {
		return casco;
	}

}
