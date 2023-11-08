package com.example.practica3.dto.dtoMoto;

public class MotoDTOUpdate extends MotoDTO {
	/*Properties*/
	private Long concesionariaID;
	
	/*Constructs*/
	public MotoDTOUpdate() {
		// TODO Auto-generated constructor stub
	}

	public MotoDTOUpdate(String brand, Integer model, String matricula, Boolean licencia,
			Boolean seguro, Boolean casco, Long concesionariaID) {
		super(brand, model, matricula, licencia, seguro, casco);
		this.concesionariaID = concesionariaID;
	}

	/*Getters*/
	public Long getConcesionariaID() {
		return concesionariaID;
	}

}
