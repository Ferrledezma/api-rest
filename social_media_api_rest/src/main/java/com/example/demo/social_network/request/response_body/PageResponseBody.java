package com.example.demo.social_network.request.response_body;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PageResponseBody<DTOGet> {
	private Integer pageNumber;
	private Integer pageSize;
	private String sort;
	private List<DTOGet> dtoList;

}
