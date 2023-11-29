package com.example.demo.social_network.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.social_network.dto.user.UserDTOGet;
import com.example.demo.social_network.dto.user.UserDTOPost;
import com.example.demo.social_network.dto.user.UserDTOUpdate;
import com.example.demo.social_network.entities.UserEntity;
import com.example.demo.social_network.exception.personalizate_exception.ResourceNotFoundException;
import com.example.demo.social_network.repository.TablesManagent;
import com.example.demo.social_network.request.container_request_id.ContainerUserId;

@Service
public class UserService extends ServiceModel<UserEntity, UserDTOPost, UserDTOGet, UserDTOUpdate, ContainerUserId> {
	@Autowired
	private TablesManagent intermediaryTableManagent;

	@Override
	public void deleteResource(ContainerUserId containerId) throws ResourceNotFoundException {
		intermediaryTableManagent.deleteIntermediaryRecordById(containerId.getEntityOperateId());
		super.deleteResource(containerId);
	}
}















