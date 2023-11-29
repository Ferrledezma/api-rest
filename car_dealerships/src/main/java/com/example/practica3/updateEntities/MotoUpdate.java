package com.example.practica3.updateEntities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.practica3.dto.dtoMoto.MotoDTOUpdate;
import com.example.practica3.entities.Concesionaria;
import com.example.practica3.entities.Moto;
import com.example.practica3.repository.ConcesionariaRepository;

import jakarta.persistence.EntityNotFoundException;

@Component
public class MotoUpdate {
	@Autowired
	private ConcesionariaRepository concesionariaRepository;
	
	public void update(MotoDTOUpdate motoDTO, Moto moto) throws EntityNotFoundException {
		if(motoDTO.getConcesionariaID() != null) {
			Concesionaria concesionaria = concesionariaRepository.findById(motoDTO.getConcesionariaID())
					.orElseThrow(() -> new EntityNotFoundException("La entidad moto no existe en la base de datos"));
			moto.setConcesionaria(concesionaria);
		} else {
			moto.setConcesionaria(null);
		}
		if(!motoDTO.getBrand().isBlank()) {
			moto.setBrand(motoDTO.getBrand());
		}
		if(motoDTO.getModel() != null) {
			moto.setModel(motoDTO.getModel());
		}
		if(!motoDTO.getMatricula().isBlank()) {
			moto.setMatricula(motoDTO.getMatricula());
		}
		if(motoDTO.getLicencia() != null) {
			moto.setLicense(motoDTO.getLicencia());
		}
		if(motoDTO.getSeguro() != null) {
			moto.setSeguro(motoDTO.getSeguro());
		}
		if(motoDTO.getCasco() != null) {
			moto.setCasco(motoDTO.getCasco());
		}
	}
}












