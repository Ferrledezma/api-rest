package com.example.demo.practice2.mapper.update_entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.practice2.constant.ConstantErrorMessage;
import com.example.demo.practice2.dto.user.UserDTOUpdate;
import com.example.demo.practice2.entities.EntityModel;
import com.example.demo.practice2.entities.UserEntity;
import com.example.demo.practice2.exception.personalizate_exception.ResourceNotFoundException;
import com.example.demo.practice2.repository.PublicationRepository;
import com.example.demo.practice2.repository.RepositoryInterface;
import com.example.demo.practice2.repository.UserRepository;

@Component
public class UserUpdate implements EntityUpdateInterface<UserEntity, UserDTOUpdate> {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PublicationRepository publicationRepository;

	@Override
	public void accept(UserEntity user, UserDTOUpdate dtoUpdate) {
		if(dtoUpdate.getUserName() != null && !dtoUpdate.getUserName().isBlank()) {
			user.setUserName(dtoUpdate.getUserName());
		}
		if(dtoUpdate.getFriendUsers() != null && !dtoUpdate.getFriendUsers().isEmpty()) {
			user.getFriendUsers().addAll(
					findEntityList(userRepository, dtoUpdate.getFriendUsers())
						.stream()
						.peek(entity -> entity.getFriendUsers().add(user))
						.toList()
					);
		}
		if(dtoUpdate.getFriendUsersDelete() != null && !dtoUpdate.getFriendUsersDelete().isEmpty()) {
			user.getFriendUsers().removeAll(
					findEntityList(userRepository, dtoUpdate.getFriendUsersDelete())
						.stream()
						.peek(entity -> entity.getFriendUsers().remove(user))
						.toList()
					);
		}
		if(dtoUpdate.getPublicationDelete() != null && !dtoUpdate.getPublicationDelete().isEmpty()) {
			user.getPublications().removeAll(findEntityList(publicationRepository, dtoUpdate.getPublicationDelete()));
		}
	}
	
	private <Entity extends EntityModel, Repository extends RepositoryInterface<Entity>> List<Entity> findEntityList(Repository repository, List<Long> idList){
		List<Entity> entityList = new ArrayList<>();
		for(Long id : idList) {
			entityList.add(repository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException(String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND, id)))
			);
		}
		return entityList;
	}
}












