/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.service.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import pl.bartek.webstore.dao.DataAccessObject;
import pl.bartek.webstore.entity.Product;
import pl.bartek.webstore.service.product.ProductService;

public class ProductServiceImpl implements ProductService {

	private DataAccessObject<Product> productDao;

	@Override
	public Product findById(final String id) {
		return productDao.findById(id);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public void save(final Product productToSave) {
		productDao.save(productToSave);
	}

	@Override
	public void removeById(final String id) {
		productDao.removeById(id);
	}

	@Required
	public void setProductDao(final DataAccessObject<Product> productDao) {
		this.productDao = productDao;
	}
}
