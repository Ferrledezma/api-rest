package com.example.springboot.social_network.entities.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.springboot.social_network.constant.ConstantColumnName;
import com.example.springboot.social_network.entities.implement.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
		value = {"creationDate", "updateDate"},
		allowGetters = true
		)
@MappedSuperclass
@NoArgsConstructor
@Getter
public abstract class AuditPostModel extends GeneralEntityModel {
	
	public AuditPostModel(UserEntity user) {
		this.user = user;
	}

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion", nullable = false, updatable = false)
	private Date creationDate;
	
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_actualizacion", nullable = false, updatable = true)
	private Date updateDate;
	
	@ManyToOne(optional = false)
	@JsonManagedReference
	@JoinColumn(
			name = ConstantColumnName.USER_COLUMN_NAME,
			referencedColumnName = ConstantColumnName.ID_COLUMN_NAME,
			nullable = false,
			updatable = false
			)
	private UserEntity user;
	
}













