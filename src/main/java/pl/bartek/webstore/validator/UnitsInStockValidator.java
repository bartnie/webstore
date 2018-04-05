/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.validator;

import java.math.BigDecimal;

import org.springframework.lang.Nullable;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pl.bartek.webstore.dto.ProductDto;

public class UnitsInStockValidator implements Validator {

	@Override
	public boolean supports(final Class<?> aClass) {
		return ProductDto.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(@Nullable final Object o, final Errors errors) {
		final ProductDto product = (ProductDto) o;
		if (product.getUnitPrice() != null && new BigDecimal(10000).compareTo(product.getUnitPrice()) <= 0
						&& product.getUnitsInStock() > 99) {
			errors.rejectValue("unitsInStock", "pl.bartek.webstore.validator.UnitsInStockValidator.unitsInStock");
		}
	}
}
