package com.example.dto.dtoMoto;

public class MotoDTOGet extends MotoDTO {
	/*Properties*/
	private String concecionariaName;
	
	/*Constructs*/
	public MotoDTOGet() {
		// TODO Auto-generated constructor stub
	}

	public MotoDTOGet(String brand, Integer model, String matricula, Boolean licencia,
			Boolean seguro, Boolean casco, String concecionariaName) {
		super(brand, model, matricula, licencia, seguro, casco);
		this.concecionariaName = concecionariaName;
	}

	/*Getters*/
	public String getConcecionariaName() {
		return concecionariaName;
	}
}
