package com.vladimir.app.util;

import org.springframework.http.HttpStatus;

public class ValidationUtils {

	public static void notEmpty(String parameterEvaluar, String mensaje) {
		if (parameterEvaluar.isBlank()) {
			throw new ValidationException(mensaje, HttpStatus.BAD_REQUEST);
		}
	}

	public static void notNull(String parameterEvaluar, String mensaje) {
		if (parameterEvaluar == null) {
			throw new ValidationException(mensaje, HttpStatus.BAD_REQUEST);
		}
	}

}