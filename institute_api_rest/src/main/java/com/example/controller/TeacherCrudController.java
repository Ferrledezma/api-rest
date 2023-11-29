package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.profesor.TeacherDTOGet;
import com.example.dto.profesor.TeacherDTOPost;
import com.example.dto.profesor.TeacherDTOUpdate;
import com.example.entities.TeacherEntity;

@RestController
@RequestMapping("/api/profesor")
public class TeacherCrudController extends CrudModelController<TeacherEntity, TeacherDTOPost, TeacherDTOGet, TeacherDTOUpdate> {

}
