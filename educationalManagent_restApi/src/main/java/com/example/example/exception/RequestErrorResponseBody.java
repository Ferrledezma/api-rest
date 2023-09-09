package com.example.practica4.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestErrorResponseBody {
	private HttpStatus status;
	private String path;
	private String message;
	private Instant instant;
}
