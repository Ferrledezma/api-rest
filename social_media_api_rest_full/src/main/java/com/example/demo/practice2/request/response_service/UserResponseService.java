package com.example.demo.practice2.request.response_service;

import org.springframework.stereotype.Service;

import com.example.demo.practice2.dto.user.UserDTOGet;
import com.example.demo.practice2.dto.user.UserDTOPost;
import com.example.demo.practice2.dto.user.UserDTOUpdate;
import com.example.demo.practice2.entities.UserEntity;
import com.example.demo.practice2.request.container_request_id.ContainerUserId;

@Service
public class UserResponseService extends ResponseServiceModel<UserEntity, UserDTOPost, UserDTOGet, UserDTOUpdate, ContainerUserId>{

}
