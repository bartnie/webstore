/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/loginfailed")
	public String loginError(final Model model) {
		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(final Model model) {
		return "login";
	}
}
