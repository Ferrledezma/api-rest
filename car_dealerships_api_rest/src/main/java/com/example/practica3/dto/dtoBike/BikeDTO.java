package com.example.practica3.dto.dtoBike;

import com.example.practica3.dto.VehicleDTO;

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
