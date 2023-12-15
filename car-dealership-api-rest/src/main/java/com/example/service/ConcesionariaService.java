package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.dao.ServiceDAO;
import com.example.dto.dtoConcesionaria.ConcesionariaDTOGet;
import com.example.dto.dtoConcesionaria.ConcesionariaDTOPost;
import com.example.dto.dtoConcesionaria.ConcesionariaDTOUpdate;
import com.example.dtoMapper.ConcesionariaDTOMapper;
import com.example.entities.Concesionaria;
import com.example.mapper.ConcesionariaMapper;
import com.example.repository.ConcesionariaRepository;
import com.example.updateEntities.ConcesionariaUpdate;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Service
@Validated
public class ConcesionariaService implements ServiceDAO<Concesionaria, ConcesionariaDTOPost, ConcesionariaDTOUpdate, ConcesionariaDTOGet> {
	/*Properties*/
	private final ConcesionariaRepository concesionariaRepository;
	private final ConcesionariaMapper concesionariaMapper;
	private final ConcesionariaDTOMapper concesionariaDTOMapper;
	private final ConcesionariaUpdate concesionariaUpdate;
	/*Construct*/
	@Autowired
	public ConcesionariaService(
			ConcesionariaRepository concesionariaRepository,
			ConcesionariaMapper concesionariaMapper,
			ConcesionariaDTOMapper concesionariaDTOMapper,
			ConcesionariaUpdate concesionariaUpdate
			) {
		this.concesionariaRepository = concesionariaRepository;
		this.concesionariaMapper = concesionariaMapper;
		this.concesionariaDTOMapper = concesionariaDTOMapper;
		this.concesionariaUpdate = concesionariaUpdate;
	}

	/*Construct*/
	@Override
	public Concesionaria create(@Valid ConcesionariaDTOPost concesionariaDTO)
			throws ConstraintViolationException, EntityNotFoundException {
		Concesionaria concesionaria = concesionariaMapper.mapperConcesionaria(concesionariaDTO);
		concesionariaRepository.save(concesionaria);
		return concesionaria;
	}

	/*Methods*/

	@Override
	public ConcesionariaDTOGet update(@NotNull @Positive Long concesionariaID, @Valid ConcesionariaDTOUpdate concesionariaDTO
			) throws ConstraintViolationException, EntityNotFoundException, IllegalArgumentException {
		Concesionaria concesionaria = find(concesionariaID);
		concesionariaUpdate.update(concesionariaDTO, concesionaria);
		
		concesionariaRepository.save(concesionaria);
		return concesionariaDTOMapper.apply(concesionaria);
	}
	
	@Override
	public void delete(@NotNull @Positive Long id) throws ConstraintViolationException, EntityNotFoundException{
		if(concesionariaRepository.existsById(id)) {
			concesionariaRepository.deleteById(id);
		} else {
			throw new EntityNotFoundException("No existe la entidad solicitada");
		}
	}

	@Override
	public Concesionaria find(@NotNull @Positive Long id) 
			throws ConstraintViolationException, EntityNotFoundException {
		Concesionaria concesionaria = concesionariaRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("No existe la entidad concecionaria en la base de datos"));
		return concesionaria;
	}

	@Override
	public List<ConcesionariaDTOGet> findAll() {
		return concesionariaRepository.findAll()
				.stream()
				.map(concesionariaDTOMapper)
				.collect(Collectors.toList());
	}
	
}















