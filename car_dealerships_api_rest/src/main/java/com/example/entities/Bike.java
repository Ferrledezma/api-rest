package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bicicleta")
@NoArgsConstructor
@Getter
@Setter
public class Bike extends Vehicle{
	public Bike(Concesionaria concesionaria, String brand, Integer model, Boolean casco) {
		super(concesionaria, brand, model);
		this.casco = casco;
	}
	
	@Column(name = "casco", nullable = false)
	private Boolean casco;
}




