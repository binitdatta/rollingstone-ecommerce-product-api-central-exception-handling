package com.rollingstone.exceptions;

import java.util.Date;

public class HTTP400Exception extends RuntimeException {

	private Date timestamp;
	
	public HTTP400Exception() {
		super();
	}
	
	public HTTP400Exception(String message, Date timestamp, Throwable cause) {
		super(message,cause);
		this.timestamp = timestamp;
	}
	
	public HTTP400Exception(String message, Throwable cause) {
		super(message,cause);
	}
	
	public HTTP400Exception(String message) {
		super(message);
	}
	
	public HTTP400Exception(Throwable cause) {
		super(cause);
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
