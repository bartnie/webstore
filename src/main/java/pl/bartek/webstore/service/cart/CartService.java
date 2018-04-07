/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.service.cart;

import pl.bartek.webstore.entity.Cart;
import pl.bartek.webstore.entity.CartEntry;

public interface CartService {
	Cart findById(final String id);

	void add(final Cart cartToSave);

	void removeById(final String id);

	void addCartEntry(final Cart cart, final CartEntry cartEntry);

	void removeCartEntry(final Cart cart, final CartEntry cartEntry);

}
