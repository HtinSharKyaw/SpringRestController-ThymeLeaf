package com.htinshar.demo.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.htinshar.demo.domain.Product;

@RestController
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/{userId}")
	public String displayUsers(@PathVariable int userId) {
		return "User found in : " + userId;
	}

	@RequestMapping("/{userId}/invoices")
	public String displayUserInvoices(@PathVariable int userId,
			@RequestParam(value = "date", required = false) Date dateOrNull) {
		return "Invoices found for users in : " + userId + "on the date: " + dateOrNull;
	}
	
	@RequestMapping("/{userId}/items")
	public List<String> displayStringJson(){
		return Arrays.asList("Shoes","Laptops","buttons");
	}
	
	@RequestMapping("/{userId}/products")
	public List<Product> displayProductsJson(){
		return Arrays.asList(new Product(1, "shoes", 42.33),
				new Product(2, "bags", 30.33),
				new Product(3, "shirts", 25.33));
	}
}
