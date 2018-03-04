/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.service.order;

public interface OrderService {
	void processOrder(String productId, int count);
}
