package com.example.dto.dtoMoto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class MotoDTOPost extends MotoDTO {
	/*Properties*/
	private Long concecionariaID;
	
	/*Constructs*/
	public MotoDTOPost() {
		// TODO Auto-generated constructor stub
	}
	public MotoDTOPost(@NotNull String brand, @NotNull @Positive Integer model, @NotNull String matricula, @NotNull Boolean licencia,
			@NotNull Boolean seguro, @NotNull Boolean casco, Long concecionariaID) {
		super(brand, model, matricula, licencia, seguro, casco);
		this.concecionariaID = concecionariaID;
	}
	
	/*GettersS*/
	public Long getConcecionariaID() {
		return concecionariaID;
	}
}
