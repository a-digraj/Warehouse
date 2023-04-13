package com.tyss.warehouse.boot.warehouse.exception;

public class GroceryAlreadyPresent extends RuntimeException{
	private String message;

	public GroceryAlreadyPresent(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	
}
