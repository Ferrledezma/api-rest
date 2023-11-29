package com.example.service;
import org.springframework.stereotype.Service;

import com.example.dto.profesor.TeacherDTOGet;
import com.example.dto.profesor.TeacherDTOPost;
import com.example.dto.profesor.TeacherDTOUpdate;
import com.example.entities.TeacherEntity;


@Service
public class TeacherService extends AbstractServiceModel
<TeacherEntity, TeacherDTOPost, TeacherDTOGet, TeacherDTOUpdate> {

}
