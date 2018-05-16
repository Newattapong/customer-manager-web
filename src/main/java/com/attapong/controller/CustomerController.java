package com.attapong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.attapong.dao.CustomerDao;
import com.attapong.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerDao customers;
	
	@RequestMapping("/list")
	public String listCustomer(Model model) {
		
		model.addAttribute("customers",customers.getCustomers());
		
		return "list-customers";
	}
}
