package com.example.demo.social_network.request.response_service;

import org.springframework.stereotype.Service;

import com.example.demo.social_network.dto.user.UserDTOGet;
import com.example.demo.social_network.dto.user.UserDTOPost;
import com.example.demo.social_network.dto.user.UserDTOUpdate;
import com.example.demo.social_network.entities.UserEntity;
import com.example.demo.social_network.request.container_request_id.ContainerUserId;

@Service
public class UserResponseService extends ResponseServiceModel<UserEntity, UserDTOPost, UserDTOGet, UserDTOUpdate, ContainerUserId>{

}
