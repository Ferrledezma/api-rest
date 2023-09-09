package com.example.practica3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practica3.entities.Concesionaria;

@Repository
public interface ConcesionariaRepository extends JpaRepository<Concesionaria, Long> {

}
