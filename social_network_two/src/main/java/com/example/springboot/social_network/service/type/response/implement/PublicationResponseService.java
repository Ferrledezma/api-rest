package com.example.springboot.social_network.service.type.response.implement;

import org.springframework.stereotype.Service;

import com.example.springboot.social_network.dto.implement.publication.PublicationDTOGet;
import com.example.springboot.social_network.dto.implement.publication.PublicationDTOPost;
import com.example.springboot.social_network.dto.implement.publication.PublicationDTOUpdate;
import com.example.springboot.social_network.entities.implement.PublicationEntity;
import com.example.springboot.social_network.service.type.response.model.ResponseServiceModel;

@Service
public class PublicationResponseService extends ResponseServiceModel<PublicationEntity, PublicationDTOPost, PublicationDTOGet, PublicationDTOUpdate> {

}
