package com.jbk.ProductManagement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class ProductManagementApplication {
	
	public static Logger logger=LogManager.getLogger(ProductManagementApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);
		logger.info("Application Started !! ");
	}

}
