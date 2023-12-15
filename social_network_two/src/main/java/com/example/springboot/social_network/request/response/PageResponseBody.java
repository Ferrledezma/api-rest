package com.example.springboot.social_network.request.response;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class PageResponseBody<DTOGet> {
	private Integer pageNumber;
	private Integer pageSize;
	private String columnSort;
	private List<DTOGet> listResult;
}
