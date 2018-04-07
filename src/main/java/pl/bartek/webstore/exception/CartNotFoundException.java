/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.exception;

public class CartNotFoundException extends AbstractNotFoundException {
	private static final long serialVersionUID = -273546542797L;
	private final String cartId;

	public CartNotFoundException(final String cartId) {
		this.cartId = cartId;
	}

	public String getCartId() {
		return cartId;
	}
}
