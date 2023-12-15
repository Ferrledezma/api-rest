package com.example.dto.dtoBike;

public class BikeDTOGet extends BikeDTO {
	/*Properties*/
	private String concesionariaName;
	
	/*Constructs*/
	public BikeDTOGet() {
		// TODO Auto-generated constructor stub
	}
	public BikeDTOGet(String brand, Integer model, Boolean casco, String concesionariaName) {
		super(brand, model, casco);
		this.concesionariaName = concesionariaName;
	}

	/*Getters*/
	public String getConcesionariaName() {
		return concesionariaName;
	}

	
}
