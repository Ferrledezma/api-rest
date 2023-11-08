package com.example.demo.practice2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.practice2.dto.user.UserDTOGet;
import com.example.demo.practice2.dto.user.UserDTOPost;
import com.example.demo.practice2.dto.user.UserDTOUpdate;
import com.example.demo.practice2.entities.UserEntity;
import com.example.demo.practice2.exception.personalizate_exception.ResourceNotFoundException;
import com.example.demo.practice2.repository.TablesManagent;
import com.example.demo.practice2.request.container_request_id.ContainerUserId;

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















