/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.dao;

import java.util.List;

import pl.bartek.webstore.entity.Product;

public interface ProductDao extends DataAccessObject<Product> {
	List<Product> findByCategory(String category);

}
