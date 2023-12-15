package com.example.dto.dtoConcesionaria;

import jakarta.validation.constraints.Positive;

public class ConcesionariaDTOUpdate extends ConcesionariaDTOPost {
	/*Properties*/
	@Positive
	private Long carIdDelete;
	@Positive
	private Long motoIdDelete;
	@Positive
	private Long bikeIdDelete;
	
	/*Construct*/
	public ConcesionariaDTOUpdate(String name, @Positive Long carIdAdd, @Positive Long motoIdAdd,
			@Positive Long bikeIdAdd, @Positive Long carIdDelete, @Positive Long motoIdDelete,
			@Positive Long bikeIdDelete) {
		super(name, carIdAdd, motoIdAdd, bikeIdAdd);
		this.carIdDelete = carIdDelete;
		this.motoIdDelete = motoIdDelete;
		this.bikeIdDelete = bikeIdDelete;
	}
	
	/*Getters*/
	public Long getCarIdDelete() {
		return carIdDelete;
	}
	public Long getMotoIdDelete() {
		return motoIdDelete;
	}
	public Long getBikeIdDelete() {
		return bikeIdDelete;
	}
	
	
	
}
