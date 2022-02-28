package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AllController {
	
	@RequestMapping({"/", "/home"})
	public String showHome() {
		return "index";
	}

	@RequestMapping("/result")
	public String getResult() {
		return "hello world";
	}
	
}
