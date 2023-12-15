package com.example.springboot.social_network.service.type.repository.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.social_network.constant.ConstantErrorMessage;
import com.example.springboot.social_network.constant.ConstantTableName;
import com.example.springboot.social_network.dto.implement.comment.CommentDTOGet;
import com.example.springboot.social_network.dto.implement.comment.CommentDTOPost;
import com.example.springboot.social_network.dto.implement.comment.CommentDTOUpdate;
import com.example.springboot.social_network.entities.implement.CommentEntity;
import com.example.springboot.social_network.exception.NotRelationException;
import com.example.springboot.social_network.exception.NotValidException;
import com.example.springboot.social_network.exception.ResourceNotFoundException;
import com.example.springboot.social_network.repository.implement.CommentRepository;
import com.example.springboot.social_network.request.id.RequestId;
import com.example.springboot.social_network.service.type.repository.model.RepositoryServiceModel;

@Service
public class CommentRepositoryService extends RepositoryServiceModel<CommentEntity, CommentDTOPost, CommentDTOGet, CommentDTOUpdate> {
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PublicationRepositoryService publicationRepositoryService;

	@Override
	public List<CommentEntity> findAll(RequestId containerId) {
		publicationRepositoryService.comprobate(containerId);
		
		return commentRepository.findCommentsByPublicationId(containerId.getPublicationId());
	}

	@Override
	protected void comprobate(RequestId idContainer)
			throws ResourceNotFoundException, NotRelationException, NotValidException {
		if(idContainer != null) {
			super.comprobate(idContainer);

			String relationMessage;
			String commentMessage;

			if (idContainer.getUserId() != null && idContainer.getPublicationId() != null && idContainer.getCommentId() != null) {
				if (commentRepository.existsCommentByPublicationId(idContainer.getCommentId(), idContainer.getUserId(), idContainer.getPublicationId()) != 1) {
					
					relationMessage = ConstantTableName.USER_TABLE_NAME + " " + idContainer.getUserId()
					+ ", " + ConstantTableName.PUBLICATION_TABLE_NAME + " " + idContainer.getPublicationId();
					
					commentMessage = ConstantTableName.COMMENT_TABLE_NAME + " " + idContainer.getCommentId();

					throw new NotRelationException(String.format(ConstantErrorMessage.NO_RELATION_MESSAGE, relationMessage, commentMessage));
				}
			} else {
				throw new NotValidException(String.format(ConstantErrorMessage.NOT_VALID_DATA_MESSAGE, "null"));
			}
		}
	}
}
