package com.example.springboot.social_network.entities.implement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.springboot.social_network.constant.ConstantColumnName;
import com.example.springboot.social_network.constant.ConstantTableName;
import com.example.springboot.social_network.entities.model.GeneralEntityModel;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = ConstantTableName.USER_TABLE_NAME)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false, of = "identifier")
@Getter
public class UserEntity extends GeneralEntityModel {
	@Column(name = "identificador", length = 45, nullable = false, unique = true)
	@Setter
	private String identifier;
	
	@Column(name = "apellido", length = 20, nullable = false)
	@Setter
	private String surName;
	
	@Column(name = "nombre", length = 15, nullable = false)
	@Setter
	private String forName;
	
	@Column(name = "sexo", nullable = false)
	@Setter
	private Character sex;
	
	@Column(name = "fecha_nacimiento", nullable = false, updatable = false)
	@Setter
	private LocalDate birthDate;
	
	@ManyToMany
	@JsonBackReference
	@JoinTable(
			name = ConstantTableName.USER_FRIENDS_TABLE_NAME,
			joinColumns = @JoinColumn(
					name = ConstantColumnName.USER_COLUMN_NAME,
					referencedColumnName = ConstantColumnName.ID_COLUMN_NAME,
					nullable = false
					),
			inverseJoinColumns = @JoinColumn(
					name = ConstantColumnName.USER_COLUMN_NAME + "_2",
					referencedColumnName = ConstantColumnName.ID_COLUMN_NAME,
					nullable = false
					)
			)
	private Set<UserEntity> friends = new HashSet<>();
	
	@OneToMany(
			mappedBy = "user",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	@JsonBackReference
	private List<PublicationEntity> publications = new ArrayList<>();
	
	@OneToMany(
			mappedBy = "user",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	@JsonBackReference
	private List<CommentEntity> comments = new ArrayList<>();

	private UserEntity(String identifier, String surName, String forName, Character sex, LocalDate birthDate) {
		this.identifier = identifier;
		this.surName = surName;
		this.forName = forName;
		this.sex = sex;
		this.birthDate = birthDate;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String identifier;
		private String surName;
		private String forName;
		private Character sex;
		private LocalDate birthDate;
	
		public Builder identifier(String identifier) {
			this.identifier = identifier;
			return this;
		}
		public Builder surName(String surName) {
			this.surName = surName;
			return this;
		}
		public Builder forName(String forName) {
			this.forName = forName;
			return this;
		}
		public Builder sex(Character sex) {
			this.sex = sex;
			return this;
		}
		public Builder birthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}
		
		public UserEntity build() {
			return new UserEntity(identifier, surName, forName, sex, birthDate);
		}
	}
}





















