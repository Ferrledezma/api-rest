package com.example.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.dto.dtoCar.CarDTOGet;
import com.example.dto.dtoCar.CarDTOPost;
import com.example.dto.dtoCar.CarDTOUpdate;
import com.example.entities.Car;
import com.example.service.CarService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;

@RestController
@RequestMapping("/api/auto")
public class CarController {
	private final CarService carService;
	
	@Autowired
	public CarController(CarService carService) {
		this.carService = carService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Car> createCar(@RequestBody CarDTOPost carDTO){
		Car car;
		try {
			car = carService.create(carDTO);
		} catch(ConstraintViolationException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getCause());
		} catch(EntityNotFoundException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getCause());
		}
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(car.getId())
				.toUri();
		return ResponseEntity.created(location).body(car);		
	}
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<CarDTOGet> updateCar(@PathVariable(name = "id") Long carID, @RequestBody CarDTOUpdate carDTO){
		CarDTOGet updateCar;
		try {
			updateCar = carService.update(carID, carDTO);
		} catch(ConstraintViolationException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getCause());
		} catch(EntityNotFoundException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e.getCause());
		}
		return ResponseEntity.ok(updateCar);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCar(@PathVariable(name = "id") Long carID){
		try {
			carService.delete(carID);
		} catch(ConstraintViolationException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getCause());
		} catch(EntityNotFoundException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e.getCause());
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Car> findCar(@PathVariable Long carID){
		Car car;
		try {
			car = carService.find(carID);
		} catch(ConstraintViolationException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getCause());
		} catch(EntityNotFoundException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e.getCause());
		}
		return ResponseEntity.ok(car);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<CarDTOGet>> findAll(){
		List<CarDTOGet> carDTOList = carService.findAll();
		if(carDTOList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carDTOList);
	}
}















