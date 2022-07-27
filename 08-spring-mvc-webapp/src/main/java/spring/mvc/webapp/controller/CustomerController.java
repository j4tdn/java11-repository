package spring.mvc.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import common.Application;
import spring.mvc.webapp.entity.Customer;
import spring.mvc.webapp.service.CustomerService;

import static common.InfoMessage.*;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public String index(Model model) {
		List<Customer> customers = customerService.findAll();
		
		model.addAttribute("customers", customers);
		
		return Application.CUSTOMER_INDEX_PAGE;
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("customer", new Customer());
		return Application.CUSTOMER_FORM_PAGE;
	}
	
	@GetMapping("/update")
	public String update(@RequestParam int id, Model model) {
		model.addAttribute("customer", customerService.get(id));
		return Application.CUSTOMER_FORM_PAGE;
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int id) {
		customerService.delete(id);
		return Application.CUSTOMER_INDEX_PAGE_REDIRECT + DELETE_SUCCESS;
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Customer customer) {
		boolean isAddNew = customer.getId() == null;
		customerService.save(customer);
		// redirect:/customer?info='add-success'
		return Application.CUSTOMER_INDEX_PAGE_REDIRECT + (isAddNew ? ADD_SUCCESS : UPDATE_SUCCESS);
	}
}
