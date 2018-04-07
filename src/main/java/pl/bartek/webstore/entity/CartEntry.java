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

	public CartEntry(final Product product) {
		this.product = product;
		this.quantity = 1;
		totalPrice = product.getUnitPrice();
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

	public void setTotalPrice(final BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
}
