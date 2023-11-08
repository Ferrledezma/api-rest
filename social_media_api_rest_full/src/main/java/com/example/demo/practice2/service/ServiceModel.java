package com.example.demo.practice2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.practice2.constant.ConstantErrorMessage;
import com.example.demo.practice2.entities.EntityModel;
import com.example.demo.practice2.exception.personalizate_exception.NoRelationException;
import com.example.demo.practice2.exception.personalizate_exception.ResourceNotFoundException;
import com.example.demo.practice2.mapper.dto_mapper.DTOMapperInterface;
import com.example.demo.practice2.mapper.entity_mapper.EntityMapperInterface;
import com.example.demo.practice2.mapper.update_entity.EntityUpdateInterface;
import com.example.demo.practice2.repository.RepositoryInterface;
import com.example.demo.practice2.request.container_request_id.ContainerIdModel;
import com.example.demo.practice2.request.response_body.PageResponseBody;

@Service
public abstract class ServiceModel<Entity extends EntityModel, DTOPost, DTOGet, DTOUpdate, ContainerId extends ContainerIdModel>
implements ServiceInterface<Entity, DTOPost, DTOGet, DTOUpdate, ContainerId> {
	/*Dependencies*/
	@Autowired
	protected RepositoryInterface<Entity> repository;
	@Autowired
	protected EntityMapperInterface<DTOPost, Entity> entityMapper;
	@Autowired
	protected DTOMapperInterface<Entity, DTOGet> dtoMapper;
	@Autowired
	protected EntityUpdateInterface<Entity, DTOUpdate> entityUpdate;

	/*Methods*/
	@Override
	public Entity createResource(DTOPost dtoPost) {
		Entity entity = entityMapper.apply(dtoPost);
		return repository.save(entity);
	}
	
	@Override
	public DTOGet updateResource(ContainerId containerId, DTOUpdate dtoUpdate) throws ResourceNotFoundException, NoRelationException {
		
		Entity entity = findResource(containerId);
		
		entityUpdate.accept(entity, dtoUpdate);
		repository.save(entity);
		
		return dtoMapper.apply(entity);
	}
	
	@Override
	public void deleteResource(ContainerId containerId) throws ResourceNotFoundException, NoRelationException {
		existsRelation(containerId);
		repository.deleteById(containerId.getEntityOperateId());
	}
	
	@Override
	public Entity findResource(ContainerId containerId) throws ResourceNotFoundException, NoRelationException {
		existsRelation(containerId);
		
		return repository.findById(containerId.getEntityOperateId())
				.orElseThrow(() -> new ResourceNotFoundException(String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND, containerId.getEntityOperateId())));
	}
	
	@Override
	public DTOGet findResourceAsDTO(ContainerId containerId) throws ResourceNotFoundException, NoRelationException {
		return dtoMapper.apply(findResource(containerId));
	}
	
	@Override
	public List<DTOGet> findAllResourceAsDTO() {
		return repository.findAll()
				.stream()
				.map(dtoMapper)
				.toList();
	}
	
	@Override
	public List<DTOGet> findAllResourceAsDTO(ContainerId containerId) throws ResourceNotFoundException, NoRelationException {
		return null;
	}
	
	@Override
	public PageResponseBody<DTOGet> findByPage(Integer pageNumber, Integer pageSize, String columnSort) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(columnSort));
		List<DTOGet> dtoList = repository.findAll(pageable)
				.stream()
				.map(dtoMapper)
				.toList();
		
		return new PageResponseBody<>(pageNumber, pageSize, columnSort, dtoList);
	}
	
	@Override
	public void existsRelation(ContainerId containerId) throws ResourceNotFoundException, NoRelationException {
		if(containerId.getEntityOperateId() != null && !repository.existsById(containerId.getEntityOperateId())) {
			throw new ResourceNotFoundException(String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND, containerId.getEntityOperateId()));
		}
	}
}













