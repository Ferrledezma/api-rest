package com.example.updateEntities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dto.dtoCar.CarDTOUpdate;
import com.example.entities.Car;
import com.example.entities.Concesionaria;
import com.example.repository.ConcesionariaRepository;

import jakarta.persistence.EntityNotFoundException;

@Component
public class CarUpdate {
	@Autowired
	private ConcesionariaRepository concesionariaRepository;

	public void update(CarDTOUpdate carDTO, Car car) throws EntityNotFoundException {
		if(carDTO.getConcesionariaID() != null) {
			Concesionaria concesionaria = concesionariaRepository.findById(carDTO.getConcesionariaID())
					.orElseThrow(() -> new EntityNotFoundException("No existe la entidad concesionaria en la base de datos"));
			car.setConcesionaria(concesionaria);
		} else {
			car.setConcesionaria(null);
		}
		
		if(!carDTO.getBrand().isBlank()) {
			car.setBrand(carDTO.getBrand());
		}
		if(carDTO.getModel() != null) {
			car.setModel(carDTO.getModel());
		}
		if(!carDTO.getMatricula().isBlank()) {
			car.setMatricula(carDTO.getMatricula());
		}
		if(carDTO.getLicencia() != null) {
			car.setLicense(carDTO.getLicencia());
		}
		if(carDTO.getSeguro() != null) {
			car.setSeguro(carDTO.getSeguro());
		}
		if(carDTO.getRto() != null) {
			car.setRto(carDTO.getRto());
		}
	}

}
