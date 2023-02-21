package com.example.j6storeit.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.j6storeit.entity.Category;
import com.example.j6storeit.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.j6storeit.entity.Product;
import com.example.j6storeit.service.ProductService;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller

public class ProductController {

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;

	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("/product/list")
	public String list(Model model, @RequestParam("cid") Optional<String> cid) {
		if (cid.isPresent()) {
			List<Product> list = productService.findByCateId(cid.get());
			model.addAttribute("items",list);


		}
		else {
			List<Product> list = productService.findAll();
			model.addAttribute("items",list);
		}
		List<Product> list= productService.findAll();
		model.addAttribute("item",list);

		return "product/list";
	}
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product item = productService.findById(id);
		model.addAttribute("item",item);

		return "product/detail";
	}
	
}
