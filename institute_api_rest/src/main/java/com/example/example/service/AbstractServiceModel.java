package com.example.practica4.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.practica4.entities.AbstractGeneralEntityModel;
import com.example.practica4.mappers.dtoMappers.DTOMapperInterface;
import com.example.practica4.mappers.entityMappers.MapperInterface;
import com.example.practica4.mappers.updateEntity.ContainerEntityAndDTO;
import com.example.practica4.mappers.updateEntity.UpdateEntityInterface;
import com.example.practica4.repository.RepositoryInterface;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public abstract class AbstractServiceModel
<Entity extends AbstractGeneralEntityModel, DtoPost, DtoGet, DtoUpdate>
implements ServiceInterface<Entity, DtoPost, DtoGet, DtoUpdate> {
	/*Dependencies*/
	@Autowired
	private RepositoryInterface<Entity> repository;
	
	@Autowired
	private ContainerEntityAndDTO<Entity, DtoUpdate> containerUpdate;
	
	@Autowired
	private UpdateEntityInterface<Entity, DtoUpdate> updateEntity;
	
	@Autowired
	private MapperInterface<DtoPost, Entity> entityMapper;
	
	@Autowired
	private DTOMapperInterface<Entity, DtoGet> dtoMapper;

	/*Methods*/
	@Override
	public void saveResource(Entity entity) {
		repository.save(entity);
	}
	
	@Override
	public Entity createResource(@Valid DtoPost dtoPost) throws ConstraintViolationException, EntityNotFoundException {
		Entity entity = entityMapper.apply(dtoPost);
		repository.save(entity);
		return entity;
	}
	@Override
	public DtoGet updateResource(@NotNull @Positive Long id, @Valid DtoUpdate dtoUpdate)
			throws ConstraintViolationException, EntityNotFoundException {
		Entity entity = findResource(id);
		
		containerUpdate.setEntity(entity);
		containerUpdate.setDtoUpdate(dtoUpdate);
		
		updateEntity.accept(containerUpdate);
		
		saveResource(entity);
		
		return dtoMapper.apply(entity);
	}
	@Override
	public void deleteResource(@NotNull @Positive Long id) throws ConstraintViolationException, EntityNotFoundException {
		if(repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			throw new EntityNotFoundException("La entidad con el id '" + id + "' no existe en la DB");
		}
	}
	
	@Override
	public Entity findResource(@NotNull @Positive Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("La entidad con el id '" + id + "' no existe en la DB"));
	}
	
	@Override
	public List<DtoGet> findAllResource(){
		List<DtoGet> dtoGetList = repository.findAll()
				.stream()
				.map(dtoMapper)
				.collect(Collectors.toList());
		return dtoGetList;
	}
	
	@Override
	public DtoGet findAndMap(@NotNull @Positive Long id) {
		return dtoMapper.apply(findResource(id));
	}
}








