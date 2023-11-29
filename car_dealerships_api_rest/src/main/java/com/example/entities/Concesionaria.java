package com.example.entities;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "concesionaria")
@NoArgsConstructor
@Getter
@Setter
public class Concesionaria {
	/*Properties*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "concesionaria")
	private List<Car> cars = new LinkedList<>();
	
	@OneToMany(mappedBy = "concesionaria")
	private List<Moto> motos = new LinkedList<>();
	
	@OneToMany(mappedBy = "concesionaria")
	private List<Bike> bikes = new LinkedList<>();
	
	/*Constructs*/
	public Concesionaria(String name) {
		this.name = name;
	}

	/*Methods*/
	public <T> void addRelations(T vehicle) {
		if(vehicle instanceof Car) {
			addCar((Car)vehicle);
		} else if(vehicle instanceof Moto) {
			addMoto((Moto) vehicle);
		} else if(vehicle instanceof Bike) {
			addBike((Bike) vehicle);
		}
	}
	public <T> void removeRelations(T vehicle) {
		if(vehicle instanceof Car) {
			removeCar((Car) vehicle);
		} else if(vehicle instanceof Moto) {
			removeMoto((Moto) vehicle);
		} else if(vehicle instanceof Bike) {
			removeBike((Bike) vehicle);
		}
	}
	
	public void addCar(Car car) {
		if(!Objects.isNull(car)) {
			cars.add(car);
			car.setConcesionaria(this);
		}
	}
	public void removeCar(Car car) {
		if(!Objects.isNull(car)) {
			cars.remove(car);
			car.setConcesionaria(null);
		}
	}
	public void addMoto(Moto moto) {
		if(!Objects.isNull(moto)) {
			motos.add(moto);
			moto.setConcesionaria(this);
		}
	}
	public void removeMoto(Moto moto) {
		if(!Objects.isNull(moto)) {
			motos.remove(moto);
			moto.setConcesionaria(null);
		}
	}
	public void addBike(Bike bike) {
		if(!Objects.isNull(bike)) {
			bikes.add(bike);
			bike.setConcesionaria(this);
		}
	}
	public void removeBike(Bike bike) {
		if(!Objects.isNull(bike)) {
			bikes.remove(bike);
			bike.setConcesionaria(null);
		}
	}
}











