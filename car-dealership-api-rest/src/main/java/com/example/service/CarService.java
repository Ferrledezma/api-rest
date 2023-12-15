package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.dao.ServiceDAO;
import com.example.dto.dtoCar.CarDTOGet;
import com.example.dto.dtoCar.CarDTOPost;
import com.example.dto.dtoCar.CarDTOUpdate;
import com.example.dtoMapper.CarDTOMapper;
import com.example.entities.Car;
import com.example.mapper.CarMapper;
import com.example.repository.CarRepository;
import com.example.updateEntities.CarUpdate;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Service
@Validated
public class CarService implements ServiceDAO<Car, CarDTOPost, CarDTOUpdate, CarDTOGet> {
	/*Properties*/
	private final CarRepository carRepository;
	private final CarMapper carMapper;
	private final CarDTOMapper carDTOMapper;
	private final CarUpdate updateCar;
	
	/*Construct*/
	@Autowired
	public CarService(
			CarRepository carRepository,
			CarMapper carMapper,
			CarDTOMapper carDTOMapper,
			CarUpdate updateCar) {
		this.carRepository = carRepository;
		this.carMapper = carMapper;
		this.carDTOMapper = carDTOMapper;
		this.updateCar = updateCar;
	}

	/*Methods*/
	@Override
	public Car create(@Valid CarDTOPost carDTO) throws ConstraintViolationException, EntityNotFoundException {
		Car car = carMapper.mapperCar(carDTO);
		carRepository.save(car);
		return car;
	}

	@Override
	public CarDTOGet update(@NotNull @Positive Long id, @Valid CarDTOUpdate carDTO)
			throws ConstraintViolationException, EntityNotFoundException {
		Car car = find(id);
		updateCar.update(carDTO, car);
		
		carRepository.save(car);
		return carDTOMapper.apply(car);
	}

	@Override
	public void delete(@NotNull @Positive Long id) throws ConstraintViolationException, EntityNotFoundException {
		if(carRepository.existsById(id)) {
			carRepository.deleteById(id);
		} else {
			throw new EntityNotFoundException("No existe la entidad car en la base de datos");
		}
	}

	@Override
	public Car find(@NotNull @Positive Long id) throws ConstraintViolationException, EntityNotFoundException {
		Car car = carRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("No existe la entidad auto solicitada"));
		return car;
	}

	@Override
	public List<CarDTOGet> findAll() {
		return carRepository.findAll()
				.stream()
				.map(carDTOMapper)
				.collect(Collectors.toList());
	}
}
