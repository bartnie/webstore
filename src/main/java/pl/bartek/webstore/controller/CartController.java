/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {
	@RequestMapping
	public String getCurrentCartId(final HttpServletRequest request) {
		return "redirect:/cart/"+request.getSession(true).getId();
	}

	@RequestMapping("/{cartId}")
	public String getCartId(@PathVariable final String cartId, final Model model) {
		model.addAttribute("cartId", cartId);
		return "cart";
	}
}
