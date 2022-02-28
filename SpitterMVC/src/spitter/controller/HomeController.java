package spitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spitter.service.PersistenceService;

@Controller
public class HomeController {

	private PersistenceService persistenceService;

	@Autowired
	public HomeController(PersistenceService persistenceService) {
		this.persistenceService = persistenceService;
	}

	@RequestMapping({ "/", "home" })
	public String showHomePage(Model model) {
		model.addAttribute("spittleList", persistenceService.getSomething());
		return "home";
	}

}
