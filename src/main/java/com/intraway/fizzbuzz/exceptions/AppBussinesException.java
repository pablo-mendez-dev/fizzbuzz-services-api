package com.intraway.fizzbuzz.exceptions;

public class AppBussinesException extends RuntimeException {


	private static final long serialVersionUID = 1L;
	protected String id = null;
	protected String message = null;
	
	public AppBussinesException(String id,String aMessage) {
		this.id =id;
		this.message = aMessage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String aMessage) {
		this.message = aMessage;
	}
	

}
