package com.rollingstone.exceptions;

import java.util.Date;

public class RestAPIExceptionInfo {

	private Date timestamp;

	private final String message;
	private final String details;
	
	public RestAPIExceptionInfo() {
		message= null;
		details=null;
	}
	
	public RestAPIExceptionInfo(String message, String details) {
		this.message = message;
		this.details = details;
	}

	
	public RestAPIExceptionInfo(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public Date getTimestamp() {
		return timestamp;
	}
	
}
