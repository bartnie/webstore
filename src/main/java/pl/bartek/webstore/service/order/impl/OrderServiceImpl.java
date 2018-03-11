/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.service.order.impl;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import pl.bartek.webstore.dao.DataAccessObject;
import pl.bartek.webstore.entity.Product;
import pl.bartek.webstore.service.order.OrderService;

public class OrderServiceImpl implements OrderService {

	private DataAccessObject<Product> productDao;

	@Override
	@Transactional
	public void processOrder(final String productId, final int amount) {
		final Product product = productDao.findById(productId);
		if (product.getUnitsInStock() < amount) {
			throw new IllegalArgumentException(
							String.format("Couldn't place order for %s items of %s. Actual " + "stock amount: %s items",
											amount, product.getName(), product.getUnitsInStock()));
		}
		product.setUnitsInOrder(product.getUnitsInOrder() + amount);
		product.setUnitsInStock(product.getUnitsInStock() - amount);
		productDao.save(product);
	}

	@Required
	public void setProductDao(final DataAccessObject<Product> productDao) {
		this.productDao = productDao;
	}
}
