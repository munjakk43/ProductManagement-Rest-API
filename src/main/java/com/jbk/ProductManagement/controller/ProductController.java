package com.jbk.ProductManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.ProductManagement.entity.Product;
import com.jbk.ProductManagement.exception.NoProductFoundException;
import com.jbk.ProductManagement.exception.ProductAlreadyExistsException;
import com.jbk.ProductManagement.exception.ProductNotFoundException;
import com.jbk.ProductManagement.service.ProductService;

@RestController
@RequestMapping(value ="/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping(value="/saveProduct")	
	public ResponseEntity<String> saveProduct(@Validated @RequestBody Product product)
	{
		Boolean save=service.saveProduct(product);
		if(save)
		{
			return new ResponseEntity<String>("Product saved !!", HttpStatus.CREATED);
		}
		else 
		{
			throw new ProductAlreadyExistsException(product);
		}
	}
	
	@GetMapping(value="/getProductByProductId")	
	public ResponseEntity<Product> getProductByProductId(@RequestParam int productId)
	{
		String productIdOfException=String.valueOf(productId);
		Product product=service.getProductByProductId(productId);
		if(product!=null)
		{
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}
		else
		{
			throw new ProductNotFoundException(productIdOfException);
		}
	}
	
	@GetMapping(value="/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts()
	{
		List<Product> products=service.getAllProduct();
		//if(products.isEmpty()!=true)
		if(!products.isEmpty()) 
		{
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}
		else
		{
			throw new NoProductFoundException();
		}
	}
	
	@DeleteMapping(value="/deleteProductByProductId")
	public ResponseEntity<String> deleteProductByProductId(@RequestParam int productId)
	{
		Boolean delete=service.deleteProductByProductId(productId);
		if(delete)
		{
			return new ResponseEntity<String>("Deleted !!",HttpStatus.OK);
		}
		else
		{
			throw new NoProductFoundException();
		}
	}
	
	@PutMapping(value="updateProduct")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product)
	{
		Boolean update=service.updateProduct(product);
		if(update)
		{
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}
		else
		{
			throw new ProductAlreadyExistsException(product);
		}
	}
	
	@GetMapping(value="generateReport")
	public ResponseEntity<String> generateReport(@RequestParam String format)
	{
		String destination=service.generateReport(format);
		return new ResponseEntity<String>(destination,HttpStatus.OK);
	}
}
