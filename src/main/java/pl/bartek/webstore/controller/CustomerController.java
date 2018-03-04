/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.bartek.webstore.service.customer.CustomerService;

@Controller
public class CustomerController {

	@Resource(name="customerService")
	CustomerService customerService;

	@RequestMapping("/customers")
	public String getCustomers(final Model model){
		model.addAttribute("customers",customerService.findAll());
		return "customers";
	}


}
