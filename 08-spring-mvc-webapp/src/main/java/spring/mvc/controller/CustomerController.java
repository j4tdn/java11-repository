package spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.entity.Customer;
import spring.mvc.service.CustomerService;

import static spring.mvc.common.Application.*;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping
	public String show(Model model) {
		
		List<Customer> customers = customerService.getAll();
		
		model.addAttribute("customers", customers);
		
		return CUSTOMER_INDEX_PAGE;
	}
	
	@GetMapping("/add")
	public String showAddPage() {
		
		return CUSTOMER_FORM_PAGE;
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("customer") Customer customer) {
		customerService.save(customer);
		return CUSTOMER_INDEX_PAGE;
	}
	
}
