/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import pl.bartek.webstore.dao.DataAccessObject;
import pl.bartek.webstore.entity.Product;
import pl.bartek.webstore.service.product.ProductService;

@Controller
public class ProductController {

	@Resource(name = "productService")
	private ProductService productService;

	@RequestMapping("/products")
	public String getProducts(final Model model) {
		model.addAttribute("products", productService.findAll());
		return "products";
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public Product addProducts(@PathVariable final String id, @RequestBody final Product body) {
		body.setId(id);
		productService.save(body);
		return body;
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public void removeProduct(@PathVariable final String id) {
		productService.removeById(id);
	}
}
