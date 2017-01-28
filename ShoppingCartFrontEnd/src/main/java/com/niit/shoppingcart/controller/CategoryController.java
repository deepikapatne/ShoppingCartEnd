package com.niit.shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Controller
public class CategoryController {

	@Autowired
	 Category category;
	
	@Autowired
	 CategoryDAO categoryDAO;

	
	@RequestMapping("manage_category_remove")
	public String deleteCategory(@ModelAttribute("id") String id, Model model, HttpSession session) {
		category = categoryDAO.get(id);
		categoryDAO.delete(category);
		session.setAttribute("categoryList", categoryDAO.list());
		model.addAttribute("ShowCategoryTable", true);
		return "index";

	}

	@RequestMapping("manage_category_edit")
	public String editCategory(@ModelAttribute("id") String id, Model model, HttpSession session )
	{
		category = categoryDAO.get(id);
		model.addAttribute("category", category);	
		model.addAttribute("ShowCategory", "true");
		return "index";
		
	}
	
}
	

	


