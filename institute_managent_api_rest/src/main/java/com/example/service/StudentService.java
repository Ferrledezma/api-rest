package com.example.service;

import org.springframework.stereotype.Service;

import com.example.dto.estudiantes.StudentDTOGet;
import com.example.dto.estudiantes.StudentDTOPost;
import com.example.dto.estudiantes.StudentDTOUpdate;
import com.example.entities.StudentEntity;


@Service
public class StudentService extends AbstractServiceModel<StudentEntity, StudentDTOPost, StudentDTOGet, StudentDTOUpdate> {

}
