package com.stg.exception;

public class SignUpException extends RuntimeException{
	private String errorMessage;

	public SignUpException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.errorMessage;
	}
	
	
	
}
