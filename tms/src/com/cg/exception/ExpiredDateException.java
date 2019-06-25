package com.cg.exception;

public class ExpiredDateException extends Exception {
	String errorMessage;

	public ExpiredDateException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	

}
