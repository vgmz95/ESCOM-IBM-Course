package com.microservice.training.countriesdemo.errorhandling;


public class InvalidCountryException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4957281189808005732L;
	
	public InvalidCountryException() {
		super();		
	}
	public InvalidCountryException(String message) {
		super(message);		
	}

}
