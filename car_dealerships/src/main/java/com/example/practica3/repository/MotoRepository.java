package com.example.practica3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practica3.entities.Moto;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {

}
