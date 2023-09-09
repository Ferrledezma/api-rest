package com.example.practica3.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.practica3.dao.ServiceDAO;
import com.example.practica3.dto.dtoBike.BikeDTOGet;
import com.example.practica3.dto.dtoBike.BikeDTOPost;
import com.example.practica3.dto.dtoBike.BikeDTOUpdate;
import com.example.practica3.dtoMapper.BikeDTOMapper;
import com.example.practica3.entities.Bike;
import com.example.practica3.mapper.BikeMapper;
import com.example.practica3.repository.BikeRepository;
import com.example.practica3.updateEntities.BikeUpdate;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Service
@Validated
public class BikeService implements ServiceDAO<Bike, BikeDTOPost, BikeDTOUpdate, BikeDTOGet> {
	/*Properties*/
	private final BikeRepository bikeRepository;
	private final BikeMapper bikeMapper;
	private final BikeDTOMapper bikeDTOMapper;
	private final BikeUpdate bikeUpdate;
	/*Construct*/
	@Autowired
	public BikeService(BikeRepository bikeRepository, BikeMapper bikeMapper, BikeDTOMapper bikeDTOMapper, BikeUpdate bikeUpdate) {
		this.bikeRepository = bikeRepository;
		this.bikeMapper = bikeMapper;
		this.bikeDTOMapper = bikeDTOMapper;
		this.bikeUpdate = bikeUpdate;
	}

	/*Methods*/
	@Override
	public Bike create(@Valid BikeDTOPost bikeDTO) throws ConstraintViolationException, EntityNotFoundException{
		Bike bike = bikeMapper.mapperBike(bikeDTO);
		bikeRepository.save(bike);
		return bike;
	}

	@Override
	public BikeDTOGet update(@NotNull @Positive Long id, @Valid BikeDTOUpdate bikeDTO) throws ConstraintViolationException, EntityNotFoundException{
		Bike bike = find(id);
		bikeUpdate.update(bikeDTO, bike);
		
		bikeRepository.save(bike);
		return bikeDTOMapper.apply(bike);
	}

	@Override
	public void delete(@NotNull @Positive Long id) throws ConstraintViolationException, EntityNotFoundException{
		if(bikeRepository.existsById(id)) {
			bikeRepository.deleteById(id);
		} else {
			throw new EntityNotFoundException("No existe la entidad bike en la base de datos");
		}
	}

	@Override
	public Bike find(@NotNull @Positive Long id) throws ConstraintViolationException, EntityNotFoundException{
		Bike bike = bikeRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("No existe la entidad bike en la base de datos"));
		return bike;
	}

	@Override
	public List<BikeDTOGet> findAll() {
		return bikeRepository.findAll()
				.stream()
				.map(bikeDTOMapper)
				.collect(Collectors.toList());
	}
}









