package spring.mvc.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import common.Application;

@Controller
@RequestMapping("stuff")
public class StuffController {

	@GetMapping
	public String stuff() {
		return Application.STUFF_INDEX_PAGE;
	}
	
}
