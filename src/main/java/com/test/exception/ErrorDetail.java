package com.test.exception;

import java.util.Date;

public class ErrorDetail {

	private Date timestamp;
	
	private String massage;
	
	private String details;
	
	private Boolean error=true;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	public ErrorDetail(Date timestamp, String massage, String details, Boolean error) {
		super();
		this.timestamp = timestamp;
		this.massage = massage;
		this.details = details;
		this.error = error;
	}

	public ErrorDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
