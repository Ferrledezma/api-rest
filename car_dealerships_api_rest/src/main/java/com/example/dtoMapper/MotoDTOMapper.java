package com.example.dtoMapper;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.example.dto.dtoMoto.MotoDTOGet;
import com.example.entities.Moto;

@Component
public class MotoDTOMapper implements Function<Moto, MotoDTOGet> {
	
	@Override
	public MotoDTOGet apply (Moto moto) {
		String concesionariaName = null;
		if(moto.getConcesionaria() != null) {
			concesionariaName = moto.getConcesionaria().getName();
		}
		
		return new MotoDTOGet(
				moto.getBrand(),
				moto.getModel(),
				moto.getMatricula(),
				moto.getLicense(),
				moto.getSeguro(),
				moto.getCasco(),
				concesionariaName
				);
	}
}
