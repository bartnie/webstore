/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.service.cart;

import pl.bartek.webstore.entity.Cart;

public interface CartService {
	Cart create(Cart cart);

	Cart read(String cartId);

	Cart update(String cartId, Cart cart);

	void delete(String cartId);
}
