package com.example.practica3.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

import com.example.practica3.dto.dtoConcesionaria.ConcesionariaDTOGet;
import com.example.practica3.dto.dtoConcesionaria.ConcesionariaDTOPost;
import com.example.practica3.dto.dtoConcesionaria.ConcesionariaDTOUpdate;
import com.example.practica3.dtoMapper.ConcesionariaDTOMapper;
import com.example.practica3.entities.Concesionaria;
import com.example.practica3.service.ConcesionariaService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;

@RestController
@RequestMapping("/api/concesionaria")
public class ConcesionariaController {
	private final ConcesionariaService concesionariaService;
	private final ConcesionariaDTOMapper concesionariaDTOMapper;
	
	@Autowired
	public ConcesionariaController(ConcesionariaService concesionariaService, ConcesionariaDTOMapper concesionariaDTOMapper) {
		this.concesionariaService = concesionariaService;
		this.concesionariaDTOMapper = concesionariaDTOMapper;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Concesionaria> createdConcesionaria(@RequestBody ConcesionariaDTOPost concesionariaDTO){
		Concesionaria concesionaria;
		try {
			concesionaria = concesionariaService.create(concesionariaDTO);
		} catch(ConstraintViolationException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getCause());
		} catch(EntityNotFoundException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e.getCause());
		}
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("{id}")
				.buildAndExpand(concesionaria.getId())
				.toUri();
		
		HttpHeaders header = new HttpHeaders();
		header.add("Location", location.toString());
		
		return new ResponseEntity<>(concesionaria, header, HttpStatus.CREATED);
	}
	
	@PatchMapping("/updateRelations/{id}")
	public ResponseEntity<ConcesionariaDTOGet> updateRelations (
			@PathVariable(name = "id") Long concesionariaID,
			ConcesionariaDTOUpdate concesionariaDTOUpdate
			){

		ConcesionariaDTOGet concesionariaDTO;
		try {
			concesionariaDTO = concesionariaService.update(concesionariaID, concesionariaDTOUpdate);
		} catch(ConstraintViolationException | IllegalArgumentException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getCause());
		} catch(EntityNotFoundException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e.getCause());
		}
		
		return new ResponseEntity<>(concesionariaDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteConcesionaria(@PathVariable(name = "id") Long id){
		try {
			concesionariaService.delete(id);
		} catch(ConstraintViolationException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getCause());
		} catch(EntityNotFoundException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e.getCause());
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<ConcesionariaDTOGet> findConcesionaria(@PathVariable(name = "id") Long concesionariaID){
		ConcesionariaDTOGet concesionariaDTO;
		try {
			concesionariaDTO = concesionariaDTOMapper.apply(concesionariaService.find(concesionariaID));
		} catch(ConstraintViolationException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getCause());
		} catch(EntityNotFoundException e) {
			System.err.println(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e.getCause());
		}
		
		return new ResponseEntity<>(concesionariaDTO, HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ConcesionariaDTOGet>> findAllConcesionaria(){
		List<ConcesionariaDTOGet> concesionariaDTOList = concesionariaService.findAll();
		if(concesionariaDTOList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity<>(concesionariaDTOList, HttpStatus.OK);
	}
}
















