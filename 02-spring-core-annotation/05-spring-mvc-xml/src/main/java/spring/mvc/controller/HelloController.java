package spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static common.Application.*;

@Controller
@RequestMapping("/hello")
public class HelloController {
	// Web Request
	
	//@GetMapping("/show-form")
	@RequestMapping(value = "/show-form", method = RequestMethod.GET)
	public String show() {
		return HELLO_FORM_PAGE;
	}
	
	// @PostMapping("/submit-form")
	@RequestMapping(value = "/submit-form", method = RequestMethod.POST)
	public String submit(Model model,
			@RequestParam String name, 
			@RequestParam int age) {
		
		String info = name + " is " + age + " years old !";
		model.addAttribute("message", info);
		
		System.out.println("message: " + info);
		
		return HELLO_INFO_PAGE;
	}
}
