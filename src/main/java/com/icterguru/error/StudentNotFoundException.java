package com.icterguru.error;

public class StudentNotFoundException extends Exception{

	
	/**
	 * 
	 */
	private static final int serialVersionUID = 1;

	public StudentNotFoundException() {
		super();

	}

	public StudentNotFoundException(String message) {
		super(message);
	
	}

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}


	protected StudentNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	
	public StudentNotFoundException(Throwable cause) {
		super(cause);

	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

	
}

