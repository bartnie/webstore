/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.service.cart.impl;

import org.springframework.beans.factory.annotation.Required;

import pl.bartek.webstore.dao.CartDao;
import pl.bartek.webstore.entity.Cart;
import pl.bartek.webstore.service.cart.CartService;

public class CartServiceImpl implements CartService {

	private CartDao cartDao;

	@Override
	public Cart create(final Cart cart) {
		cartDao.save(cart);
	}

	@Override
	public Cart read(final String cartId) {

	}

	@Override
	public Cart update(final String cartId, final Cart cart) {
		return null;
	}

	@Override
	public void delete(final String cartId) {

	}

	@Required
	public void setCartDao(final CartDao cartDao) {
		this.cartDao = cartDao;
	}

}
