package com.game.services;

public class SpringException extends RuntimeException{
	private Throwable exception;
	private Integer statusCode;

	public SpringException(Throwable exceptionMsg, Integer statusCode) {
		this.setException(exceptionMsg);
		this.setStatusCode(statusCode);
	}

	public Throwable getException() {
		return exception;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	
}
