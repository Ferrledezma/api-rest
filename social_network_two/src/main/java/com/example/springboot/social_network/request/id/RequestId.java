package com.example.springboot.social_network.request.id;

import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class RequestId {
	@Positive
	private Long mainId;
	
	@Positive
	private Long userId;
	
	@Positive
	private Long publicationId;
	
	@Positive
	private Long commentId;

	public RequestId(Long userId) {
		this.userId = mainId = userId;
	}
	
	public RequestId(Long userId, Long publicationId) {
		this.userId = userId;
		this.publicationId = mainId = publicationId;
	}
	
	public RequestId(Long userId, Long publicationId, Long commentId) {
		this.userId = userId;
		this.publicationId = publicationId;
		this.commentId = mainId = commentId;
	}
}
