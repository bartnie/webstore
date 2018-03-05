/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.service.product;

import java.util.List;
import java.util.Map;

import pl.bartek.webstore.entity.Product;

public interface ProductService {
	Product findById(final String id);

	List<Product> findByCategory(final String category);

	List<Product> findAll() ;

	List<Product> findByCriteria(Map<String,List<String>> criteria);

	void save(final Product productToSave);

	void removeById(final String id);
}
