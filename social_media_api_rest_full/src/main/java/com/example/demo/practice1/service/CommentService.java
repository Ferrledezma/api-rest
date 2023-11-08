package com.example.demo.practice1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.practice1.constant.ConstantErrorMessage;
import com.example.demo.practice1.dto.comment.CommentDTOGet;
import com.example.demo.practice1.dto.comment.CommentDTOPost;
import com.example.demo.practice1.dto.comment.CommentDTOUpdate;
import com.example.demo.practice1.entities.CommentEntity;
import com.example.demo.practice1.entities.PublicationEntity;
import com.example.demo.practice1.exception.NotValidRelationException;
import com.example.demo.practice1.exception.ResourceNotFoundException;
import com.example.demo.practice1.repository.CommentRepository;
import com.example.demo.practice1.repository.PublicationRepository;

@Service
public class CommentService extends ServiceModel<CommentEntity, CommentDTOPost, CommentDTOGet, CommentDTOUpdate> {
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	PublicationRepository publicationRepository;

	public CommentDTOGet createResource(Long publicationId, CommentDTOPost commentDTO) {
		PublicationEntity publication = publicationRepository.findById(publicationId)
				.orElseThrow(() -> new ResourceNotFoundException(String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND, publicationId)));
		
		CommentEntity comment = getEntityMapper().apply(commentDTO);
		comment.setPublication(publication);
		
		commentRepository.save(comment);
		
		return getDtoMapper().apply(comment);
	}
	public List<CommentDTOGet> findPublicationComments(Long publicationId) throws ResourceNotFoundException{
		if(!publicationRepository.existsById(publicationId)) {
			throw new ResourceNotFoundException(String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND, publicationId));
		}
		
		return commentRepository.findCommentByPublicationId(publicationId)
				.stream()
				.map(getDtoMapper())
				.collect(Collectors.toList());
	}
	
	public void existsPublicationComment(Long commentId, Long publicationId) throws NotValidRelationException{
		if(commentRepository.existsPublicationComment(commentId, publicationId) == 0) {
			throw new NotValidRelationException(String.format(ConstantErrorMessage.NOT_RELATION, commentId, publicationId));
		}
	}
}











