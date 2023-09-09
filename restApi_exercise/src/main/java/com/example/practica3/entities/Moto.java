package com.example.practica3.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "moto")
@NoArgsConstructor
@Getter
@Setter
public class Moto extends MotorVehicle {
	public Moto(Concesionaria concesionaria, String brand, Integer model, String matricula, Boolean licencia, Boolean seguro, Boolean casco) {
		super(concesionaria, brand, model, matricula, licencia, seguro);
		this.casco = casco;
	}
	
	@Column(name = "casco")
	private Boolean casco;
}
