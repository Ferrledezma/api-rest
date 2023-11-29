package com.example.demo.social_network.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.social_network.constant.ConstantErrorMessage;
import com.example.demo.social_network.constant.ConstantTableName;
import com.example.demo.social_network.dto.publication.PublicationDTOGet;
import com.example.demo.social_network.dto.publication.PublicationDTOPost;
import com.example.demo.social_network.dto.publication.PublicationDTOUpdate;
import com.example.demo.social_network.entities.PublicationEntity;
import com.example.demo.social_network.exception.personalizate_exception.NoRelationException;
import com.example.demo.social_network.exception.personalizate_exception.ResourceNotFoundException;
import com.example.demo.social_network.repository.PublicationRepository;
import com.example.demo.social_network.repository.UserRepository;
import com.example.demo.social_network.request.container_request_id.ContainerPublicationId;

@Service
public class PublicationService extends ServiceModel<PublicationEntity, PublicationDTOPost, PublicationDTOGet, PublicationDTOUpdate, ContainerPublicationId> {
	@Autowired
	private PublicationRepository publicationRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<PublicationDTOGet> findAllResourceAsDTO(ContainerPublicationId containerId) throws ResourceNotFoundException {
		existsRelation(containerId);
		
		return publicationRepository.findPublicationByUserId(containerId.getUserId())
				.stream()
				.map(dtoMapper)
				.toList();
	}
	
	@Override
	public void existsRelation(ContainerPublicationId containerId) throws ResourceNotFoundException, NoRelationException {
		super.existsRelation(containerId);
		
		if(userRepository.existsById(containerId.getUserId())) {
			if(containerId.getEntityOperateId() != null && publicationRepository.existsByIdAndUserId(containerId.getEntityOperateId(), containerId.getUserId()) == 0) {
				throw new NoRelationException(String.format(ConstantErrorMessage.NO_RELATION, ConstantTableName.USER_TABLE, ConstantTableName.PUBLICATION_TABLE));
			}
		} else {
			throw new ResourceNotFoundException(String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND, containerId.getUserId()));
		}
	}
}


















