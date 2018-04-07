/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.service.cartentry;

import pl.bartek.webstore.entity.CartEntry;

public interface CartEntryService {
	void addUnits(final CartEntry cartEntry, final int unitsToAdd);
}

