package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Order;

public interface OrdersDAO {
	
	public boolean saveOrUpdate(Order orders);
	  public boolean update(Order orders);
	  public boolean delete(Order orders);
	  public Order get(String id);
	  public List<Order> list();
	  
       
}
