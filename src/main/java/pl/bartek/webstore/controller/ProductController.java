/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.multipart.MultipartFile;

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
		model.addAttribute("product", new Product());
		return "addProduct";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") final Product body, final BindingResult result,
					final HttpServletRequest request) {
		final String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException(String.valueOf(StringFormatter.format("Proba wiazania niedozwolonych pol: %s",
							StringUtils.arrayToCommaDelimitedString(suppressedFields))));
		}
		processFile(body, request);
		productService.add(body);
		return "redirect:/products";
	}

	private void processFile(final Product product, final HttpServletRequest request) {
		final MultipartFile productImage = product.getProductImage();
		final String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(rootDirectory.concat("resources\\images\\").concat(product.getId())
								.concat(".png")));
			} catch (final IOException e) {
				throw new RuntimeException("Unsuccesfull attempt to save product image file", e);
			}

		}
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
