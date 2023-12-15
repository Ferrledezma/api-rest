package com.example.dtoMapper;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.example.dto.dtoConcesionaria.ConcesionariaDTOGet;
import com.example.entities.Concesionaria;

@Component
public class ConcesionariaDTOMapper implements Function<Concesionaria, ConcesionariaDTOGet> {

	@Override
	public ConcesionariaDTOGet apply(Concesionaria concesionaria) {
		int count;
		ConcesionariaDTOGet concesionariaDTO = new ConcesionariaDTOGet(concesionaria.getName());
		if(!concesionaria.getCars().isEmpty()) {
			count = concesionaria.getCars().size();
			concesionariaDTO.setCars(count);
		}
		if(!concesionaria.getMotos().isEmpty()) {
			count = concesionaria.getMotos().size();
			concesionariaDTO.setMotos(count);
		}
		if(!concesionaria.getBikes().isEmpty()) {
			count = concesionaria.getBikes().size();
			concesionariaDTO.setBikes(count);
		}
		return concesionariaDTO;
	}

}
