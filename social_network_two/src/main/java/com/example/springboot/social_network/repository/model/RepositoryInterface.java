package com.example.springboot.social_network.repository.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.social_network.entities.model.GeneralEntityModel;

public interface RepositoryInterface<T extends GeneralEntityModel> extends JpaRepository<T, Long> {

}
