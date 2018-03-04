/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.bartek.webstore.service.order.OrderService;

@Controller
public class OrderController {

	@Resource(name="orderService")
	private OrderService orderService;

	@RequestMapping("/products/{id}/order/{amount}")
	public String placeOrder(@PathVariable final String id, @PathVariable final int amount){
		orderService.processOrder(id,amount);
		return "redirect:/products";
	}
}
