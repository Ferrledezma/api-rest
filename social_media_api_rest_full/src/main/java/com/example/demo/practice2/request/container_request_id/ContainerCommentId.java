package com.example.demo.practice2.request.container_request_id;

import com.example.demo.practice2.constant.ConstantParamName;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ContainerCommentId extends ContainerPublicationId {
	/*Properties*/
	@JsonProperty(value = ConstantParamName.COMMENT_JSON_PARAM_NAME)
	@NotNull
	@Positive
	private Long commentId;

	/*Constructs*/
	public ContainerCommentId(Long userId, Long publicationId) {
		this.userId = userId;
		this.publicationId = publicationId;
	}
	public ContainerCommentId(Long userId, Long publicationId, Long mainCommentId) {
		super(userId, mainCommentId);
		this.publicationId = publicationId;
	}

	/*Methods*/
	public Long getPublicationId() {
		return publicationId;
	}
}
