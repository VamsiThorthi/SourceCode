package com.stg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(value = { BusException.class })
	public ResponseEntity<String> myFunction(BusException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = { StationException.class })
	public ResponseEntity<String> myFunction(StationException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = { SignUpException.class })
	public ResponseEntity<String> myFunction(SignUpException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
