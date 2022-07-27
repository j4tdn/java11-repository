package spring.mvc.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import common.Application;

@Controller
public class HomePageController {

	@GetMapping
	public String homepage() {
		return Application.HOMEPAGE;
	}
	
}
