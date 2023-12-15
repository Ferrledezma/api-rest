package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "auto")
@NoArgsConstructor
@Getter
@Setter
public class Car extends MotorVehicle{

	public Car(Concesionaria concesionaria, String brand, Integer model, String matricula, Boolean licencia, Boolean seguro, Boolean rto) {
		super(concesionaria, brand, model, matricula, licencia, seguro);
		this.rto = rto;
	}
	@Column(name = "dto", nullable = false)
	private Boolean rto;
}
