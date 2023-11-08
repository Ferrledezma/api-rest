package com.example.demo.practice2.request.response_body;

import java.time.Instant;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseBody {
	private HttpStatus status;
	private String path;
	private String message;
	private Instant instant;
}
