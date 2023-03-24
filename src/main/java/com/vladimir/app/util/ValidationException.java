package com.vladimir.app.util;

import org.springframework.http.HttpStatus;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = -7388451699730601469L;
	private final HttpStatus status;

	public ValidationException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
