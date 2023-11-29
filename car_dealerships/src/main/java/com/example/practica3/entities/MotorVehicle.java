package com.example.practica3.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public abstract class MotorVehicle extends Vehicle {
	/*Constructs*/
	
	public MotorVehicle(Concesionaria concesionaria, String brand, Integer model, String matricula, Boolean license, Boolean seguro) {
		super(concesionaria, brand, model);
		this.matricula = matricula;
		this.license = license;
		this.seguro = seguro;
	}
	
	/*Properties*/
	@Column(name = "matricula")
	private String matricula;
	
	@Column(name = "licencia", nullable = false)
	private Boolean license;
	
	@Column(name = "", nullable = false)
	private Boolean seguro;
}
