package com.example.springboot.social_network.controller.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.springboot.social_network.exception.NotRelationException;
import com.example.springboot.social_network.exception.NotValidException;
import com.example.springboot.social_network.exception.ResourceNotFoundException;
import com.example.springboot.social_network.request.response.ErrorResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2
public class ExceptionController {
	@ExceptionHandler({ConstraintViolationException.class, ResourceNotFoundException.class, NotRelationException.class, NotValidException.class})
	public ResponseEntity<ErrorResponseBody> handleException(RuntimeException e, HttpServletRequest request){
		HttpStatus status = generateStatusCode(e);
		ErrorResponseBody body = buildResponseBody(status, request, e);
		
		log.error(e);
		
		return ResponseEntity.status(status).body(body);
	}
	
	private ErrorResponseBody buildResponseBody(HttpStatus status, HttpServletRequest request, Exception e) {
		return ErrorResponseBody.builder()
				.status(status)
				.instant(Instant.now())
				.path(request.getRequestURI())
				.message(e.getMessage())
				.build();
	}
	
	private HttpStatus generateStatusCode(Exception e) {
		return (e instanceof ConstraintViolationException || e instanceof NotValidException) ? HttpStatus.BAD_REQUEST
				: (e instanceof ResourceNotFoundException) ? HttpStatus.NOT_FOUND
				: (e instanceof NotRelationException) ? HttpStatus.CONFLICT
				: HttpStatus.INTERNAL_SERVER_ERROR;
	}
}






















