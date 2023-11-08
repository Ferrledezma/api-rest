package com.example.practica3.dto.dtoConcesionaria;

public class ConcesionariaDTOGet extends ConcesionariaDTO {
	/*Properties*/
	private Integer cars = 0;
	private Integer motos = 0;
	private Integer bikes = 0;
	
	/*Constructs*/
	public ConcesionariaDTOGet() {
		// TODO Auto-generated constructor stub
	}
	public ConcesionariaDTOGet(String name) {
		super(name);
	}
	public ConcesionariaDTOGet(String name, Integer cars, Integer motos, Integer bikes) {
		super(name);
		this.cars = cars;
		this.motos = motos;
		this.bikes = bikes;
	}

	/*Getters*/
	public Integer getCars() {
		return cars;
	}

	public Integer getMotos() {
		return motos;
	}

	public Integer getBikes() {
		return bikes;
	}
	public void setCars(Integer cars) {
		this.cars = cars;
	}
	public void setMotos(Integer motos) {
		this.motos = motos;
	}
	public void setBikes(Integer bikes) {
		this.bikes = bikes;
	}

	
}
