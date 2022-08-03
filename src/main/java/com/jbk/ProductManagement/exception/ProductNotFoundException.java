package com.jbk.ProductManagement.exception;

public class ProductNotFoundException extends RuntimeException{
	
	public ProductNotFoundException(String productId)
	{
		super(productId);
		
	}

}
