package com.example.springboot.social_network.exception;

public class NotValidException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public NotValidException() {
		// TODO Auto-generated constructor stub
	}

	public NotValidException(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	public NotValidException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public NotValidException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
