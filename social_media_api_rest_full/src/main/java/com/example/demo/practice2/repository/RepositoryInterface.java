package com.example.demo.practice2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.practice2.entities.EntityModel;

public interface RepositoryInterface<Entity extends EntityModel> extends JpaRepository<Entity, Long> {

}
