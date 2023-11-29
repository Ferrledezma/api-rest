package com.example.demo.social_network.entities;

import com.example.demo.social_network.constant.ConstantTableName;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@Getter
public abstract class EntityModel {
	@Column(name = ConstantTableName.ID_NAME)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
