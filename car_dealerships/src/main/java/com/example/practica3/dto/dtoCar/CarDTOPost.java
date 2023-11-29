package com.example.practica3.dto.dtoCar;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CarDTOPost extends CarDTO {
	/*Properties*/
	private Long concesionariaID;
	
	/*Constructs*/
	public CarDTOPost() {
		// TODO Auto-generated constructor stub
	}

	public CarDTOPost(
			@NotNull String brand, @NotNull @Positive Integer model, @NotNull String matricula, @NotNull Boolean licencia,
			@NotNull Boolean seguro, @NotNull Boolean rto, Long concesionariaID) {
		super(brand, model, matricula, licencia, seguro, rto);
		this.concesionariaID = concesionariaID;
	}

	/*Getters*/
	public Long getConcesionariaID() {
		return concesionariaID;
	}

	
}
