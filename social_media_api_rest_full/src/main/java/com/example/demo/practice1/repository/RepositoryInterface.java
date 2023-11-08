package com.example.demo.practice1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.practice1.entities.EntityModel;

public interface RepositoryInterface<Entity extends EntityModel> extends JpaRepository<Entity, Long> {

}
