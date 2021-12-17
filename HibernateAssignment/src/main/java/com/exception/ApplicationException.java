package com.exception;

public class ApplicationException extends Exception{
	
	private String errorMessage;

	public ApplicationException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	@Override
	public String getMessage() {
		return this.errorMessage;
	}
}
