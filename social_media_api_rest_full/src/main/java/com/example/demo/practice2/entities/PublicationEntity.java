package com.example.demo.practice2.entities;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.practice2.constant.ConstantTableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = ConstantTableName.PUBLICATION_TABLE)
@NoArgsConstructor
@Getter
public class PublicationEntity extends AuditingModel {
	@ManyToOne(optional = false)
	@JsonManagedReference
	@JoinColumn(
			name = ConstantTableName.USER_COLUMN_ID,
			referencedColumnName = ConstantTableName.ID_NAME,
			updatable = false,
			nullable = false
			)
	private UserEntity user;
	
	@Column(name = "titulo", length = 50, nullable = false)
	@Setter
	private String title;
	
	@Column(name = ConstantTableName.CONTENT_COLUMN, nullable = false)
	@Lob
	@Setter
	private String content;
	
	@OneToMany(mappedBy = "publication", cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JsonIgnore
	private List<CommentEntity> comments = new ArrayList<>();

	/*Constructs*/
	private PublicationEntity(UserEntity user, String title, String content) {
		this.user = user;
		this.title = title;
		this.content = content;
	}

	/*Methods*/
	public static Builder builder() {
		return new Builder();
	}

	/*SingletonPatron*/
	public static class Builder{
		/*Properties*/
		private UserEntity user;
		private String title;
		private String content;
	
		/*Methods*/
		public Builder user(UserEntity user) {
			this.user = user;
			return this;
		}
		public Builder title(String title) {
			this.title = title;
			return this;
		}
		public Builder content(String content) {
			this.content = content;
			return this;
		}
		public PublicationEntity build() {
			return new PublicationEntity(user, title, content);
		}
	}
}















