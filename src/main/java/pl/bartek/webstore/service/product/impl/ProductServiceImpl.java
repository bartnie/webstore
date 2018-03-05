/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.service.product.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Required;

import pl.bartek.webstore.dao.ProductDao;
import pl.bartek.webstore.entity.Product;
import pl.bartek.webstore.service.product.ProductService;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;
	private Map<String, String> categoryMapping;

	@Override
	public Product findById(final String id) {
		return productDao.findById(id);
	}

	@Override
	public List<Product> findByCategory(final String category) {
		return productDao.findByCategory(categoryMapping.get(category));
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public List<Product> findByCriteria(final Map<String, List<String>> criteria) {
		return productDao.findByCriteria(criteria);
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
	public void setProductDao(final ProductDao productDao) {
		this.productDao = productDao;
	}

	@Required
	public void setCategoryMapping(final Map categoryMapping) {
		this.categoryMapping = categoryMapping;
	}
}
