package com.example.updateEntities;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dto.dtoConcesionaria.ConcesionariaDTOUpdate;
import com.example.entities.Bike;
import com.example.entities.Car;
import com.example.entities.Concesionaria;
import com.example.entities.Moto;
import com.example.entities.Vehicle;
import com.example.service.BikeService;
import com.example.service.CarService;
import com.example.service.MotoService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;

@Component
public class ConcesionariaUpdate {
	private final CarService carService;
	private final MotoService motoService;
	private final BikeService bikeService;
	
	@Autowired
	public ConcesionariaUpdate(CarService carService, MotoService motoService, BikeService bikeService) {
		this.carService = carService;
		this.motoService = motoService;
		this.bikeService = bikeService;
	}
	
	public void update(ConcesionariaDTOUpdate concesionariaDTO, Concesionaria concesionaria) {
		if(!concesionariaDTO.getName().isBlank()) {
			concesionaria.setName(concesionariaDTO.getName());
		}
		if(concesionariaDTO.getCarID() != null) {
			defineAction(concesionaria::addRelations, Car.class, concesionariaDTO.getCarID());
		}
		if(concesionariaDTO.getCarIdDelete() != null) {
			defineAction(concesionaria::removeRelations, Car.class, concesionariaDTO.getCarIdDelete());
		}
		if(concesionariaDTO.getMotoID() != null) {
			defineAction(concesionaria::addRelations, Moto.class, concesionariaDTO.getMotoID());
		}
		if(concesionariaDTO.getMotoIdDelete() != null) {
			defineAction(concesionaria::removeRelations, Moto.class, concesionariaDTO.getMotoIdDelete());
		}
		if(concesionariaDTO.getBikeID() != null) {
			defineAction(concesionaria::addRelations, Bike.class, concesionariaDTO.getBikeID());
		}
		if(concesionariaDTO.getBikeIdDelete() != null) {
			defineAction(concesionaria::removeRelations, Bike.class, concesionariaDTO.getBikeIdDelete());
		}
	}
	
	private void defineAction(Consumer<Vehicle> referenceMethod, Class<?> classType, Long vehicleID)
			throws ConstraintViolationException, IllegalArgumentException, EntityNotFoundException {
		Vehicle vehicle = null;
		
		if(classType == Car.class) {
			vehicle = carService.find(vehicleID);
		} else if(classType == Moto.class) {
			vehicle = motoService.find(vehicleID);
		} else if(classType == Bike.class) {
			vehicle = bikeService.find(vehicleID);
		} else {
			throw new IllegalArgumentException("Argumento de clase no valido");
		}
		
		referenceMethod.accept(vehicle);
	}
}
