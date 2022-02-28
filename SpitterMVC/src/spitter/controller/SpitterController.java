package spitter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spitter.beanForm.SpitterForm;
import spitter.dto.Spitter;
import spitter.service.PersistenceService;

@Controller
@RequestMapping("/spitters")
public class SpitterController {

	private final PersistenceService persistenceService;

	@Autowired
	public SpitterController(PersistenceService persistenceService) {
		this.persistenceService = persistenceService;
	}

	@RequestMapping(value = "/spittles", method = RequestMethod.GET)
	public String listSpittlesForSpitter(@RequestParam("spitter") String firstName, Model model) {
		Spitter spitter = persistenceService.getSpitterByFirstName(firstName);
		model.addAttribute(spitter);
		model.addAttribute("spittles", persistenceService.getSpitterByFirstName(firstName));
		return "spittles/list";
	}

	@RequestMapping(method = RequestMethod.GET, params = "new")
	public String createSpitterProfile(Model model) {
		model.addAttribute("spitter", new SpitterForm());
		return "spitters/edit";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addSpitterFromForm(@Valid SpitterForm spitterBean, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "spitters/edit";
		}
		Spitter spitter = new Spitter();
		spitter.setFirstName(spitterBean.getFirstName());
		spitter.setLastName(spitterBean.getLastName());
		persistenceService.saveSpitter(spitter);
		return "redirect:/spitters/" + spitter.getFirstName();
	}

	@RequestMapping(value = "/{firstName}", method = RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String firstName, Model model) {
		model.addAttribute("spitter", persistenceService.getSpitterByFirstName(firstName));
		return "spitters/view";
	}

}
