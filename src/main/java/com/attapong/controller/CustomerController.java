package com.attapong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.attapong.dao.CustomerDao;
import com.attapong.entity.Customer;
import com.attapong.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomer(Model model) {

		model.addAttribute("customers", customerService.getCustomers());

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showForAdd(Model model) {

		Customer customer = new Customer();

		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@PostMapping("saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {

		customerService.saveCustomer(customer);

		return "redirect:/customer/list";
	}
	

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {

		Customer customer = customerService.getCustomer(id);

		model.addAttribute("customer", customer);

		return "customer-form";

	}
	
	@GetMapping("/showFormForDelete")
	public String showFormForDelete(@RequestParam("customerId") int id, Model model) {

		 customerService.deleteCustomer(id);

		return "redirect:/customer/list";

	}
	
	@PostMapping("/Search")
	public String searchCustomer(@RequestParam("theSearchName") String name, Model model) {

		List<Customer> customers = customerService.serachCustomer(name);

		model.addAttribute("customers", customers);
		
		return "list-customers";

	}
	
}
