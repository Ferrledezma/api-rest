package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.AbstractGeneralEntityModel;

public interface RepositoryInterface<Entity extends AbstractGeneralEntityModel> extends JpaRepository<Entity, Long> {

}
