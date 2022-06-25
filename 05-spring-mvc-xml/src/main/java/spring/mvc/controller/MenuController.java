package spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static common.Application.*;

@Controller
public class MenuController {
	// http://localhost:8080/05-spring-mvc-xml/
	// web --> get, post
	
	@GetMapping("/menu")
	public String showHomePage() {
		return MENU_PAGE;
	}	
}
