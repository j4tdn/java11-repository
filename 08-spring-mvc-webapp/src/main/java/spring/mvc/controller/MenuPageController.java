package spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static spring.mvc.common.Application.*;

@Controller
@RequestMapping("home")
public class MenuPageController {

	@GetMapping
	public String showMenuPage() {
		return MENU_INDEX_PAGE;
	}
}
