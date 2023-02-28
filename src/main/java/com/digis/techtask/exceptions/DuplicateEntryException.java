package com.digis.techtask.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_MODIFIED)
public class DuplicateEntryException extends RuntimeException{


	private static final long serialVersionUID = -1716915743848577770L;

	public DuplicateEntryException(String message) {
		super(message);
	}
	
}
