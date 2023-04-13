package com.tyss.warehouse.boot.warehouse.exception;

public class UserCredentialsInvalid extends RuntimeException{
	
	private String message;

	public String getMessage() {
		return message;
	}

	public UserCredentialsInvalid(String message) {
		this.message = message;
	}

	
}
