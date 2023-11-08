package com.example.demo.practice2.request.container_request_id;

import com.example.demo.practice2.constant.ConstantTableName;
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
