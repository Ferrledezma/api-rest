package com.example.springboot.social_network.mapper.update.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springboot.social_network.constant.ConstantErrorMessage;
import com.example.springboot.social_network.constant.ConstantTableName;
import com.example.springboot.social_network.dto.implement.publication.PublicationDTOUpdate;
import com.example.springboot.social_network.entities.implement.CommentEntity;
import com.example.springboot.social_network.entities.implement.PublicationEntity;
import com.example.springboot.social_network.exception.ResourceNotFoundException;
import com.example.springboot.social_network.mapper.update.model.EntityUpdateInterface;
import com.example.springboot.social_network.repository.implement.CommentRepository;

@Component
public class PublicationEntityUpdate implements EntityUpdateInterface<PublicationEntity, PublicationDTOUpdate> {
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public void accept(PublicationEntity publication, PublicationDTOUpdate publicationDTOUpdate) throws ResourceNotFoundException{
		if(publicationDTOUpdate.getTitle() != null && !publicationDTOUpdate.getTitle().isBlank()) {
			publication.setTitle(publicationDTOUpdate.getTitle());
		}
		
		if(publicationDTOUpdate.getContent() != null && !publicationDTOUpdate.getContent().isBlank()) {
			publication.setContent(publicationDTOUpdate.getContent());
		}
		
		if(publicationDTOUpdate.getIdCommentsDelete() != null && !publicationDTOUpdate.getIdCommentsDelete().isEmpty()) {
			for(Long id : publicationDTOUpdate.getIdCommentsDelete()) {
				CommentEntity comment = commentRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException(
								String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, ConstantTableName.COMMENT_TABLE_NAME + " " + id)
								));
				
				if(publication.getComments().contains(comment)) {
					publication.getComments().remove(comment);
				}
			}
		}
	}

}




















