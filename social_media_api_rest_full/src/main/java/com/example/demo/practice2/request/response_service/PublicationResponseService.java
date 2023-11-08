package com.example.demo.practice2.request.response_service;

import org.springframework.stereotype.Service;

import com.example.demo.practice2.dto.publication.PublicationDTOGet;
import com.example.demo.practice2.dto.publication.PublicationDTOPost;
import com.example.demo.practice2.dto.publication.PublicationDTOUpdate;
import com.example.demo.practice2.entities.PublicationEntity;
import com.example.demo.practice2.request.container_request_id.ContainerPublicationId;

@Service
public class PublicationResponseService extends ResponseServiceModel<PublicationEntity, PublicationDTOPost, PublicationDTOGet, PublicationDTOUpdate, ContainerPublicationId> {

}
