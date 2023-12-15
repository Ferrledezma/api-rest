package com.example.springboot.social_network.repository.implement;

import org.springframework.stereotype.Repository;

import com.example.springboot.social_network.entities.implement.UserEntity;
import com.example.springboot.social_network.repository.model.RepositoryInterface;

@Repository
public interface UserRepository extends RepositoryInterface<UserEntity> {

}
