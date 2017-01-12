package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;
@Repository
public class ProductDAOImpl implements ProductDAO {

	// You required session factory -> in application context config

	@Autowired
	private SessionFactory sessionFactory;

	// How get initialize
	// At the time of creation of instance , you have pass sessionFactory

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Product> list() {

		String hql = "from Product";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();

	}
	//If the valid id -> will return Product domain object
	//If the invalid id -> will return null
	@Transactional
	public Product get(String id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);

	}

	@Transactional
	public boolean save(Product Product) {

		try {
			sessionFactory.getCurrentSession().save(Product);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	@Transactional
	public boolean update(Product Product) {
		try {
			sessionFactory.getCurrentSession().update(Product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
