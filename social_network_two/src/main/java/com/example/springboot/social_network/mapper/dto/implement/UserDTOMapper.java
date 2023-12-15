package com.example.springboot.social_network.mapper.dto.implement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.springboot.social_network.dto.implement.user.UserDTOGet;
import com.example.springboot.social_network.entities.implement.PublicationEntity;
import com.example.springboot.social_network.entities.implement.UserEntity;
import com.example.springboot.social_network.mapper.dto.model.DTOMapperInterface;

@Component
public class UserDTOMapper implements DTOMapperInterface<UserEntity, UserDTOGet> {

	@Override
	public UserDTOGet apply(UserEntity user) {
		List<String> friendList = user.getFriends()
				.stream()
				.map(friend -> friend.getIdentifier())
				.toList();
		
		Map<String, String> userPublications = new HashMap<>();
		
		for(PublicationEntity publication : user.getPublications()) {
			String title = publication.getTitle();
			String numberComments = "Number of comments: " + publication.getComments().size();
			userPublications.put(title, numberComments);
		}
		
		return new UserDTOGet(
				user.getSurName(),
				user.getForName(),
				user.getSex(),
				user.getBirthDate(),
				user.getIdentifier(),
				user.getFriends().size(),
				friendList,
				userPublications,
				user.getComments().size()
				);
	}

}
