/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {

	private String cartId;
	private Map<String, CartEntry> cartEntries;
	private BigDecimal grandTotal;

	public Cart() {
		this.grandTotal = new BigDecimal(0);
		this.cartEntries = new HashMap<>();
	}

	public Cart(final String cartId) {
		this.cartId = cartId;
	}

	public void setCartId(final String cartId) {
		this.cartId = cartId;
	}

	public void setCartItems(final Map<String, CartEntry> cartItems) {
		this.cartEntries = cartItems;
		updateGrandTotal();
	}

	public String getCartId() {
		return cartId;
	}

	public Map<String, CartEntry> getCartItems() {
		return cartEntries;
	}

	public BigDecimal getGrandTotal() {
		return grandTotal;
	}

	public void addCartEntry(final CartEntry cartEntry) {
		final String productId = cartEntry.getProduct().getId();
		if (cartEntries.containsKey(productId)) {
			cartEntry.setQuantity(cartEntries.get(productId).getQuantity() + cartEntry.getQuantity());
		}
		cartEntries.put(productId, cartEntry);
		updateGrandTotal();
	}

	public void removeCartEntry(final CartEntry cartEntry){
		cartEntries.remove(cartEntry.getProduct().getId());
		updateGrandTotal();
	}

	public void updateGrandTotal(){
		grandTotal = new BigDecimal(0);
		for(final CartEntry entry : cartEntries.values()){
			grandTotal = grandTotal.add(entry.getTotalPrice());
		}
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final Cart cart = (Cart) o;

		return cartId != null ? cartId.equals(cart.cartId) : cart.cartId == null;
	}

	@Override
	public int hashCode() {
		return cartId != null ? cartId.hashCode() : 0;
	}
}
