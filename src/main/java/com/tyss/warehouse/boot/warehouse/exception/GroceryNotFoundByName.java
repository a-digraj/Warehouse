package com.tyss.warehouse.boot.warehouse.exception;

public class GroceryNotFoundByName extends RuntimeException {
	
	private String message;

	public GroceryNotFoundByName(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	
}
