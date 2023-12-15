package com.example.springboot.social_network.service.type.repository.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import com.example.springboot.social_network.constant.ConstantErrorMessage;
import com.example.springboot.social_network.entities.model.GeneralEntityModel;
import com.example.springboot.social_network.exception.ResourceNotFoundException;
import com.example.springboot.social_network.mapper.dto.model.DTOMapperInterface;
import com.example.springboot.social_network.mapper.entities.model.EntityMapperInterface;
import com.example.springboot.social_network.mapper.update.model.EntityUpdateInterface;
import com.example.springboot.social_network.repository.model.RepositoryInterface;
import com.example.springboot.social_network.request.id.RequestId;
import com.example.springboot.social_network.request.response.PageResponseBody;

public abstract class RepositoryServiceModel<Entity extends GeneralEntityModel, DTOPost, DTOGet, DTOUpdate>
implements RepositoryServiceInterface<Entity, DTOPost, DTOGet, DTOUpdate> {
	@Autowired
	protected RepositoryInterface<Entity> repository;
	
	@Autowired
	protected EntityMapperInterface<DTOPost, Entity> entityMapper;
	
	@Autowired
	protected DTOMapperInterface<Entity, DTOGet> dtoMapper;
	
	@Autowired
	protected EntityUpdateInterface<Entity, DTOUpdate> updateMapper;

	@Override
	public Entity create(DTOPost dtoPost) throws ResourceNotFoundException {
		Entity entity = entityMapper.apply(dtoPost);
		
		return repository.save(entity);
	}
	
	@Override
	public DTOGet update(RequestId idContainer, DTOUpdate dtoUpdate) throws ResourceNotFoundException {
		Entity entity = find(idContainer);
		
		updateMapper.accept(entity, dtoUpdate);
		
		repository.save(entity);
		
		return dtoMapper.apply(entity);
	}
	
	@Override
	public void delete(RequestId containerId) throws ResourceNotFoundException {
		comprobate(containerId);
		if(repository.existsById(containerId.getMainId())) {
			repository.deleteById(containerId.getMainId());
		} else {
			throw new ResourceNotFoundException(String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, containerId.getMainId()));
		}
	}
	
	@Override
	public Entity find(RequestId idContainer) throws ResourceNotFoundException {
		comprobate(idContainer);
		
		return repository.findById(idContainer.getMainId())
				.orElseThrow(() -> new ResourceNotFoundException(
						String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, + idContainer.getMainId())
						));
	}
	
	@Override
	public DTOGet findAsDTO(RequestId idContainer) throws ResourceNotFoundException {
		return dtoMapper.apply(find(idContainer));
	}
	
	@Override
	public List<Entity> findAll(RequestId containerId) {
		comprobate(containerId);
		return repository.findAll();
	}
	
	@Override
	public List<DTOGet> findAllAsDTO(RequestId containerId) {
		return findAll(containerId)
				.stream()
				.map(dtoMapper)
				.toList();
	}
	
	@Override
	public PageResponseBody<DTOGet> findByPage(Pageable pageRequest){
		
		List<DTOGet> userDTOList = repository.findAll(pageRequest)
				.map(dtoMapper)
				.toList();
		
		return new PageResponseBody<>(
				pageRequest.getPageNumber(),
				pageRequest.getPageSize(),
				pageRequest.getSort().toString(),
				userDTOList
				);
	}
	
	protected void comprobate(RequestId idContainer) throws ResourceNotFoundException {
		if(idContainer != null) {
			if(!repository.existsById(idContainer.getMainId())) {
				throw new ResourceNotFoundException(String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, idContainer.getMainId()));
			}
		}
	}
}




















