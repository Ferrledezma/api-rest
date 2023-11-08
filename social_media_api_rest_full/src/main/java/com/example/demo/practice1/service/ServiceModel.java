package com.example.demo.practice1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.practice1.constant.ConstantErrorMessage;
import com.example.demo.practice1.entities.EntityModel;
import com.example.demo.practice1.exception.ResourceNotFoundException;
import com.example.demo.practice1.mapper.dtoMapper.DTOMapperInterface;
import com.example.demo.practice1.mapper.entityMapper.EntityMapperInterface;
import com.example.demo.practice1.mapper.updateEntity.UpdateEntityInterface;
import com.example.demo.practice1.repository.RepositoryInterface;

import lombok.Getter;

@Getter
public abstract class ServiceModel<Entity extends EntityModel, DTOPost, DTOGet, DTOUpdate>
implements ServiceInterface<Entity, DTOPost, DTOGet, DTOUpdate> {
	/*Dependencies*/
	@Autowired
	private RepositoryInterface<Entity> repository;
	
	@Autowired
	private EntityMapperInterface<DTOPost, Entity> entityMapper;
	
	@Autowired
	private UpdateEntityInterface<Entity, DTOUpdate> updateEntity;
	
	@Autowired
	private DTOMapperInterface<Entity, DTOGet> dtoMapper;

	/*Methods*/
	@Override
	public DTOGet createResource(DTOPost dtoPost) {
		Entity entity = entityMapper.apply(dtoPost);
		repository.save(entity);
		
		return dtoMapper.apply(entity);
	}
	
	@Override
	public DTOGet updateResource(Long id, DTOUpdate dtoUpdate) throws ResourceNotFoundException {
		Entity entity = findResource(id);
		updateEntity.accept(entity, dtoUpdate);
		repository.save(entity);
		
		return dtoMapper.apply(entity);
	}
	
	@Override
	public void deleteResource(Long id) throws ResourceNotFoundException {
		if(repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			throw new ResourceNotFoundException(String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND, id));
		}
	}
	
	@Override
	public Entity findResource(Long id) throws ResourceNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND, id)));
	}
	
	@Override
	public DTOGet findResourceAsDTO(Long id) throws ResourceNotFoundException {
		return dtoMapper.apply(findResource(id));
	}
	
	@Override
	public List<DTOGet> findAllResource() {
		return repository.findAll()
				.stream()
				.map(dtoMapper)
				.toList();
	}
}















