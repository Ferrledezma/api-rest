package com.example.demo.social_network.request.response_service;

import org.springframework.stereotype.Service;

import com.example.demo.social_network.dto.comment.CommentDTOGet;
import com.example.demo.social_network.dto.comment.CommentDTOPost;
import com.example.demo.social_network.dto.comment.CommentDTOUpdate;
import com.example.demo.social_network.entities.CommentEntity;
import com.example.demo.social_network.request.container_request_id.ContainerCommentId;

@Service
public class CommentResponseService extends ResponseServiceModel<CommentEntity, CommentDTOPost, CommentDTOGet, CommentDTOUpdate, ContainerCommentId> {

}
