package com.example.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dto.dtoBike.BikeDTOPost;
import com.example.entities.Bike;
import com.example.entities.Concesionaria;
import com.example.repository.ConcesionariaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;

@Component
public class BikeMapper {
	@Autowired
	private ConcesionariaRepository concesionariaRepository;
	
	public Bike mapperBike(BikeDTOPost bikeDTO) throws ConstraintViolationException, EntityNotFoundException {
		Bike bike = new Bike(
				null,
				bikeDTO.getBrand(),
				bikeDTO.getModel(),
				bikeDTO.getCasco()
				);
		if(bikeDTO.getConcesionariaID() != null) {
			Concesionaria concesionaria = concesionariaRepository.findById(bikeDTO.getConcesionariaID())
					.orElseThrow(() -> new EntityNotFoundException("No existe la entidad concesionaria en la base de datos"));
			bike.setConcesionaria(concesionaria);
		}
		return bike;
	}
}
