package com.jbk.ProductManagement.service;

import java.util.List;

import com.jbk.ProductManagement.entity.Product;

public interface ProductService {
	
	public Boolean saveProduct(Product product);

	public Product getProductByProductId(int productId);

	public List<Product> getAllProduct();

	public Boolean deleteProductByProductId(int productId);

	public Boolean updateProduct(Product product);
	
	public String generateReport(String format);
	
	

}
