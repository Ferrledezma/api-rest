package com.example.practica3.dto.dtoBike;

public class BikeDTOUpdate extends BikeDTO {

	private Long concesionariaID;
	
	public BikeDTOUpdate() {
		// TODO Auto-generated constructor stub
	}

	public BikeDTOUpdate(String brand, Integer model, Boolean casco, Long concesionariaID) {
		super(brand, model, casco);
		this.concesionariaID = concesionariaID;
	}

	public Long getConcesionariaID() {
		return concesionariaID;
	}

}
