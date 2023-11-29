package com.example.demo.social_network.request.response_service;

import org.springframework.stereotype.Service;

import com.example.demo.social_network.dto.publication.PublicationDTOGet;
import com.example.demo.social_network.dto.publication.PublicationDTOPost;
import com.example.demo.social_network.dto.publication.PublicationDTOUpdate;
import com.example.demo.social_network.entities.PublicationEntity;
import com.example.demo.social_network.request.container_request_id.ContainerPublicationId;

@Service
public class PublicationResponseService extends ResponseServiceModel<PublicationEntity, PublicationDTOPost, PublicationDTOGet, PublicationDTOUpdate, ContainerPublicationId> {

}
