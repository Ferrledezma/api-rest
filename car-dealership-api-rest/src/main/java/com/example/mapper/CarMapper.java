package com.example.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dto.dtoCar.CarDTOPost;
import com.example.entities.Car;
import com.example.entities.Concesionaria;
import com.example.repository.ConcesionariaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;

@Component
public class CarMapper {
	@Autowired
	private ConcesionariaRepository concesionariaRepository;
	
	public Car mapperCar(CarDTOPost carDTO) throws ConstraintViolationException, EntityNotFoundException{
		Car car = new Car(
				null,
				carDTO.getBrand(),
				carDTO.getModel(),
				carDTO.getMatricula(),
				carDTO.getLicencia(),
				carDTO.getSeguro(),
				carDTO.getRto()
				);
		if(carDTO.getConcesionariaID() != null) {
			Concesionaria concesionaria = concesionariaRepository.findById(carDTO.getConcesionariaID())
					.orElseThrow(() -> new EntityNotFoundException("No existe la entidad concesionaria en la base de datos"));
			car.setConcesionaria(concesionaria);
		}
		return car;
	}
}
