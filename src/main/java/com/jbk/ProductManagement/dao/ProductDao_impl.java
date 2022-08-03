package com.jbk.ProductManagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.ProductManagement.entity.Product;

@Repository
public class ProductDao_impl implements ProductDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Boolean saveProduct(Product product) {
		Boolean save=false;
		Session session=null;
		try {
			session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			Criteria criteria=session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("productName", product.getProduct_name()));
			Product uniqueProduct=(Product)criteria.uniqueResult();
			if(uniqueProduct==null) {
				session.save(product);
				transaction.commit();
				save=true;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return save;
	}
	
	@Override
	public Product getProductByProductId(int productId) {
		Session session=null;
		Product product=null;
		try {
			session=sessionFactory.openSession();
			product=session.get(Product.class, productId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return product;
	}

	@Override
	public List<Product> getAllProduct() {
		Session session=null;
		List<Product> products=null;
		try {
			session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(Product.class);
			products=criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return products;
	}

	@Override
	public Boolean deleteProductByProductId(int productId) {
		Session session=null;
		Boolean delete=false;
		try 
		{
			session=sessionFactory.openSession();
			Product product=session.get(Product.class, productId);
			if(product !=null)
			{
				session.delete(product);
				delete=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return delete;
	}

	@Override
	public Boolean updateProduct(Product product) {
		Session session=null;
		Boolean update=false;
		Product updatedProduct=new Product();
		try 
		{
			session=sessionFactory.openSession();
			if(product !=null)
			{
				updatedProduct.setProduct_id(product.getProduct_id());
				updatedProduct.setProduct_name(product.getProduct_name());
				updatedProduct.setSupplier_id(product.getSupplier_id());
				updatedProduct.setQuantity_per_unit(product.getQuantity_per_unit());
				updatedProduct.setProduct_price(product.getProduct_price());
				updatedProduct.setProduct_in_stock(product.getProduct_in_stock());
				session.update(updatedProduct);
				update=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return update;
	}

}
