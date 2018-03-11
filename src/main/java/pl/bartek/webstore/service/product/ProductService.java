/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.service.product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import pl.bartek.webstore.dto.ProductDto;
import pl.bartek.webstore.entity.Product;

public interface ProductService {
	Product findById(final String id);

	List<Product> findByCategory(final String category);

	List<Product> findAll();

	List<Product> findByPriceAndCriteria(Map<String, List<String>> criteria, BigDecimal priceLow, BigDecimal priceHigh);

	void add(final ProductDto productToSave);

	void removeById(final String id);
}
