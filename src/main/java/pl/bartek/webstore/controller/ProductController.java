/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sun.javafx.binding.StringFormatter;

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

	@RequestMapping("/category/{category}")
	public String getProductsInCategory(final Model model, @PathVariable final String category) {
		model.addAttribute("products", productService.findByCategory(category));
		return "products";
	}

	@RequestMapping("/filter/{criteria}")
	public String getProductsByPriceAndCriteria(final Model model,
					@MatrixVariable final Map<String, List<String>> criteria,
					@RequestParam(value = "low", required = false) final BigDecimal priceLow,
					@RequestParam(value = "high", required = false) final BigDecimal priceHigh) {
		model.addAttribute("products", productService.findByPriceAndCriteria(criteria, priceLow, priceHigh));
		return "products";
	}

	@RequestMapping("/{id}")
	public String getProductById(@PathVariable final String id, final Model model) {
		model.addAttribute("product", productService.findById(id));
		return "product";
	}

	@RequestMapping(value = "/add")
	public String getAddProductForm(final Model model) {
		model.addAttribute("product", productService.findById("1"));
		return "addProduct";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") final Product body, final BindingResult result) {
		final String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException(String.valueOf(StringFormatter.format("Proba wiazania niedozwolonych pol: %s",
							StringUtils.arrayToCommaDelimitedString(suppressedFields))));
		}
		productService.add(body);
		return "redirect:/products";
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Product addProductByRest(@PathVariable final String id, @RequestBody final Product body) {
		body.setId(id);
		productService.add(body);
		return body;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void removeProduct(@PathVariable final String id) {
		productService.removeById(id);
	}

	@InitBinder
	public void initialiseBinder(final WebDataBinder binder) {
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}
}
