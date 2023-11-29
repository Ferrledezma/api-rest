package com.example.dto.dtoConcesionaria;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ConcesionariaDTOPost extends ConcesionariaDTO {
	/*Properties*/
	@Positive
	private Long carID;
	
	@Positive
	private Long motoID;
	
	@Positive
	private Long bikeID;
	
	/*Constructs*/
	public ConcesionariaDTOPost() {
		
	}
	public ConcesionariaDTOPost(@NotNull String name, Long carID, Long motoID, Long bikeID) {
		super(name);
		this.carID = carID;
		this.motoID = motoID;
		this.bikeID = bikeID;
	}
	/*Getters*/
	public Long getCarID() {
		return carID;
	}
	public Long getMotoID() {
		return motoID;
	}
	public Long getBikeID() {
		return bikeID;
	}
	
}
