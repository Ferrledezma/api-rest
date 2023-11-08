package com.example.demo.practice2.request.container_request_id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class ContainerIdModel {
	@JsonIgnore
	@Positive
	protected Long entityOperateId;
}
