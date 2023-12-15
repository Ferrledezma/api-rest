package com.example.springboot.social_network.entities.implement;

import java.util.ArrayList;
import java.util.List;

import com.example.springboot.social_network.constant.ConstantTableName;
import com.example.springboot.social_network.entities.model.AuditPostModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = ConstantTableName.PUBLICATION_TABLE_NAME)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PublicationEntity extends AuditPostModel {
	@Column(name = "titulo", length = 80, nullable = false)
	@Setter
	private String title;
	
	@Column(name = "contenido", nullable = false)
	@Setter
	private String content;
	
	@OneToMany(
			mappedBy = "publication",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	@JsonIgnore
	private List<CommentEntity> comments = new ArrayList<>();

	private PublicationEntity(UserEntity user, String title, String content) {
		super(user);
		this.title = title;
		this.content = content;
	}

	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder {
		private UserEntity user;
		private String title;
		private String content;
	
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






















