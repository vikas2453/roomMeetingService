package com.hcl.hackathon.fullstack.exceptions;

public class InvalidRoomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidRoomException(String message) {
		super(message);
	}
	
	public InvalidRoomException(String message, Throwable ex) {
		super(message, ex);
	}


}
