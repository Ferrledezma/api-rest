package com.example.demo.practice1.exceptionController;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.practice1.errorResponse.ErrorResponseBody;
import com.example.demo.practice1.exception.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionController {
	@ExceptionHandler({ConstraintViolationException.class, ResourceNotFoundException.class, RuntimeException.class})
	public ResponseEntity<ErrorResponseBody> handleException(RuntimeException e, HttpServletRequest request){
		HttpStatus status = generateStatusCode(e);
		ErrorResponseBody body = createResponseBody(request, e);
		body.setStatus(status);
		
		return ResponseEntity.status(status).body(body);
		
	}
	private ErrorResponseBody createResponseBody(HttpServletRequest request, Exception e) {
		ErrorResponseBody body = new ErrorResponseBody();
		body.setInstant(Instant.now());
		body.setPath(request.getRequestURI());
		body.setMessage(e.getMessage());
		return body;
	}
	
	private HttpStatus generateStatusCode(Exception e) {
		return (e instanceof ConstraintViolationException) ? HttpStatus.BAD_REQUEST
				: (e instanceof ResourceNotFoundException) ? HttpStatus.NOT_FOUND
				: HttpStatus.INTERNAL_SERVER_ERROR;
	}
}
