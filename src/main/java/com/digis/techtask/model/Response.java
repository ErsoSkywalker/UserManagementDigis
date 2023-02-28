package com.digis.techtask.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {

	public static ResponseEntity<Object> forSuccess(Object obj){
		return new ResponseEntity<Object>(obj, HttpStatus.OK);
	}
	
}
