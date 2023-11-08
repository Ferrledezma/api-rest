package com.example.practica3.controller;

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

import com.example.practica3.dto.dtoMoto.MotoDTOGet;
import com.example.practica3.dto.dtoMoto.MotoDTOPost;
import com.example.practica3.dto.dtoMoto.MotoDTOUpdate;
import com.example.practica3.entities.Moto;
import com.example.practica3.service.MotoService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;

@RestController
@RequestMapping("/api/moto")
public class MotoController {
	private final MotoService motoService;

	@Autowired
	public MotoController(MotoService motoService) {
		this.motoService = motoService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Moto> create(@RequestBody MotoDTOPost motoDTO){
		Moto moto;
		try {
			moto = motoService.create(motoDTO);
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
				.buildAndExpand(moto.getId())
				.toUri();
		return ResponseEntity.created(location).body(moto);
	}
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<MotoDTOGet> updateMoto(@PathVariable(name = "id") Long motoID, @RequestBody MotoDTOUpdate motoDTO){
		MotoDTOGet motoUpdate;
		try {
			motoUpdate = motoService.update(motoID, motoDTO);
		} catch(ConstraintViolationException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getCause());
		} catch(EntityNotFoundException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e.getCause());
		}
		
		return ResponseEntity.ok(motoUpdate);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteMoto(@PathVariable(name = "id") Long motoID){
		try {
			motoService.delete(motoID);
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
	public ResponseEntity<Moto> findMoto(@PathVariable(name = "id") Long motoID){
		Moto moto;
		try {
			moto = motoService.find(motoID);
		} catch(ConstraintViolationException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getCause());
		} catch(EntityNotFoundException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e.getCause());
		}
		return ResponseEntity.ok(moto);
	}
	
	@GetMapping("/findAll/{id}")
	public ResponseEntity<List<MotoDTOGet>> findAllMoto(){
		List<MotoDTOGet> motoDTOList = motoService.findAll();
		if(motoDTOList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(motoDTOList);
	}
	
}













