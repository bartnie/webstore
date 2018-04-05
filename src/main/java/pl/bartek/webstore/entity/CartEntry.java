/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.entity;

import java.math.BigDecimal;

public class CartEntry {

	private Product product;
	private int quantity;
	private BigDecimal totalPrice;

	public CartEntry(final Product product, final int quantity) {
		this.product = product;
		this.quantity = quantity;
		updateTotalPrice();
	}

	public void setProduct(final Product product) {
		this.product = product;
	}

	public void setQuantity(final int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void updateTotalPrice() {
		this.totalPrice = this.product.getUnitPrice().multiply(BigDecimal.valueOf(this.quantity));
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final CartEntry cartEntry = (CartEntry) o;

		return product != null ? product.equals(cartEntry.product) : cartEntry.product == null;
	}

	@Override
	public int hashCode() {
		return product != null ? product.hashCode() : 0;
	}
}
