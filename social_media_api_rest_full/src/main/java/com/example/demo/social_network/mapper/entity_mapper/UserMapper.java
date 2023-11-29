package com.example.demo.social_network.mapper.entity_mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.social_network.constant.ConstantErrorMessage;
import com.example.demo.social_network.dto.user.UserDTOPost;
import com.example.demo.social_network.entities.UserEntity;
import com.example.demo.social_network.exception.personalizate_exception.ResourceNotFoundException;
import com.example.demo.social_network.repository.UserRepository;

@Component
public class UserMapper implements EntityMapperInterface<UserDTOPost, UserEntity> {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity apply(UserDTOPost userDTO) {
		String userIdentifier = generateUserIdentifier(userDTO.getUserIdentifier());
		
		UserEntity user = UserEntity.builder()
				.userIdentifier(userIdentifier)
				.userName(userDTO.getUserName().trim())
				.build();
		
		if(userDTO.getFriendList() != null && !userDTO.getFriendList().isEmpty()) {
			for(Long id : userDTO.getFriendList()) {
				userRepository.findById(id)
					.map(entity -> {
						user.getFriendUsers().add(entity);
						return entity.getFriendUsers().add(user);
					})
					.orElseThrow(() -> new ResourceNotFoundException(String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND, id)));
			}
		}
		
		return user;
	}
	
	private String generateUserIdentifier(String userIdentifier) {
		final String hashIdentifier = "@";
		
		int count = userIdentifier.length() - userIdentifier.replaceAll(hashIdentifier, "").length();
		
		if((userIdentifier.contains(hashIdentifier) && !userIdentifier.startsWith(hashIdentifier)) || (count == 0 || count > 1)) {
			if(userIdentifier.contains(hashIdentifier)) {
				userIdentifier = userIdentifier.replaceAll(hashIdentifier, "");
			}
			
			return hashIdentifier.concat(userIdentifier.trim());
		}
		
		return userIdentifier.trim();
	}
}
