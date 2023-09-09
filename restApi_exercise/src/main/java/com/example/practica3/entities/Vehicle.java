package com.example.practica3.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public abstract class Vehicle {
	/* Constructs */
	public Vehicle(Concesionaria concesionaria, String brand, Integer model) {
		this.concesionaria = concesionaria;
		this.brand = brand;
		this.model = model;
	}

	/* Properties */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "marca", nullable = false)
	private String brand;

	@Column(name = "modelo", nullable = false)
	private Integer model;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "concesionaria_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Concesionaria concesionaria;
}
