package com.example.springboot.social_network.service.type.response.implement;

import org.springframework.stereotype.Service;

import com.example.springboot.social_network.dto.implement.user.UserDTOGet;
import com.example.springboot.social_network.dto.implement.user.UserDTOPost;
import com.example.springboot.social_network.dto.implement.user.UserDTOUpdate;
import com.example.springboot.social_network.entities.implement.UserEntity;
import com.example.springboot.social_network.service.type.response.model.ResponseServiceModel;

@Service
public class UserResponseService extends ResponseServiceModel<UserEntity, UserDTOPost, UserDTOGet, UserDTOUpdate> {

}
