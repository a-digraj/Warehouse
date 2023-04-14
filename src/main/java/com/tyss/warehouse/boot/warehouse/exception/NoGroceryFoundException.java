package com.tyss.warehouse.boot.warehouse.exception;

public class NoGroceryFoundException extends RuntimeException{
	private String meesage;

	public NoGroceryFoundException(String meesage) {
		this.meesage = meesage;
	}

	public String getMeesage() {
		return meesage;
	}

}
