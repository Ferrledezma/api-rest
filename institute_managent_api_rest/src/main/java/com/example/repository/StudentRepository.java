package com.example.repository;

import org.springframework.stereotype.Repository;

import com.example.entities.StudentEntity;


@Repository
public interface StudentRepository extends RepositoryInterface<StudentEntity> {

}
