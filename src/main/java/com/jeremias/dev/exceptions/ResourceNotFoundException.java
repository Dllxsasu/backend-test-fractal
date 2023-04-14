package com.jeremias.dev.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String msg) {
		super(msg);
	}

	public ResourceNotFoundException(String exMessage, Exception exception) {
		super(exMessage, exception);
	}
}
