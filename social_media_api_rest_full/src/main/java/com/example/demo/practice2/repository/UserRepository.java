package com.example.demo.practice2.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.practice2.entities.UserEntity;

@Repository
public interface UserRepository extends RepositoryInterface<UserEntity> {

}
