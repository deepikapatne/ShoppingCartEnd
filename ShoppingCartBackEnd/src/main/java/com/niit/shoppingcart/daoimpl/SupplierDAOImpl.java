package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.Supplier;
@Repository
public class SupplierDAOImpl implements SupplierDAO {

	// You required session factory -> in application context config

	@Autowired
	private SessionFactory sessionFactory;

	// How get initialize
	// At the time of creation of instance , you have pass sessionFactory

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Supplier> list() {

		String hql = "from Supplier";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();

	}
	//If the valid id -> will return Supplier domain object
	//If the invalid id -> will return null
	@Transactional
	public Supplier get1 (String id) {
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id);

	}

	@Transactional
	public boolean save(Supplier Supplier) {

		try {
			sessionFactory.getCurrentSession().save(Supplier);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	@Transactional
	public boolean update(Supplier Supplier) {
		try {
			sessionFactory.getCurrentSession().update(Supplier);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Supplier get (String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Supplier validate(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}


}
