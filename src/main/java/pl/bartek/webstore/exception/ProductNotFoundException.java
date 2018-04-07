/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.exception;

public class ProductNotFoundException extends AbstractNotFoundException {
	private static final long serialVersionUID = -976546782397L;
	private final String productId;

	public ProductNotFoundException(final String productId) {
		this.productId = productId;
	}

	public String getProductId() {
		return productId;
	}
}
