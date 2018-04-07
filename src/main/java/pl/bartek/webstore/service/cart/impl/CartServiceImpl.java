/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.service.cart.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Required;

import pl.bartek.webstore.dao.CartDao;
import pl.bartek.webstore.entity.Cart;
import pl.bartek.webstore.entity.CartEntry;
import pl.bartek.webstore.service.cart.CartService;
import pl.bartek.webstore.service.cartentry.CartEntryService;

public class CartServiceImpl implements CartService {

	private CartDao cartDao;
	private CartEntryService cartEntryService;

	@Override
	public Cart findById(final String id) {
		return cartDao.findById(id);
	}

	@Override
	public void add(final Cart cartToSave) {
		cartDao.save(cartToSave);
	}

	@Override
	public void removeById(final String id) {
		cartDao.removeById(id);
	}

	@Override
	public void addCartEntry(final Cart cart, final CartEntry cartEntry) {
		final String productId = cartEntry.getProduct().getId();
		if (cart.getCartEntries().containsKey(productId)) {
			cartEntryService.addUnits(cartEntry, cart.getCartEntries().get(productId).getQuantity());
		}
		cart.getCartEntries().put(productId, cartEntry);
		updateGrandTotal(cart);
	}

	@Override
	public void removeCartEntry(final Cart cart, final CartEntry cartEntry) {
		cart.getCartEntries().remove(cartEntry.getProduct().getId());
		updateGrandTotal(cart);
	}

	private void updateGrandTotal(final Cart cart) {
		BigDecimal grandTotal = new BigDecimal(0);
		for (final CartEntry entry : cart.getCartEntries().values()) {
			grandTotal = grandTotal.add(entry.getTotalPrice());
		}
		cart.setGrandTotal(grandTotal);
	}

	@Required
	public void setCartDao(final CartDao cartDao) {
		this.cartDao = cartDao;
	}

	@Required
	public void setCartEntryService(final CartEntryService cartEntryService) {
		this.cartEntryService = cartEntryService;
	}
}
