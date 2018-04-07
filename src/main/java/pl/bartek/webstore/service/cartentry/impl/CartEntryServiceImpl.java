/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.service.cartentry.impl;

import java.math.BigDecimal;

import pl.bartek.webstore.entity.CartEntry;
import pl.bartek.webstore.service.cartentry.CartEntryService;

public class CartEntryServiceImpl implements CartEntryService {

	@Override
	public void addUnits(final CartEntry cartEntry, final int unitsToAdd){
		cartEntry.setQuantity(cartEntry.getQuantity() + unitsToAdd);
		updateTotalPrice(cartEntry);
	}

	private void updateTotalPrice(final CartEntry cartEntry) {
		cartEntry.setTotalPrice(
						cartEntry.getProduct().getUnitPrice().multiply(BigDecimal.valueOf(cartEntry.getQuantity())));
	}
}
