/*
 * This file is part of SpringMVC.
 * 
 * <brief description of the project>
 * Copyright (C) 2012 Simone Spaccarotella {spa.simone@gmail.com}
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.service.SpringService;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
@Controller
public class HomeController {

	@Autowired
	private SpringService service;

	@RequestMapping({ "/", "home" })
	public String showHomePage(Model model) {
		model.addAttribute("users", service.getAllUsers());
		return "home";
	}

}
