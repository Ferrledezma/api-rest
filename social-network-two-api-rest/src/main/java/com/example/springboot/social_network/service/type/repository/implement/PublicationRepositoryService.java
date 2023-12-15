package com.example.springboot.social_network.service.type.repository.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.social_network.constant.ConstantErrorMessage;
import com.example.springboot.social_network.constant.ConstantTableName;
import com.example.springboot.social_network.dto.implement.publication.PublicationDTOGet;
import com.example.springboot.social_network.dto.implement.publication.PublicationDTOPost;
import com.example.springboot.social_network.dto.implement.publication.PublicationDTOUpdate;
import com.example.springboot.social_network.entities.implement.PublicationEntity;
import com.example.springboot.social_network.exception.NotRelationException;
import com.example.springboot.social_network.exception.NotValidException;
import com.example.springboot.social_network.exception.ResourceNotFoundException;
import com.example.springboot.social_network.repository.implement.PublicationRepository;
import com.example.springboot.social_network.request.id.RequestId;
import com.example.springboot.social_network.service.type.repository.model.RepositoryServiceModel;

@Service
public class PublicationRepositoryService extends RepositoryServiceModel<PublicationEntity, PublicationDTOPost, PublicationDTOGet, PublicationDTOUpdate> {
	@Autowired
	private PublicationRepository publicationRepository;

	@Override
	public List<PublicationEntity> findAll(RequestId containerId) {
		return publicationRepository.findPublicationsByUserId(containerId.getUserId());
	}
	
	@Override
	protected void comprobate(RequestId idContainer) throws ResourceNotFoundException, NotRelationException, NotValidException {
		if(idContainer != null) {
			super.comprobate(idContainer);
			
			String userMessage;
			String publicationMessage;
			
			if(idContainer.getUserId() != null && idContainer.getPublicationId() != null) {
				if(publicationRepository.existsPublicationByUserId(idContainer.getPublicationId(), idContainer.getUserId()) != 1) {
					userMessage = ConstantTableName.USER_TABLE_NAME + " " + idContainer.getUserId();
					publicationMessage = ConstantTableName.PUBLICATION_TABLE_NAME + " " + idContainer.getPublicationId();
					
					throw new NotRelationException(String.format(ConstantErrorMessage.NO_RELATION_MESSAGE, userMessage , publicationMessage));
				}
			} else {
				throw new NotValidException(String.format(ConstantErrorMessage.NOT_VALID_DATA_MESSAGE, "null", "find"));
			}
		}
	}
}



















