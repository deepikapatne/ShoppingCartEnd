package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SubCategoryDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.SubCategory;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.util.Util;

@Controller
public class AdminController {
	
	
	@Autowired
	private Product product;

	@Autowired
	private Supplier supplier;

	@Autowired
	private Category category;
	
	@Autowired
	private SubCategory subcategory;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private SubCategoryDAO subCategoryDAO;

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	private String path = "\\resources\\img";

	@RequestMapping("/addcategory")
	public String Addcategory(Model model, HttpSession session, @ModelAttribute("id") String id, @ModelAttribute("name") String name, @ModelAttribute("description") String description) {
		boolean isPresent = categoryDAO.get(id) != null;
		
		category.setId(id);
		category.setName(name);
		category.setDescription(description);
		
		boolean flag = false;
		if(isPresent) {
			flag = categoryDAO.update(category);
		} else {
			flag = categoryDAO.save(category);
		}
		if (flag)
		{
			List<Category> categoryList = categoryDAO.list();
			session.setAttribute("CategoryList", categoryList);
			model.addAttribute("message", "Category added/updated successfully !!!");
		} else {
			model.addAttribute("message", "Error occured");
		}
		
		session.removeAttribute("category");
		model.addAttribute("ShowMessage", true);
		return "index";
	}

	@RequestMapping("/addsubcategory")
	public String Addsubcategory(Model model, HttpSession session, @ModelAttribute("id") String id, @ModelAttribute("name") String name, @ModelAttribute("description") String description) {
		boolean isPresent = subCategoryDAO.get(id) != null;
		
		subcategory.setId(id);
		subcategory.setName(name);
		subcategory.setDescription(description);
		
		boolean flag = false;
		if(isPresent) {
			flag = subCategoryDAO.update(subcategory);
		} else {
			flag = subCategoryDAO.save(subcategory);
		}

		if (flag)
		{
			model.addAttribute("message", "Sub Category added/updated successfully !!!");
			List<SubCategory> categoryList = subCategoryDAO.list();
			session.setAttribute("subcategoryList", categoryList);
		} else {
			model.addAttribute("message", "Error occured");
		}

		session.removeAttribute("subcategory");
		model.addAttribute("ShowMessage", true);
		return "index";
	}

	@RequestMapping("/addsupplier")
	public String Addsupplier(Model model, HttpSession session, @ModelAttribute("id") String id,
			@ModelAttribute("name") String name, @ModelAttribute("address") String address) {
		boolean isPresent = supplierDAO.get(id) != null;
		
		supplier.setId(id);
		supplier.setName(name);
		supplier.setAddress(address);
		
		boolean flag = false;
		if(isPresent) {
			flag = supplierDAO.update(supplier);
		} else {
			flag = supplierDAO.save(supplier);
		}
		
		if (flag) {
			model.addAttribute("message", "Supplier added/updated successfully !!!");
			List<Supplier> supplierList = supplierDAO.list();
			session.setAttribute("supplierList", supplierList);
		} else {
			model.addAttribute("message", "Error Occured");
		}
		session.removeAttribute("supplier");
		model.addAttribute("ShowMessage", true);
		return "index";
	}

	@RequestMapping("/addproduct")
	public String Addproduct(Model model, HttpSession session, @ModelAttribute("id") String id,@RequestParam("image") MultipartFile file,
			@ModelAttribute("name") String name, @ModelAttribute("price") int price,
			@ModelAttribute("stock") int stock, @ModelAttribute("category_id") String category_id, @ModelAttribute("subcategory_id") String subcategory_id,
			@ModelAttribute("supplier_id") String supplier_id, @ModelAttribute("description") String description) {
		
		boolean isPresent = productDAO.get(id) != null;
		
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		product.setStock(stock);
		product.setDescription(description);
		product.setCategory_id(category_id);
		product.setSubcategory_id(subcategory_id);
		product.setSupplier_id(supplier_id);
		
		boolean flag = false;
		if(isPresent) {
			flag = productDAO.update(product);
		} else {
			flag = productDAO.save(product);
		}

		if (flag) {
	       Util.upload(servletContext, path, file, product.getId()+".jpg");
			model.addAttribute("message", "Product added/updated successfully !!!");
			List<Product> productList = productDAO.list();
			session.setAttribute("productList", productList);
		} else {
			model.addAttribute("message", "Error occured");
		}
		
		session.removeAttribute("product");
		model.addAttribute("ShowMessage", true);
		return "index";
	}
	/*
	 * @RequestMapping("Category") public ModelAndView categories() {
	 * log.debug("Starting of the method categories"); ModelAndView mv = new
	 * ModelAndView("Category"); mv.addObject("category", category);
	 * mv.addObject("isAdminClickedCategories", "true");
	 * mv.addObject("categoryList", categoryDAO.list());
	 * log.debug("Ending of the method categories"); return mv; }
	 */
	/*
	 * @RequestMapping("manageProducts") public ModelAndView products() {
	 * log.debug("Starting of the method products"); ModelAndView mv = new
	 * ModelAndView("index");
	 * 
	 * mv.addObject("isAdminClickedProducts", "true"); mv.addObject("product",
	 * product); mv.addObject("productList", productDAO.list());
	 * mv.addObject("category", category); mv.addObject("categoryList",
	 * categoryDAO.list()); mv.addObject("supplier", supplier);
	 * mv.addObject("supplierList", supplierDAO.list());
	 * log.debug("Ending of the method products"); return mv; }
	 */

	/*
	 * @RequestMapping("manageSuppliers") public ModelAndView suppliers() {
	 * log.debug("Starting of the method suppliers"); ModelAndView mv = new
	 * ModelAndView("home"); mv.addObject("supplier", supplier);
	 * mv.addObject("isAdminClickedSuppliers", "true");
	 * mv.addObject("supplierList", supplierDAO.list());
	 * log.debug("Ending of the method suppliers"); return mv; }
	 */

	@RequestMapping("/categorytable")
	public String categorytable(Model model, HttpSession session)

	{
		model.addAttribute("ShowCategoryTable", true);
		session.setAttribute("categoryList", categoryDAO.list());
		return "index";
	}
	
	@RequestMapping("/subcategorytable")
	public String subcategorytable(Model model, HttpSession session)

	{
		model.addAttribute("ShowSubCategoryTable", "true");
		session.setAttribute("subcategoryList", subCategoryDAO.list());
		return "index";
	}

	@RequestMapping("/category")
	public String Category(Model model)

	{
		model.addAttribute("ShowCategory", true);
		return "index";
	}
	
	@RequestMapping("/subcategory")
	public String SubCategory(Model model)

	{
		model.addAttribute("ShowSubCategory", true);
		return "index";
	}

	@RequestMapping(value = { "/suppliertable" })
	public String suppliertable(Model model, HttpSession session) {
		model.addAttribute("ShowSupplierTable", true);
		session.setAttribute("supplierList", supplierDAO.list());
		return "index";
	}

	@RequestMapping("/supplier")
	public String Supplier(Model model) {
		model.addAttribute("ShowSupplier", true);
		return "index";
	}

	@RequestMapping(value = { "/producttable" })
	public String producttable(Model model, HttpSession session) {
		model.addAttribute("ShowProductTable", true);
		session.setAttribute("productList", productDAO.list());
		return "index";
	}

	@RequestMapping("/product")
	public String Product(Model model) {
		model.addAttribute("ShowProduct", true);
		return "index";
	}

}