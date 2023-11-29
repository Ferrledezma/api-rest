package com.example.demo.social_network.exception.personalizate_exception;

import jakarta.persistence.EntityNotFoundException;

public class ResourceNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public ResourceNotFoundException(Exception cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ResourceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ResourceNotFoundException(String message, Exception cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
