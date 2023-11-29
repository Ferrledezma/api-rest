package com.example.updateEntities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dto.dtoBike.BikeDTOUpdate;
import com.example.entities.Bike;
import com.example.entities.Concesionaria;
import com.example.repository.ConcesionariaRepository;

import jakarta.persistence.EntityNotFoundException;

@Component
public class BikeUpdate {
	@Autowired
	private ConcesionariaRepository concesionariaRepository;
	
	public void update( BikeDTOUpdate bikeDTO, Bike bike) throws EntityNotFoundException {
		if(bikeDTO.getConcesionariaID() != null) {
			Concesionaria concesionaria = concesionariaRepository.findById(bikeDTO.getConcesionariaID())
					.orElseThrow(() -> new EntityNotFoundException("No existe la entidad concesionaria en la base de datos"));
			bike.setConcesionaria(concesionaria);
		} else {
			bike.setConcesionaria(null);
		}
		
		if(!bikeDTO.getBrand().isBlank()) {
			bike.setBrand(bikeDTO.getBrand());
		}
		if(bikeDTO.getModel() != null) {
			bike.setModel(bikeDTO.getModel());
		}
		if(bikeDTO.getCasco() != null) {
			bike.setCasco(bikeDTO.getCasco());
		}
	}
}














