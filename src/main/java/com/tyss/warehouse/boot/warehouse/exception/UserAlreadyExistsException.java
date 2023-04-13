package com.tyss.warehouse.boot.warehouse.exception;

public class UserAlreadyExistsException extends RuntimeException {
	private String message;

	public String getMessage() {
		return message;
	}


	public UserAlreadyExistsException(String message) {
		this.message = message;
	}
	
}
