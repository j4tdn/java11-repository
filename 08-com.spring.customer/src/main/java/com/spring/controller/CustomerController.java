package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entity.Customer;
import com.spring.service.CustomerService;
import com.spring.sorting.SortOrder;
import com.spring.sorting.SortUtils;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping(value = {"", "/", "/{orderBy}"})
	public String index(Model model, @PathVariable(required = false, value = "orderBy") String orderByLink) {
		// orderByFirstName(sortByFirstName), orderByLastName(...), orderByEmail(..)
		List<Customer> customers = customerService.getAll(getSortOrder(orderByLink));
		
		// add to model
		model.addAttribute("customers", customers);

		return "customer/index";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer/form";
	}

	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		// get customer from database
		Customer customer = customerService.get(id);

		// add model attribute
		model.addAttribute("customer", customer);

		return "customer/form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		// call service to delete customer with given id
		customerService.delete(id);

		// redirect customer/list
		return "redirect:/customer";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("param") String searchValue, Model model) {
		if (searchValue == null || searchValue.trim().isEmpty()) {
			return "redirect:/customer";
		}
		
		List<Customer> customers = customerService.search(searchValue.trim());
		model.addAttribute("customers", customers);
		return "customer/index";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("customer") Customer customer) {
		customerService.save(customer);

		return "redirect:/customer";
	}
	
	private SortOrder getSortOrder(String orderByLink) {
		SortOrder sortOrder = null;
		
		if (orderByLink == null) {
			// default sort order: first_name
			sortOrder = new SortOrder().addParam(Customer.FIRST_NAME, true);
		} else {
			String sortProperty = SortUtils.CUSTOMER_ORDER_MAP.get(orderByLink);
			sortOrder = new SortOrder().addParam(sortProperty, true);
			
			if (sortProperty.equals(Customer.FIRST_NAME)) {
				sortOrder.addParam(Customer.LAST_NAME, true);
			} else if (sortProperty.equals(Customer.LAST_NAME)) {
				sortOrder.addParam(Customer.FIRST_NAME, true);
			}
		}
		
		return sortOrder;
	}

}
