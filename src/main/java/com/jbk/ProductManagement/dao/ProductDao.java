package com.jbk.ProductManagement.dao;

import java.util.List;

import com.jbk.ProductManagement.entity.Product;

public interface ProductDao {

	public Boolean saveProduct(Product product);

	public Product getProductByProductId(int productId);

	public List<Product> getAllProduct();

	public Boolean deleteProductByProductId(int productId);

	public Boolean updateProduct(Product product);
}
