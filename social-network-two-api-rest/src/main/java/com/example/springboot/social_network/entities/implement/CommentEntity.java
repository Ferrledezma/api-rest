package com.example.springboot.social_network.entities.implement;

import com.example.springboot.social_network.constant.ConstantColumnName;
import com.example.springboot.social_network.constant.ConstantTableName;
import com.example.springboot.social_network.entities.model.AuditPostModel;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = ConstantTableName.COMMENT_TABLE_NAME)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CommentEntity extends AuditPostModel {
	@ManyToOne(optional = false)
	@JsonBackReference
	@JoinColumn(
			name = ConstantColumnName.PUBLICATION_COLUMN_NAME,
			referencedColumnName = ConstantColumnName.ID_COLUMN_NAME,
			nullable = false,
			updatable = false
			)
	private PublicationEntity publication;
	
	@Column(name = "contenido", nullable = false)
	@Setter
	private String content;
	
	private CommentEntity(UserEntity user, PublicationEntity publication, String content) {
		super(user);
		this.publication = publication;
		this.content = content;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder {
		private UserEntity user;
		private PublicationEntity publication;
		private String content;
	
		public Builder user(UserEntity user) {
			this.user = user;
			return this;
		}
		public Builder publication(PublicationEntity title) {
			this.publication = title;
			return this;
		}
		public Builder content(String content) {
			this.content = content;
			return this;
		}
		
		public CommentEntity build() {
			return new CommentEntity(user, publication, content);
		}
	}
}



















