package com.example.demo.exception;

public class DemoServiceException extends Exception{
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DemoServiceException(String message) {
		this.setMessage(message);
	}

}
