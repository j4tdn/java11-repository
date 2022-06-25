package spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@GetMapping
	public String index(ModelMap model) {
//		model.addAttribute("customers", customers);

		return "customer/customer-index";
	}
	
}
