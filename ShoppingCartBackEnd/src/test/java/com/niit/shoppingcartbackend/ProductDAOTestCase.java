package com.niit.shoppingcartbackend;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

import junit.framework.Assert;

public class ProductDAOTestCase {

	//Autowire - DAO, DO, context
	
	
	@Autowired
	static ProductDAO productDAO;
	
	@Autowired
	static Product  product;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	
	//Previously we written constructor
	//But in Junit we need to write a method
	//this method should call automatically when JUnit Test case run
	@BeforeClass   //we can write @BeforeClasses only for the static methods
	public static void init()
	{
		context = new  AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		product = (Product) context.getBean("product");
		
		productDAO = (ProductDAO) context.getBean("productDAOImpl");
		 
	}
	
	@Test
	public void getproductTestCase()
	{
		product = productDAO.get("Nokia");
		//Assert statements
	  Assert.assertNotNull("getproductTestCase", product);
	}
	
	
	@Test
	public void getAllproductsTestCase()
	{
	 int size=	productDAO.list().size();
	 Assert.assertEquals(" length check ", 1 , size);
	 
	 
	}
	
	
	@Test
	public void saveTestCase()
	{
		
		//you have create /insert new row in db
		//provide values for product
		
		product.setId("Nokia");
		product.setName("Nokia Phone");
		product.setDescription("Nokia Mobile Phone");
		
		
	 Assert.assertEquals("saveTestCase", true, 	productDAO.save(product));
		
	}
	
	
	@Test
	public void updateTestCase()
	{
		
	product.setId("Nokia");
	product.setDescription("Nokia Cell Phone");
	Assert.assertEquals("updateTestCase", true, 	productDAO.update(product));
		
	}
	
	
	

	
	

}
