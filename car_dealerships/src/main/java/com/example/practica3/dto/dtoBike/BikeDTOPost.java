package com.example.practica3.dto.dtoBike;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class BikeDTOPost extends BikeDTO {
	/*Properties*/
	private Long concesionariaID;
	
	/*Constructs*/
	public BikeDTOPost() {
		// TODO Auto-generated constructor stub
	}

	public BikeDTOPost(@NotNull String brand, @NotNull @Positive Integer model, @NotNull Boolean casco, Long concesionariaID) {
		super(brand, model, casco);
		this.concesionariaID = concesionariaID;
	}

	/*Getters*/
	public Long getConcesionariaID() {
		return concesionariaID;
	}

	
}
