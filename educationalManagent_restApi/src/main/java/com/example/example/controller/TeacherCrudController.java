package com.example.practica4.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practica4.dto.profesor.TeacherDTOGet;
import com.example.practica4.dto.profesor.TeacherDTOPost;
import com.example.practica4.dto.profesor.TeacherDTOUpdate;
import com.example.practica4.entities.TeacherEntity;

@RestController
@RequestMapping("/api/profesor")
public class TeacherCrudController extends CrudModelController<TeacherEntity, TeacherDTOPost, TeacherDTOGet, TeacherDTOUpdate> {

}
