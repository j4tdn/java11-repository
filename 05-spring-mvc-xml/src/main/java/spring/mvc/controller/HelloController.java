package spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static common.Application.*;

@Controller
@RequestMapping("/hello")
public class HelloController {
	// Web request 
	
	// @GetMapping("/show-form")
	@RequestMapping(value = "/show-form", method = RequestMethod.GET)
	public String show() {
		return HELLO_FORM_PAGE;
	}
	
	// @PostMapping("/submit-form")
	@RequestMapping(value = "/submit-form", method = RequestMethod.POST)
	public String submit(Model model,
			@RequestParam("name") String theName,
			@RequestParam("age") int theAge) {
		
		String info = theName + " is " + theAge + " years old !";
		model.addAttribute("message", info);
		
		return HELLO_INFO_PAGE;
	}
}
