package com.example.practica3.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.practica3.dto.dtoMoto.MotoDTOPost;
import com.example.practica3.entities.Concesionaria;
import com.example.practica3.entities.Moto;
import com.example.practica3.repository.ConcesionariaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;

@Component
public class MotoMapper {
	@Autowired
	private ConcesionariaRepository concesionariaRepository;
	
	public Moto motoMapper(MotoDTOPost motoDTO) throws ConstraintViolationException, EntityNotFoundException {
		Moto moto = new Moto(
				null,
				motoDTO.getBrand(),
				motoDTO.getModel(),
				motoDTO.getMatricula(),
				motoDTO.getLicencia(),
				motoDTO.getSeguro(),
				motoDTO.getCasco()
				);
		if(motoDTO.getConcecionariaID() != null) {
			Concesionaria concesionaria = concesionariaRepository.findById(motoDTO.getConcecionariaID())
					.orElseThrow(() -> new EntityNotFoundException("No se existe la entidad concesionaria en la base de datos"));
			moto.setConcesionaria(concesionaria);
		}
		return moto;
	}
}
