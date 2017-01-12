package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;

public interface CategoryDAO {

	public List<Category> list();

	public Category get(String id);

	public boolean save(Category Category);

	public boolean update(Category Category);

}
