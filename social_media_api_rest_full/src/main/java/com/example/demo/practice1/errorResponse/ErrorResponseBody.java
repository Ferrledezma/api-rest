package com.example.demo.practice1.errorResponse;

import java.time.Instant;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ErrorResponseBody {
	private HttpStatus status;
	private String path;
	private String message;
	private Instant instant;
}
