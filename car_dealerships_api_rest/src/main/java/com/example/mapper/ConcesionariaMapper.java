package com.example.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dto.dtoConcesionaria.ConcesionariaDTOPost;
import com.example.entities.Bike;
import com.example.entities.Car;
import com.example.entities.Concesionaria;
import com.example.entities.Moto;
import com.example.service.BikeService;
import com.example.service.CarService;
import com.example.service.MotoService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;

@Component
public class ConcesionariaMapper {
	private final CarService carService;
	private final MotoService motoService;
	private final BikeService bikeService;
	
	@Autowired
	public ConcesionariaMapper(CarService carService, MotoService motoService, BikeService bikeService) {
		this.carService = carService;
		this.motoService = motoService;
		this.bikeService = bikeService;
	}

	public Concesionaria mapperConcesionaria(ConcesionariaDTOPost concesionariaDTO) throws ConstraintViolationException, EntityNotFoundException {
		Concesionaria concesionaria = new Concesionaria(concesionariaDTO.getName());
		if(concesionariaDTO.getCarID() != null) {
			Car car = carService.find(concesionariaDTO.getCarID());
			concesionaria.addCar(car);
		}
		if(concesionariaDTO.getMotoID() != null) {
			Moto moto = motoService.find(concesionariaDTO.getMotoID());
			concesionaria.addMoto(moto);
		}
		if(concesionariaDTO.getBikeID() != null) {
			Bike bike = bikeService.find(concesionariaDTO.getBikeID());
			concesionaria.addBike(bike);
		}
		return concesionaria;
	}
}
