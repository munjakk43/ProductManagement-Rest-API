package com.jbk.ProductManagement.exception;

import java.util.Date;

public class ErrorDetails {

	private String errorMessage;
	private String errorDetails;
	private Date timestamp;
	
	public ErrorDetails() {
		super();
	}

	public ErrorDetails(String errorMessage, String errorDetails, Date timestamp) {
		super();
		this.errorMessage = errorMessage;
		this.errorDetails = errorDetails;
		this.timestamp = timestamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ErrorDetails [errorMessage=" + errorMessage + ", errorDetails=" + errorDetails + ", timestamp="
				+ timestamp + "]";
	}
	
	
	
	
}
