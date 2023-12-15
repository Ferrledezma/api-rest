package com.example.demo.social_network.request.container_request_id;

import com.example.demo.social_network.constant.ConstantTableName;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Positive;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ContainerUserId extends ContainerIdModel {
	@JsonProperty(value = ConstantTableName.USER_COLUMN_ID)
	@Positive
	protected Long userId;

	public ContainerUserId(Long mainId) {
		super(mainId);
	}
}
