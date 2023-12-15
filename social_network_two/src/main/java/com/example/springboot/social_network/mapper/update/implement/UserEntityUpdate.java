package com.example.springboot.social_network.mapper.update.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springboot.social_network.constant.ConstantErrorMessage;
import com.example.springboot.social_network.dto.implement.user.UserDTOUpdate;
import com.example.springboot.social_network.entities.implement.UserEntity;
import com.example.springboot.social_network.entities.model.GeneralEntityModel;
import com.example.springboot.social_network.exception.NotValidException;
import com.example.springboot.social_network.exception.ResourceNotFoundException;
import com.example.springboot.social_network.mapper.update.model.EntityUpdateInterface;
import com.example.springboot.social_network.repository.implement.CommentRepository;
import com.example.springboot.social_network.repository.implement.PublicationRepository;
import com.example.springboot.social_network.repository.implement.UserRepository;
import com.example.springboot.social_network.repository.model.RepositoryInterface;

@Component
public class UserEntityUpdate implements EntityUpdateInterface<UserEntity, UserDTOUpdate> {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PublicationRepository publicationRepository;
	@Autowired
	private CommentRepository commentRepository;
	
	private UserEntity user;
	private UserDTOUpdate userDTOUpdate;

	@Override
	public void accept(UserEntity user, UserDTOUpdate userDTOUpdate) throws ResourceNotFoundException{
		this.user = user;
		this.userDTOUpdate = userDTOUpdate;
		updateUserData();
		userRelations();
	}

	private void updateUserData() {
		String modifyIdentifier = user.getIdentifier();
		
		if(userDTOUpdate.getSurName() != null && !userDTOUpdate.getSurName().isBlank()) {
			modifyIdentifier = modifyIdentifier.replace(user.getSurName(), userDTOUpdate.getSurName());
			user.setSurName(userDTOUpdate.getSurName());
		}
		if(userDTOUpdate.getForName() != null && !userDTOUpdate.getForName().isBlank()) {
			modifyIdentifier = modifyIdentifier.replace(user.getForName(), userDTOUpdate.getForName());
			user.setForName(userDTOUpdate.getForName());
		}
		if(userDTOUpdate.getSex() != null) {
			if(userDTOUpdate.getSex().equals('m') || userDTOUpdate.getSex().equals('w')) {
				modifyIdentifier = modifyIdentifier.replace(
						"." + user.getSex() + ".",
						"." + userDTOUpdate.getSex() + ".");
				
				user.setSex(userDTOUpdate.getSex());
			} else {
				throw new NotValidException(String.format(ConstantErrorMessage.NOT_VALID_DATA_MESSAGE, userDTOUpdate.getSex(), "sex"));
			}
		}
		
		if(userDTOUpdate.getSurName() != null || userDTOUpdate.getForName() != null || userDTOUpdate.getSex() != null) {
			user.setIdentifier(modifyIdentifier);
		}
	}
	
	private void userRelations() throws ResourceNotFoundException {
		if(userDTOUpdate.getIdFriendsAdd() != null && !userDTOUpdate.getIdFriendsAdd().isEmpty()) {
			getList(userRepository, userDTOUpdate.getIdFriendsAdd())
			.forEach(friend -> {
				friend.getFriends().add(user);
				user.getFriends().add(friend);
			});
		}
		
		if(userDTOUpdate.getIdFriendsDelete() != null && !userDTOUpdate.getIdFriendsDelete().isEmpty()) {
			getList(userRepository, userDTOUpdate.getIdFriendsDelete())
			.forEach(friend -> {
				friend.getFriends().remove(user);
				user.getFriends().remove(friend);
			});
		}
		
		if(userDTOUpdate.getIdPublicationsDelete() != null && !userDTOUpdate.getIdPublicationsDelete().isEmpty()) {
			user.getPublications().removeAll(getList(publicationRepository, userDTOUpdate.getIdPublicationsDelete()));
		}
		
		if(userDTOUpdate.getIdCommentsDelete() != null && !userDTOUpdate.getIdCommentsDelete().isEmpty()) {
			user.getComments().removeAll(getList(commentRepository, userDTOUpdate.getIdCommentsDelete()));
		}
	}
	
	private <Entity extends GeneralEntityModel, Repository extends RepositoryInterface<Entity>>
	List<Entity> getList(Repository repository, List<Long> list)
	throws ResourceNotFoundException {
		List<Entity> resourceList = new ArrayList<>();
		
		for(Long id : list) {
			resourceList.add(
					repository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException(String.format(ConstantErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, id)))
					);
		}
		
		return resourceList;
	}
}
















