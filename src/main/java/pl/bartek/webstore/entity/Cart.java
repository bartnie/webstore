/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "carts")
public class Cart extends BaseEntity {

	private Map<String, CartEntry> cartEntries;
	private BigDecimal grandTotal;

	public Cart() {
		this.grandTotal = new BigDecimal(0);
		this.cartEntries = new HashMap<>();
	}

	public Cart(final String cartId) {
		this();
		this.id = cartId;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public Map<String, CartEntry> getCartEntries() {
		return cartEntries;
	}

	public void setCartEntries(final Map<String, CartEntry> cartEntries) {
		this.cartEntries = cartEntries;
	}

	public BigDecimal getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(final BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}
}
