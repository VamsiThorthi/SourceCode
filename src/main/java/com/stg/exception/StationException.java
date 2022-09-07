package com.stg.exception;

public class StationException extends RuntimeException{
	private String errorMessage;

	public StationException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	@Override
	public String getMessage() {
		return this.errorMessage;
	}
	
	
}
