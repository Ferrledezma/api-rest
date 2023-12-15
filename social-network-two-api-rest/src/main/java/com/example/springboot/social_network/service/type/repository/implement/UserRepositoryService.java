package com.example.springboot.social_network.service.type.repository.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.social_network.dto.implement.user.UserDTOGet;
import com.example.springboot.social_network.dto.implement.user.UserDTOPost;
import com.example.springboot.social_network.dto.implement.user.UserDTOUpdate;
import com.example.springboot.social_network.entities.implement.UserEntity;
import com.example.springboot.social_network.exception.ResourceNotFoundException;
import com.example.springboot.social_network.repository.implement.IntermediaryTableRepository;
import com.example.springboot.social_network.request.id.RequestId;
import com.example.springboot.social_network.service.type.repository.model.RepositoryServiceModel;

@Service
public class UserRepositoryService extends RepositoryServiceModel<UserEntity, UserDTOPost, UserDTOGet, UserDTOUpdate> {
	@Autowired
	private IntermediaryTableRepository intermediaryTableRepository;

	@Override
	public void delete(RequestId containerId) throws ResourceNotFoundException {
		comprobate(containerId);
		
		if(intermediaryTableRepository.existsRecordInTable(containerId.getUserId())) {
			intermediaryTableRepository.deleteRecord(containerId.getUserId());
		}
		
		repository.deleteById(containerId.getUserId());
	}
}
