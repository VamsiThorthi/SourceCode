package com.auto.financeapi.entity;

public class ResponseSuccess {

	private String successMessage;

	public ResponseSuccess() {
		super();
	}

	public ResponseSuccess(String successMessage) {
		super();
		this.successMessage = successMessage;
	}

	public ResponseSuccess(String successMessage, String requestedURI) {
		super();
		this.successMessage = successMessage;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

}
