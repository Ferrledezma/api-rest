package com.example.demo.social_network.entities;

import com.example.demo.social_network.constant.ConstantTableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = ConstantTableName.COMMENT_TABLE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@Getter
public class CommentEntity extends AuditingModel {
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(
			name = ConstantTableName.USER_COLUMN_ID,
			referencedColumnName = ConstantTableName.ID_NAME,
			updatable = false,
			nullable = false
			)
	private UserEntity user;
	
	@ManyToOne(optional = false)
	@JsonIgnore
	@JoinColumn(
			name = ConstantTableName.PUBLICATION_COLUMN_ID,
			referencedColumnName = ConstantTableName.ID_NAME,
			updatable = false,
			nullable = false
			)
	private PublicationEntity publication;
	
	@Column(name = ConstantTableName.CONTENT_COLUMN, nullable = false)
	@Lob
	@Setter
	private String content;
}















