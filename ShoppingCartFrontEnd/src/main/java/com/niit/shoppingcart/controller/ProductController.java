package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class ProductController {

	@Autowired
	Product product;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	Category category;

	@Autowired
	Supplier supplier;

	@Autowired
	SupplierDAO supplierDAO;

	public ProductController() {

	}

	@RequestMapping("manage_product_remove")
	public String DeleteProduct(@ModelAttribute("id") String id, Model model, HttpSession session) {
		product = productDAO.get(id);
		productDAO.delete(product);
		List<Product> productList = productDAO.list();
		session.setAttribute("productList", productList);
		model.addAttribute("ShowProductTable", true);
		return "index";

	}

	@RequestMapping("manage_product_edit")
	public String editproduct(@ModelAttribute("id") String id, Model model, HttpSession session) {
		product = productDAO.get(id);
		model.addAttribute("product", product);
		model.addAttribute("ShowProduct", true);
		return "index";
	}

	@RequestMapping("/displayProduct")
	public String displayProduct(Model model, HttpSession session,
			@ModelAttribute("categoryId") String categoryId, @ModelAttribute("subCategoryId") String subCategoryId) {

		List<Product> productList = productDAO.listByCategoryAndSubCategory(categoryId, subCategoryId);
		if (productList != null) {
			model.addAttribute("productCountMsg", productList.size() + " product(s) found !!!");
			session.setAttribute("productListBySubCategory", productList);
			model.addAttribute("ShowProductsForSubCategory", true);
		} else {
			model.addAttribute("productCountMsg", "No products found for this category !!!");
		}

		return "index";
	}
}
