/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.service.product;

import java.util.List;

import pl.bartek.webstore.entity.Product;

public interface ProductService {
	Product findById(final String id);

	List<Product> findAll() ;

	void save(final Product productToSave);

	void removeById(final String id);
}
