package com.example.demo.practice2.entities;

import com.example.demo.practice2.constant.ConstantTableName;

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
