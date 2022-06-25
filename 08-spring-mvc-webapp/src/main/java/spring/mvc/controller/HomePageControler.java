package spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageControler {
	
	@GetMapping
	public String homepage() {
		return "homepage/index";
	}
	
}
