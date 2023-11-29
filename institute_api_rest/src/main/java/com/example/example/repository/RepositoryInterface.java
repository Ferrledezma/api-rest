package com.example.practica4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practica4.entities.AbstractGeneralEntityModel;

public interface RepositoryInterface<Entity extends AbstractGeneralEntityModel> extends JpaRepository<Entity, Long> {

}
