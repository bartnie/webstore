/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No product found under category")
public class NoProductsFoundUnderCategoryException extends RuntimeException {
	private static final long serialVersionUID = 39315770827384L;
}
