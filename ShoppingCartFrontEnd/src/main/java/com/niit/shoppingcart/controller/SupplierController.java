package com.niit.shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class SupplierController {
	
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping("manage_supplier_remove")
	public String deleteSupplier(@ModelAttribute("id") String id, Model model, HttpSession session)
	{ 
		supplier = supplierDAO.get(id);
		supplierDAO.delete(supplier);
		session.setAttribute("supplierList", supplierDAO.list());
		model.addAttribute("ShowSupplierTable", true);
		return "index";
	}
	
	@RequestMapping("manage_supplier_edit")
	public String editSupplier(@ModelAttribute("id") String id, Model model, HttpSession session)
	{
		supplier = supplierDAO.get(id);
		model.addAttribute("supplier", supplier);
		model.addAttribute("ShowSupplier", "true");
		return "index";
	}
	
}
