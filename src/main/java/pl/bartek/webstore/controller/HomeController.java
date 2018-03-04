/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String getHomePage(final Model model) {
		model.addAttribute("greeting", "Witaj w sklepie internetowym!");
		model.addAttribute("tagline", "Wyjatkowym i jedynym sklepie internetowym");
		return "welcome";
	}
}
