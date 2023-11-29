package com.example.practica4.service;

import org.springframework.stereotype.Service;

import com.example.practica4.dto.estudiantes.StudentDTOGet;
import com.example.practica4.dto.estudiantes.StudentDTOPost;
import com.example.practica4.dto.estudiantes.StudentDTOUpdate;
import com.example.practica4.entities.StudentEntity;

@Service
public class StudentService extends AbstractServiceModel<StudentEntity, StudentDTOPost, StudentDTOGet, StudentDTOUpdate> {

}
