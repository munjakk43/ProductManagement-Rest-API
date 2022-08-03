package com.jbk.ProductManagement.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ProductNotFoundException.class )
	public ResponseEntity<ErrorDetails> ProductNotFoundException(ProductNotFoundException productNotFoundException)
	{
		ErrorDetails errorDetails=new ErrorDetails(productNotFoundException.getMessage(), 
									"Product Not found for this !!", new Date());
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductAlreadyExistsException.class)
	public ResponseEntity<ErrorDetails> ProductAlreadyExistsException(ProductAlreadyExistsException productAlreadyExistsException)
	{
		ErrorDetails errorDetails=new ErrorDetails(productAlreadyExistsException.getMessage(),"Product Already Exists !!",new Date());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(NoProductFoundException.class)
	public ResponseEntity<ErrorDetails> NoNoProductFoundException(NoProductFoundException noProductFoundException)
	{
		ErrorDetails errorDetails=new ErrorDetails(noProductFoundException.getMessage(), "No Products found !!", new Date());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
}
