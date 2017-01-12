package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
@Repository
public class CategoryDAOImpl implements CategoryDAO {

	// You required session factory -> in application context config

	@Autowired
	private SessionFactory sessionFactory;

	// How get initialize
	// At the time of creation of instance , you have pass sessionFactory

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Category> list() {

		String hql = "from Category";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();

	}
	//If the valid id -> will return Category domain object
	//If the invalid id -> will return null
	@Transactional
	public Category get(String id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);

	}

	@Transactional
	public boolean save(Category Category) {

		try {
			sessionFactory.getCurrentSession().save(Category);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	@Transactional
	public boolean update(Category Category) {
		try {
			sessionFactory.getCurrentSession().update(Category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	

}
