package com.example.demo.practice2.request.response_service;

import org.springframework.stereotype.Service;

import com.example.demo.practice2.dto.comment.CommentDTOGet;
import com.example.demo.practice2.dto.comment.CommentDTOPost;
import com.example.demo.practice2.dto.comment.CommentDTOUpdate;
import com.example.demo.practice2.entities.CommentEntity;
import com.example.demo.practice2.request.container_request_id.ContainerCommentId;

@Service
public class CommentResponseService extends ResponseServiceModel<CommentEntity, CommentDTOPost, CommentDTOGet, CommentDTOUpdate, ContainerCommentId> {

}
