package spring.mvc.webapp.controller;

import static common.InfoMessage.ADD_SUCCESS;
import static common.InfoMessage.DELETE_SUCCESS;
import static common.InfoMessage.UPDATE_SUCCESS;

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

import common.Application;
import common.Pageable;
import common.PagingUtils;
import spring.mvc.webapp.entity.Customer;
import spring.mvc.webapp.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	private static final int pageSize = PagingUtils.ITEMS_PER_PAGE;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public String listCustomers(Model model) {
		return listCustomersByPage(model, 1, "firstName", "asc");
	}
	
	// http://localhost:8080/08-spring-mvc-webapp/customer/page/1?sortField=firstName&sortDir=asc
	@GetMapping("/page/{pageNum}")
	public String listCustomersByPage(Model model,
			@PathVariable(name = "pageNum") int pageNum,
			@RequestParam(name = "sortField") String sortField,
			@RequestParam(name = "sortDir") String sortDir) {
		
		int totalItems = customerService.countTotalItems();
		int totalPages = (int)Math.ceil((float)totalItems/pageSize);
		int currentPage = pageNum > totalPages ? totalPages : pageNum;
		
		List<Customer> customers = customerService.findAll(Pageable.of(currentPage, pageSize), sortField, sortDir);
		model.addAttribute("customers", customers);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reversedOrder", "asc".equals(sortDir) ? "desc" : "asc");
		
		System.out.println("totalItems = " + totalItems + ", totalPages = " + totalPages + ", size = " + customers.size());
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
