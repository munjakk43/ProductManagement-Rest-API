package com.jbk.ProductManagement.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.jbk.ProductManagement.dao.ProductDao;
import com.jbk.ProductManagement.entity.Product;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ProductService_impl implements ProductService{

	@Autowired
	private ProductDao dao;
	
	@Override
	public Boolean saveProduct(Product product) {
		Boolean b=dao.saveProduct(product);
		return b;
	}

	@Override
	public Product getProductByProductId(int productId) {
		Product product=dao.getProductByProductId(productId);
		return product;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> products=dao.getAllProduct();
		return products;
	}

	@Override
	public Boolean deleteProductByProductId(int productId) {
		Boolean delete=dao.deleteProductByProductId(productId);
		return delete;
	}

	@Override
	public Boolean updateProduct(Product product) {
		Boolean update=dao.updateProduct(product);
		return update;
	}

	@Override
	public String generateReport(String format) {
		
		List<Product> products=dao.getAllProduct();
		String destination="D:\\ProductReport";
		try {
			File file=ResourceUtils.getFile("classpath:Product.jrxml");
			JasperReport jasperReport=JasperCompileManager.compileReport(file.getAbsolutePath());
			JRBeanCollectionDataSource dataSource=new  JRBeanCollectionDataSource(products);
			JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, null,dataSource);
			if(format.equalsIgnoreCase("pdf"))
			{
				JasperExportManager.exportReportToPdfFile(jasperPrint, destination + "\\ProductList.pdf");
				destination="File generated at "+" " + destination ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return destination;
	}

}
