package spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import spring.mvc.service.CustomerService;

@Controller
public class HomePageController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public String welcome() {
		
		customerService.testConnection();
		
		return "home";
	}
	
}
