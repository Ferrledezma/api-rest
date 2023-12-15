package com.example.demo.social_network.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.social_network.entities.EntityModel;

public interface RepositoryInterface<Entity extends EntityModel> extends JpaRepository<Entity, Long> {

}
