package com.jbk.ProductManagement.exception;

import com.jbk.ProductManagement.entity.Product;

public class ProductAlreadyExistsException extends RuntimeException {
	
	public ProductAlreadyExistsException(Product product) {
		super(product.getProduct_name());
	}

}
