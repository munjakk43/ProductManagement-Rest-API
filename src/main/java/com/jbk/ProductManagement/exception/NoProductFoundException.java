package com.jbk.ProductManagement.exception;

public class NoProductFoundException extends RuntimeException{
	
	public NoProductFoundException() {
		super("Not found");
	}

}
