package com.rollingstone.exceptions;

import java.util.Date;

public class HTTP404Exception extends RuntimeException {

	private Date timestamp;
	
	public HTTP404Exception() {
		super();
	}
	
	public HTTP404Exception(String message, Date timestamp, Throwable cause) {
		super(message,cause);
		this.timestamp = timestamp;
	}
	public HTTP404Exception(String message, Throwable cause) {
		super(message,cause);
	}
	
	public HTTP404Exception(String message) {
		super(message);
	}
	
	public HTTP404Exception(Throwable cause) {
		super(cause);
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}

