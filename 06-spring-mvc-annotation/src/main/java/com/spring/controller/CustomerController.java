package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.entity.Customer;
import com.spring.service.CustomerService;

@Controller
@RequestMapping("/customer/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public String index(ModelMap modelMap) {
		List<Customer> customers = customerService.getALL();
		
		modelMap.addAttribute("customers", customers);
		
		return "customer/index.jsp";
	}
}
