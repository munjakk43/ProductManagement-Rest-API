package com.jbk.ProductManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name ="Product")
public class Product {
	
	@Id
	@Column(nullable = false, name="product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int product_id;
	
	@Column(unique = true,name="product_name" )
	private String product_name;
	
	@Column(name="supplier_id" )
	private int supplier_id;
	
	@Column(name="quantity_per_unit" )
	private String quantity_per_unit;
	
	@Column(name="product_price" )
	private long product_price;
	
	@Column(name="product_in_stock" )
	private int product_in_stock;
	
	public Product() {
		
	}

	public Product(int product_id, String product_name, int supplier_id, String quantity_per_unit, long product_price,
			int product_in_stock) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.supplier_id = supplier_id;
		this.quantity_per_unit = quantity_per_unit;
		this.product_price = product_price;
		this.product_in_stock = product_in_stock;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getQuantity_per_unit() {
		return quantity_per_unit;
	}

	public void setQuantity_per_unit(String quantity_per_unit) {
		this.quantity_per_unit = quantity_per_unit;
	}

	public long getProduct_price() {
		return product_price;
	}

	public void setProduct_price(long product_price) {
		this.product_price = product_price;
	}

	public int getProduct_in_stock() {
		return product_in_stock;
	}

	public void setProduct_in_stock(int product_in_stock) {
		this.product_in_stock = product_in_stock;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", supplier_id=" + supplier_id
				+ ", quantity_per_unit=" + quantity_per_unit + ", product_price=" + product_price
				+ ", product_in_stock=" + product_in_stock + "]";
	}
		
}
