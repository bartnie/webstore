/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PromotionController {

	@RequestMapping("/invalidPromoCode")
	public String invadliPromoCode() {
		return "invalidPromoCode";
	}
}
