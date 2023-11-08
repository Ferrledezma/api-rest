package com.example.demo.practice1.entities;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.practice1.constant.ConstantTableName;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = ConstantTableName.PUBLICATION_TABLE)
@NoArgsConstructor
@Getter
@Setter
public class PublicationEntity extends EntityModel {
	/*Properties*/
	@Column(name = "titulo", length = 60, unique = true, nullable = false)
	private String title;
	
	@Column(name = "descripcion", length = 130, nullable = false)
	private String description;
	
	@Column(name = "contenido", nullable = false)
	@Lob
	private String content;
	
	@OneToMany(mappedBy = "publication", cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JsonIgnore
	private List<CommentEntity> comments = new ArrayList<>();

	/*Constructs*/
	public PublicationEntity(String title, String description, String content) {
		this.title = title;
		this.description = description;
		this.content = content;
	}

	/*Methods*/
	public static Builder builder() {
		return new Builder();
	}

	/*Builder patron*/
	public static class Builder {
		/*Properties*/
		private String title;
		private String description;
		private String content;
	
		/*Methods*/
		public Builder title(String title) {
			this.title = title;
			return this;
		}
		public Builder description(String description) {
			this.description = description;
			return this;
		}
		public Builder content(String content) {
			this.content = content;
			return this;
		}
		public PublicationEntity build() {
			return new PublicationEntity(title, description, content);
		}
	}
}













