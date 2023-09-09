package com.example.practica3.dtoMapper;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.example.practica3.dto.dtoBike.BikeDTOGet;
import com.example.practica3.entities.Bike;

@Component
public class BikeDTOMapper implements Function<Bike, BikeDTOGet> {

	@Override
	public BikeDTOGet apply(Bike bike) {
		String concesionariaName = null;
		if(bike.getCasco() != null) {
			concesionariaName = bike.getConcesionaria().getName();
		}
		return new BikeDTOGet(
				bike.getBrand(),
				bike.getModel(),
				bike.getCasco(),
				concesionariaName
				);
	}

}
