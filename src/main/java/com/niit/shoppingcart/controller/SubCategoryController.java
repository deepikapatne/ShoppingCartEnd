package com.niit.shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.shoppingcart.dao.SubCategoryDAO;
import com.niit.shoppingcart.model.SubCategory;

@Controller
public class SubCategoryController {

	@Autowired
	SubCategory subCategory;

	@Autowired
	SubCategoryDAO subCategoryDAO;

	@RequestMapping("manage_subcategory_remove")
	public String deleteCategory(@ModelAttribute("id") String id, Model model, HttpSession session) {
		subCategory = subCategoryDAO.get(id);
		subCategoryDAO.delete(subCategory);
		session.setAttribute("subcategoryList", subCategoryDAO.list());
		model.addAttribute("ShowSubCategoryTable", true);
		return "index";
	}

	@RequestMapping("manage_subcategory_edit")
	public String editCategory(@ModelAttribute("id") String id, Model model, HttpSession session) {
		subCategory = subCategoryDAO.get(id);
		model.addAttribute("subcategory", subCategory);
		model.addAttribute("ShowSubCategory", "true");
		return "index";

	}

}
