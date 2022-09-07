package com.stg.exception;


public class BusException extends RuntimeException {
	private String errorMessage;

	public BusException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	@Override
	public String getMessage() {
		return this.errorMessage;
	}
	
}
