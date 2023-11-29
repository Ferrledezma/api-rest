package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public abstract class AbstractEntityModel extends AbstractGeneralEntityModel {
	@Column(name = "nombre", length = 20, nullable = false)
	private String name;
	
	public AbstractEntityModel(String name) {
		this.name = name;
	}
}
