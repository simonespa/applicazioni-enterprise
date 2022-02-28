package spitter.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spitter.beanForm.SpitterForm;

@Controller
public class ProvaController {

	@RequestMapping("index")
	public String showHomePage() {
		return "index";
	}
	
	@RequestMapping(value = "register")
	public String register(Model model) {
		model.addAttribute("spitter", new SpitterForm());
		return "registration";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String visualize(@Valid SpitterForm spitter, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		model.addAttribute("spitter", spitter);
		return "redirect:/index";
	}

}