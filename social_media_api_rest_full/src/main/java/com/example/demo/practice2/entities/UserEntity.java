package com.example.demo.practice2.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.demo.practice2.constant.ConstantTableName;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = ConstantTableName.USER_TABLE)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = {"userIdentifier"})
@Getter
public class UserEntity extends EntityModel {
	/*Properties*/
	@Column(name = "identificador_usuario", nullable = false, unique = true, updatable = false)
	private String userIdentifier;
	
	@Column(name = "nombre_usuario", length = 25, nullable = false)
	@Setter
	private String userName;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonBackReference
	private List<PublicationEntity> publications = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonBackReference
	private List<CommentEntity> comments = new ArrayList<>();
	
	@ManyToMany
	@JsonBackReference
	@JoinTable(
			name = ConstantTableName.USER_RELATION_TABLE,
			joinColumns = @JoinColumn(
					name = ConstantTableName.USER_COLUMN_ID,
					referencedColumnName = ConstantTableName.ID_NAME,
					nullable = false),
			inverseJoinColumns = @JoinColumn(
					name = ConstantTableName.FRIEND_USER_ID_COLUMN,
					referencedColumnName = ConstantTableName.ID_NAME,
					nullable = false)
			)
	private Set<UserEntity> friendUsers = new HashSet<>();

	/*Constructs*/
	private UserEntity(String userIdentifier, String userName) {
		this.userIdentifier = userIdentifier;
		this.userName = userName;
	}

	/*Methods*/
	public static Builder builder() {
		return new Builder();
	}

	/*Singleton patron*/
	public static class Builder {
		/*Properties*/
		private String userIdentifier;
		private String userName;
	
		/*Methods*/
		public Builder userIdentifier(String userIdentifier) {
			this.userIdentifier = userIdentifier;
			return this;
		}
		public Builder userName(String userName) {
			this.userName = userName;
			return this;
		}
		public UserEntity build() {
			return new UserEntity(userIdentifier, userName);
		}
	}
}






















