package com.example.practica3.dto.dtoCar;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CarDTOGet extends CarDTO {
	/*Properties*/
	private String concecionariaName;
	
	@JsonIgnore
	private Long concesionariaID;
	
	/*Constructs*/
	public CarDTOGet() {
		// TODO Auto-generated constructor stub
	}

	public CarDTOGet(String brand, Integer model, String matricula, Boolean licencia, Boolean seguro,
			Boolean rto, String concecionariaName, Long concesionariaID) {
		super(brand, model, matricula, licencia, seguro, rto);
		this.concecionariaName = concecionariaName;
		this.concesionariaID = concesionariaID;
		// TODO Auto-generated constructor stub
	}

	/*Getters*/
	public String getConcecionariaName() {
		return concecionariaName;
	}
	public Long getConcesionariaID() {
		return concesionariaID;
	}
	
}
