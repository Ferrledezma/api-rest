package com.example.springboot.social_network.request.response;

import java.time.Instant;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponseBody {
	private HttpStatus status;
	private Instant instant;
	private String path;
	private String message;
}
