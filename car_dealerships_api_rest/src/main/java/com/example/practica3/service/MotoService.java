package com.example.practica3.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.practica3.dao.ServiceDAO;
import com.example.practica3.dto.dtoMoto.MotoDTOGet;
import com.example.practica3.dto.dtoMoto.MotoDTOPost;
import com.example.practica3.dto.dtoMoto.MotoDTOUpdate;
import com.example.practica3.dtoMapper.MotoDTOMapper;
import com.example.practica3.entities.Moto;
import com.example.practica3.mapper.MotoMapper;
import com.example.practica3.repository.MotoRepository;
import com.example.practica3.updateEntities.MotoUpdate;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Service
@Validated
public class MotoService implements ServiceDAO<Moto, MotoDTOPost, MotoDTOUpdate, MotoDTOGet> {
	/*Properties*/
	private final MotoRepository motoRepository;
	private final MotoMapper motoMapper;
	private final MotoDTOMapper motoDTOMapper;
	private final MotoUpdate motoUpdate;
	
	/*Construct*/
	@Autowired
	public MotoService(
			MotoRepository motoRepository,
			MotoMapper motoMapper,
			MotoDTOMapper motoDTOMapper,
			MotoUpdate motoUpdate) {
		this.motoRepository = motoRepository;
		this.motoMapper = motoMapper;
		this.motoDTOMapper = motoDTOMapper;
		this.motoUpdate = motoUpdate;
	}

	/*Methods*/
	@Override
	public Moto create(@Valid MotoDTOPost motoDTO) throws ConstraintViolationException, EntityNotFoundException {
		Moto moto = motoMapper.motoMapper(motoDTO);
		motoRepository.save(moto);
		return moto;
	}

	@Override
	public MotoDTOGet update(@NotNull @Positive Long id, @Valid MotoDTOUpdate motoDTO) 
			throws ConstraintViolationException, EntityNotFoundException {
		Moto moto = find(id);
		motoUpdate.update(motoDTO, moto);
		
		motoRepository.save(moto);
		return motoDTOMapper.apply(moto);
	}

	@Override
	public void delete(@NotNull @Positive Long id) throws ConstraintViolationException, EntityNotFoundException {
		if(motoRepository.existsById(id)) {
			motoRepository.deleteById(id);
		} else {
			throw new EntityNotFoundException("No se encontro la entidad moto en la base de datos");
		}
		
	}

	@Override
	public Moto find(@NotNull @Positive Long id) throws ConstraintViolationException, EntityNotFoundException {
		Moto moto = motoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("No existe la entidad moto solicitada"));
		return moto;
	}

	@Override
	public List<MotoDTOGet> findAll() {
		return motoRepository.findAll()
				.stream()
				.map(motoDTOMapper)
				.collect(Collectors.toList());
	}
}







