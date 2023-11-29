package com.example.demo.social_network.exception.controller;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.social_network.exception.personalizate_exception.NoRelationException;
import com.example.demo.social_network.exception.personalizate_exception.ResourceNotFoundException;
import com.example.demo.social_network.request.response_body.ErrorResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class HandlerExceptionController {
	
	@ExceptionHandler({ConstraintViolationException.class, ResourceNotFoundException.class, NoRelationException.class})
	public ResponseEntity<ErrorResponseBody> handleException(RuntimeException e, HttpServletRequest request){
		HttpStatus status = generateStatusCode(e);
		ErrorResponseBody body = buildBodyResponse(request);
		
		body.setStatus(status);
		body.setMessage(e.getMessage());
		
		return ResponseEntity.status(status).body(body);
	}
	
	private ErrorResponseBody buildBodyResponse(HttpServletRequest request) {
		ErrorResponseBody body = new ErrorResponseBody();
		
		body.setInstant(Instant.now());
		body.setPath(request.getRequestURI());
		
		return body;
	}
	
	private HttpStatus generateStatusCode(RuntimeException e) {
		return (e instanceof ConstraintViolationException) ? HttpStatus.UNPROCESSABLE_ENTITY
				: (e instanceof ResourceNotFoundException) ? HttpStatus.NOT_FOUND
				: (e instanceof NoRelationException) ? HttpStatus.BAD_REQUEST
				: HttpStatus.INTERNAL_SERVER_ERROR;
	}
}
