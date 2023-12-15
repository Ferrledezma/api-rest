package com.example.springboot.social_network.service.type.response.implement;

import org.springframework.stereotype.Service;

import com.example.springboot.social_network.dto.implement.comment.CommentDTOGet;
import com.example.springboot.social_network.dto.implement.comment.CommentDTOPost;
import com.example.springboot.social_network.dto.implement.comment.CommentDTOUpdate;
import com.example.springboot.social_network.entities.implement.CommentEntity;
import com.example.springboot.social_network.service.type.response.model.ResponseServiceModel;

@Service
public class CommentResponseService extends ResponseServiceModel<CommentEntity, CommentDTOPost, CommentDTOGet, CommentDTOUpdate> {

}
