package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.estudiantes.StudentDTOGet;
import com.example.dto.estudiantes.StudentDTOPost;
import com.example.dto.estudiantes.StudentDTOUpdate;
import com.example.entities.StudentEntity;


@RestController
@RequestMapping("/api/estudiante")
public class StudentCrudController extends CrudModelController<StudentEntity, StudentDTOPost, StudentDTOGet, StudentDTOUpdate> {

}
