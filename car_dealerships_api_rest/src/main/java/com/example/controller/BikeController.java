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

import com.example.dto.dtoBike.BikeDTOGet;
import com.example.dto.dtoBike.BikeDTOPost;
import com.example.dto.dtoBike.BikeDTOUpdate;
import com.example.entities.Bike;
import com.example.service.BikeService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;

@RestController
@RequestMapping("/api/bici")
public class BikeController {
	private final BikeService bikeService;

	@Autowired
	public BikeController(BikeService bikeService) {
		this.bikeService = bikeService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Bike> create(@RequestBody BikeDTOPost bikeDTO){
		Bike bike;
		try {
			bike = bikeService.create(bikeDTO);
		} catch(ConstraintViolationException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getCause());
		} catch(EntityNotFoundException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e.getCause());
		}
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(bike.getId())
				.toUri();
		return ResponseEntity.created(location).body(bike);
	}
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<BikeDTOGet> updateBike(@PathVariable(name = "id") Long bikeID, @RequestBody BikeDTOUpdate bikeDTO){
		BikeDTOGet bikeUpdate;
		try {
			bikeUpdate = bikeService.update(bikeID, bikeDTO);
		} catch(ConstraintViolationException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getCause());
		} catch(EntityNotFoundException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e.getCause());
		}
		return ResponseEntity.ok(bikeUpdate);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteBike(@PathVariable(name = "id") Long bikeID){
		try { 
			bikeService.delete(bikeID);
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
	public ResponseEntity<Bike> findBike(@PathVariable(name = "id") Long bikeID){
		Bike bike;
		try {
			bike = bikeService.find(bikeID);
		} catch(ConstraintViolationException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getCause());
		} catch(EntityNotFoundException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e.getCause());
		}
		return ResponseEntity.ok(bike);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<BikeDTOGet>> findAllBikes(){
		List<BikeDTOGet> bikeDTOList = bikeService.findAll();
		if(bikeDTOList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(bikeDTOList);
	}
}















