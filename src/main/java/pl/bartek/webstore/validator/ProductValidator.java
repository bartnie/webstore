/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;

import pl.bartek.webstore.exception.ProductNotFoundException;
import pl.bartek.webstore.service.product.ProductService;

public class ProductValidator implements ConstraintValidator<Product, Object> {

	@Autowired
	private ProductService productService;

	@Override
	public void initialize(final Product constraintAnnotation) {
	}

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext contex) {
		final Object fieldValue = new BeanWrapperImpl(value).getPropertyValue("id");
		try {
			productService.findById((String) fieldValue);
		} catch (final ProductNotFoundException e) {
			return true;
		}
		return false;
	}
}
