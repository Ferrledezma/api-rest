package com.example.demo.social_network.entities;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "updateDate"}, allowGetters = true)
@Getter
@Setter
public abstract class AuditingModel extends EntityModel {
	@Column(name = "fecha_creacion", updatable = false, nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	@CreatedDate
	private Date creationDate;
	
	@Column(name = "fecha_actualizacion", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updateDate;
}
