package com.niit.shoppingcartbackend;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

import junit.framework.Assert;

public class UserDAOTestCase {

	// Autowire - DAO, DO, context

	@Autowired
	static UserDAO userDAO;

	@Autowired
	static User user;

	@Autowired
	static AnnotationConfigApplicationContext context;

	// Previously we written constructor
	// But in Junit we need to write a method
	// this method should call automatically when JUnit Test case run
	@BeforeClass // we can write @BeforeClasses only for the static methods
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();

		user = (User) context.getBean("user");

		userDAO = (UserDAO) context.getBean("userDAO");

	}

	@Test
	public void getUserTestCase() {

		user = userDAO.get("Chirutha");

		// Assert statements
		Assert.assertNotNull("getUserTestCase", user);

	}

	@Test
	public void validateCredentials() {
		user = userDAO.isValidUser("Chirutha", "Chirutha");
		Assert.assertNotNull("validateCredentials", user);
	}

	@Test
	public void inValidateCredentials() {
		user = userDAO.isValidUser("Vibhav", "Vibhav");
		Assert.assertNull("inValidateCredentials", user);

		// OR
		// Assert.assertEquals("inValidateCredentials", null , user );

	}

	@Test
	public void getAllUsersTestCase() {
		int size = userDAO.list().size();
		Assert.assertEquals(" length check ", 1, size);

	}

	@Test
	public void saveTestCase() {

		// you have create /insert new row in db
		// provide values for user

		user.setId("Chirutha");
		user.setName("Chirutha");
		user.setContact("989898989");
		user.setMail("Chirutha@gmila.com");
		user.setPassword("Chirutha");
		user.setRole("ROLE_USER");

		userDAO.saveOrUpdate(user);

		user = userDAO.get("Chirutha");
		Assert.assertEquals("saveTestCase", "Chirutha", user.getName());
		Assert.assertEquals("saveTestCase", "Chirutha@gmila.com", user.getMail());

	}

	@Test
	public void updateTestCase() {

		user = userDAO.get("Chirutha");
		user.setMail("Chirutha@gmail.com");
		userDAO.saveOrUpdate(user);
		user = userDAO.get("Chirutha");
		
		Assert.assertEquals("saveTestCase", "Chirutha", user.getName());
		Assert.assertEquals("saveTestCase", "Chirutha@gmail.com", user.getMail());

	}

}
