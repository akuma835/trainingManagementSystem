package com.cg.exception;

public class DatabaseWriteException extends Exception {

	public DatabaseWriteException(String errorMessage) {
		
		super("Some error Occured while saving to database");
	}

}
