package com.example.practica3.dto.dtoCar;

public class CarDTOUpdate extends CarDTO {
	private Long concesionariaID;

	public CarDTOUpdate() {
		// TODO Auto-generated constructor stub
	}

	public CarDTOUpdate(
			String brand, Integer model, String matricula, Boolean licencia,
			Boolean seguro, Boolean rto, Long concesionariaID) {
		super(brand, model, matricula, licencia, seguro, rto);
		this.concesionariaID = concesionariaID;
		// TODO Auto-generated constructor stub
	}

	public Long getConcesionariaID() {
		return concesionariaID;
	}	
}
