package com.example.springboot.social_network.mapper.entities.implement;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springboot.social_network.constant.ConstantErrorMessage;
import com.example.springboot.social_network.constant.ConstantTableName;
import com.example.springboot.social_network.dto.implement.user.UserDTOPost;
import com.example.springboot.social_network.entities.implement.UserEntity;
import com.example.springboot.social_network.exception.ResourceNotFoundException;
import com.example.springboot.social_network.mapper.entities.model.EntityMapperInterface;
import com.example.springboot.social_network.repository.implement.UserRepository;

@Component
public class UserMapper implements EntityMapperInterface<UserDTOPost, UserEntity> {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserEntity apply(UserDTOPost userDTO) throws ResourceNotFoundException {
		String userIdentifier = generateIdentifier(userDTO.getSurName(), userDTO.getForName(), userDTO.getSex());
		
		UserEntity user = UserEntity.builder()
				.identifier(userIdentifier)
				.surName(userDTO.getSurName())
				.forName(userDTO.getForName())
				.sex(userDTO.getSex())
				.birthDate(userDTO.getBirthDate())
				.build();
		
		if(userDTO.getIdFriendsAdd() != null && !userDTO.getIdFriendsAdd().isEmpty()) {
			for(Long userId : userDTO.getIdFriendsAdd()) {
				userRepository.findById(userId)
				.map(userFriend -> {
					user.getFriends().add(userFriend);
					return userFriend.getFriends().add(user);
				})
				.orElseThrow(() -> new ResourceNotFoundException(
						String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, ConstantTableName.USER_TABLE_NAME + " " + userId)
						));
			}
		}
		
		return user;
	}

	private String generateIdentifier(String surName, String forName, Character sex) {
		Random random = new Random();
		String point = ".";
		int userNumber = random.nextInt(999);
		
		return "@".concat(surName)
				.concat(point)
				.concat(forName)
				.concat(point)
				.concat(sex.toString())
				.concat(point)
				.concat(Integer.toString(userNumber))
				.trim()
				.replaceAll(" ", "")
				.toLowerCase();
	}
}















