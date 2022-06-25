package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

import com.springmvc.entity.Customer;
import com.springmvc.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public String index(ModelMap modelMap) {

		List<Customer> customers = customerService.getAll();
		
		

		modelMap.addAttribute("customers", customers);

		return "customer/customer-index";
	}

	
	
//	private List<Customer> Search(List<Customer> customers, String text){
//		return customers.stream().filter(customer -> customer.getFirstName().toLowerCase().contains(text.toLowerCase())).collect(Collectors.toList());
//	}
	
	@GetMapping("/update")
	public String update(ModelMap modelMap, @RequestParam("id") int id) {
		Customer customer = customerService.get(id);
		modelMap.addAttribute("customer", customer);
		return "customer/customer-form";
	}
	
	
	
	@GetMapping("/delete")
	public String delete(ModelMap modelMap, @RequestParam("id") int id) {
		customerService.delete(id);
		return "redirect:/customer";
	}
	
	
	@GetMapping("/add")
	public String add(ModelMap modelMap) {
		modelMap.addAttribute("customer", new Customer());
		return "customer/customer-form";
	}
	
	

	
	@PostMapping("/save")
	public String save(@ModelAttribute("customer") Customer customer) {
		
		if (customer.getId() == null) {
			customer.setId(0);
		}
		customerService.save(customer);
		
		return "customer/customer-form";
	}
}