package com.niit.shoppingcart.daoimpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.OrdersDAO;
import com.niit.shoppingcart.model.Order;

@Repository("orderDAO")
public class OrdersDAOImpl implements OrdersDAO, Serializable {

	
	@Autowired
	  SessionFactory sessionFactory;
		
	   public OrdersDAOImpl(SessionFactory sessionFactory)
	   {
		   this.sessionFactory=sessionFactory;
	   }
	   
	   
	   @Transactional
	   public boolean saveOrUpdate(Order orders) {
	   	try{
	   			sessionFactory.getCurrentSession().saveOrUpdate(orders);
	   		return true;
	   	}
	   	catch(HibernateException e){
	   		e.printStackTrace();
	   	return false;
	   	}
	   }

	   @Transactional
	   public boolean update(Order orders) {
	   	try{
	  		sessionFactory.getCurrentSession().update(orders);
	   		return true;
	   	}
	   	catch(HibernateException e){
	         e.printStackTrace();		
	   	return false;
	   	}
	   }

	   @Transactional
	   public boolean delete(Order orders) {
	   	   
	   	try{
	   			sessionFactory.getCurrentSession().delete(orders);
	   			return true;
	   		}	
	   	catch(HibernateException e){
	   		e.printStackTrace();
	   	return false;
	   	}
	   }


	   @Transactional  
	   public Order get(String id) {
	   	return (Order) sessionFactory.getCurrentSession().get(Order.class,id);
	   }

	   
	   @Transactional
	  public List<Order> list() {
	  	String hql="from Orders";
	  	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	  	return  query.list();
	  }
}