package com.flair.world.exception;

public class ErrorResponse {
	
	private String message;
	
	public ErrorResponse(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setCountryCode(String message) {
		this.message = message;
	}
}
