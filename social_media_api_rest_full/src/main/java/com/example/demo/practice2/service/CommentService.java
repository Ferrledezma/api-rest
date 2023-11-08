package com.example.demo.practice2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.practice2.repository.CommentRepository;
import com.example.demo.practice2.constant.ConstantErrorMessage;
import com.example.demo.practice2.constant.ConstantTableName;
import com.example.demo.practice2.dto.comment.CommentDTOGet;
import com.example.demo.practice2.dto.comment.CommentDTOPost;
import com.example.demo.practice2.dto.comment.CommentDTOUpdate;
import com.example.demo.practice2.entities.CommentEntity;
import com.example.demo.practice2.exception.personalizate_exception.NoRelationException;
import com.example.demo.practice2.exception.personalizate_exception.ResourceNotFoundException;
import com.example.demo.practice2.repository.PublicationRepository;
import com.example.demo.practice2.repository.UserRepository;
import com.example.demo.practice2.request.container_request_id.ContainerCommentId;

@Service
public class CommentService extends ServiceModel<CommentEntity, CommentDTOPost, CommentDTOGet, CommentDTOUpdate, ContainerCommentId> {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PublicationRepository publicationRepository;
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public CommentEntity createResource(CommentDTOPost dtoPost) {
		ContainerCommentId containerId = new ContainerCommentId(dtoPost.getUserId(), dtoPost.getPublicationId());
		existsRelation(containerId);
		return super.createResource(dtoPost);
	}
	@Override
	public List<CommentDTOGet> findAllResourceAsDTO(ContainerCommentId containerId) throws ResourceNotFoundException, NoRelationException {
		existsRelation(containerId);
		
		return commentRepository.findCommentByPublicationId(containerId.getUserId(), containerId.getPublicationId())
				.stream()
				.map(dtoMapper)
				.toList();
	}
	
	@Override
	public void existsRelation(ContainerCommentId containerId) throws ResourceNotFoundException, NoRelationException {
		super.existsRelation(containerId);
		if(userRepository.existsById(containerId.getUserId())) {
			if(publicationRepository.existsById(containerId.getPublicationId())) {
				if(containerId.getEntityOperateId() != null && commentRepository.existsByIdAndPublicationId(containerId.getEntityOperateId(), containerId.getPublicationId()) == 0) {
					throw new NoRelationException(String.format(ConstantErrorMessage.NO_RELATION, ConstantTableName.PUBLICATION_TABLE, ConstantTableName.COMMENT_TABLE));
				}
			} else {
				throw new NoRelationException(String.format(ConstantErrorMessage.NO_RELATION, ConstantTableName.USER_TABLE, ConstantTableName.PUBLICATION_TABLE));
			}
		} else {
			throw new ResourceNotFoundException(String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND, containerId.getUserId()));
		}
	}
}
