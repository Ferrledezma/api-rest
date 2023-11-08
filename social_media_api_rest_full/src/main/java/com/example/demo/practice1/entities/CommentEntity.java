package com.example.demo.practice1.entities;

import com.example.demo.practice1.constant.ConstantTableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = ConstantTableName.COMMENT_TABLE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class CommentEntity extends EntityModel {
	/*Properties*/
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = ConstantTableName.PUBLICATION_COLUMN_ID, nullable = false)
	private PublicationEntity publication;
	
	@Column(name = "nombre_usuario", length = 35, nullable = false)
	private String userName;
	
	@Column(name = "contenido", nullable = false)
	@Lob
	private String content;

	/*Construct*/
	private CommentEntity(String userName, String content) {
		this.userName = userName;
		this.content = content;
	}

	/*Method*/
	public static Builder builder() {
		return new Builder();
	}

	/*Singleton patron*/
	public static class Builder {
		/*Properties*/
		private String userName;
		private String content;
	
		/*Methdos*/
		public Builder userName(String userName) {
			this.userName = userName;
			return this;
		}
		public Builder content(String content) {
			this.content = content;
			return this;
		}
		
		public CommentEntity build() {
			return new CommentEntity(userName, content);
		}
	}
}









