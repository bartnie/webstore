/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import pl.bartek.webstore.entity.Product;
import pl.bartek.webstore.service.product.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Resource(name = "productService")
	private ProductService productService;

	@RequestMapping
	public String getProducts(final Model model) {
		model.addAttribute("products", productService.findAll());
		return "products";
	}

	@RequestMapping("/{category}")
	public String getProductsInCategory(final Model model, @PathVariable final String category){
		model.addAttribute("products", productService.findByCategory(category));
		return "products";
	}

	@RequestMapping("/filter/{criteria}")
	public String getProductsByCriteria(final Model model, @MatrixVariable final Map<String, List<String>> criteria){
		model.addAttribute("products", productService.findByCriteria(criteria));
		return "products";
	}

	@RequestMapping("/{id}")
	public String getProductById(@PathVariable final String id, final Model model){
		model.addAttribute("product", productService.findById(id));
		return "product";
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Product addProducts(@PathVariable final String id, @RequestBody final Product body) {
		body.setId(id);
		productService.save(body);
		return body;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void removeProduct(@PathVariable final String id) {
		productService.removeById(id);
	}
}
