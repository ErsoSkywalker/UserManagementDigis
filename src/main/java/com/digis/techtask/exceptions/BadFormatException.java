package com.digis.techtask.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadFormatException extends RuntimeException {

	private static final long serialVersionUID = -1716915743848577770L;

	public BadFormatException(String message) {
		super(message);
	}
}
