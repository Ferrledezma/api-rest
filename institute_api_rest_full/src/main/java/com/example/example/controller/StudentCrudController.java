package com.example.practica4.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practica4.dto.estudiantes.StudentDTOGet;
import com.example.practica4.dto.estudiantes.StudentDTOPost;
import com.example.practica4.dto.estudiantes.StudentDTOUpdate;
import com.example.practica4.entities.StudentEntity;

@RestController
@RequestMapping("/api/estudiante")
public class StudentCrudController extends CrudModelController<StudentEntity, StudentDTOPost, StudentDTOGet, StudentDTOUpdate> {

}
