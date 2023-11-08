package com.example.demo.practice1.entities;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "updateDate"}, allowGetters = true)
@NoArgsConstructor
@Getter
public abstract class EntityModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fecha_creacion", updatable = false, nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	@CreatedDate
	private Date creationDate;
	
	@Column(name = "fecha_actualizacion")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updateDate;
}
