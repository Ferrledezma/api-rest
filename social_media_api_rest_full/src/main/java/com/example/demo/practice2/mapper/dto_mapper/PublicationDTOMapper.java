package com.example.demo.practice2.mapper.dto_mapper;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.practice2.dto.comment.CommentDTOGet;
import com.example.demo.practice2.dto.publication.PublicationDTOGet;
import com.example.demo.practice2.entities.PublicationEntity;

@Component
public class PublicationDTOMapper implements DTOMapperInterface<PublicationEntity, PublicationDTOGet> {
	@Autowired
	private CommentDTOMapper commentDTOMapper;
	@Override
	public PublicationDTOGet apply(PublicationEntity publication) {
		Map<String, String> commentList = publication.getComments()
				.stream()
				.map(commentDTOMapper)
				.collect(Collectors.toMap(CommentDTOGet::getUserIdentifier, CommentDTOGet::getContent));
		
		return new PublicationDTOGet(
				publication.getTitle(),
				publication.getContent(),
				publication.getUser().getUserIdentifier(),
				commentList
				);
	}
}
