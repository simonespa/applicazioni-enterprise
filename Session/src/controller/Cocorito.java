package controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bean.Login;
import bean.Signup;

@Controller
public class Cocorito {

	@RequestMapping("/")
	public String showIndex(Model model) {
		model.addAttribute("login", new Login());
		model.addAttribute("signup", new Signup());
		return "index";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@Valid Login login, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("signup", new Signup());
			return "index";
		}
		System.out.println(login.getA());
		System.out.println(login.getB());
		return "result";
	}

	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signup(@Valid Signup signup, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("login", new Login());
			return "index";
		}
		System.out.println(signup.getC());
		System.out.println(signup.getD());
		return "result";
	}

}
