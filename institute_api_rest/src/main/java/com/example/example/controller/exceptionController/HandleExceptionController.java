package com.example.practica4.controller.exceptionController;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.practica4.exception.RequestErrorResponseBody;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2
public class HandleExceptionController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {ConstraintViolationException.class, EntityNotFoundException.class, RuntimeException.class})
	public ResponseEntity<RequestErrorResponseBody> handleEntityNotFoundException(Exception e, HttpServletRequest request){
		
		RequestErrorResponseBody ErrorResponseBody = createBodyResponse(request);
		HttpStatus status = generateStatusCode(e);
		ErrorResponseBody.setStatus(status);
		ErrorResponseBody.setMessage(e.getMessage());
		
		log.error(e);
		return ResponseEntity.status(status).body(ErrorResponseBody);
	}
	
	private RequestErrorResponseBody createBodyResponse(HttpServletRequest request) {
		RequestErrorResponseBody ErrorResponseBody = new RequestErrorResponseBody();
		ErrorResponseBody.setInstant(Instant.now());
		ErrorResponseBody.setPath(request.getRequestURI());
		return ErrorResponseBody;
	}
	
	private HttpStatus generateStatusCode(Exception e) {
		return (e instanceof ConstraintViolationException) ? HttpStatus.BAD_REQUEST
				: (e instanceof EntityNotFoundException) ? HttpStatus.NOT_FOUND
				: (e instanceof RuntimeException) ? HttpStatus.CONFLICT
				: HttpStatus.INTERNAL_SERVER_ERROR;
	}
}













