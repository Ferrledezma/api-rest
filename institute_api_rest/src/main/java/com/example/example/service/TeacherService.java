package com.example.practica4.service;
import org.springframework.stereotype.Service;

import com.example.practica4.dto.profesor.TeacherDTOGet;
import com.example.practica4.dto.profesor.TeacherDTOPost;
import com.example.practica4.dto.profesor.TeacherDTOUpdate;
import com.example.practica4.entities.TeacherEntity;

@Service
public class TeacherService extends AbstractServiceModel
<TeacherEntity, TeacherDTOPost, TeacherDTOGet, TeacherDTOUpdate> {

}
