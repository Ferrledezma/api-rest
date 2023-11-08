package com.example.demo.practice2.request.container_request_id;

import com.example.demo.practice2.constant.ConstantTableName;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Positive;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ContainerPublicationId extends ContainerUserId {
	/*Properties*/
	@JsonProperty(value = ConstantTableName.PUBLICATION_COLUMN_ID)
	@Positive
	protected Long publicationId;

	/*Constructs*/
	public ContainerPublicationId(Long userId) {
		this.userId = userId;
	}
	public ContainerPublicationId(Long userId, Long mainPublicationId) {
		super(mainPublicationId);
		this.userId = userId;
	}

	/*Methods*/
	public Long getUserId() {
		return userId;
	}
}
