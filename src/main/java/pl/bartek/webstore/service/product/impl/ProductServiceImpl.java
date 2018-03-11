/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.service.product.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Required;

import pl.bartek.webstore.converter.ReverseConverter;
import pl.bartek.webstore.dao.ProductDao;
import pl.bartek.webstore.dto.ProductDto;
import pl.bartek.webstore.entity.Product;
import pl.bartek.webstore.service.product.ProductService;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;
	private ReverseConverter<ProductDto, Product> productReverseConverter;
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
	public List<Product> findByPriceAndCriteria(final Map<String, List<String>> criteria, final BigDecimal priceLow,
					final BigDecimal priceHigh) {
		List<Product> productsByCriteria = productDao.findByCriteria(criteria);
		if (priceLow != null && priceHigh != null) {
			productsByCriteria = productsByCriteria.stream()
							.filter(product -> product.getUnitPrice().compareTo(priceLow) > 0
											&& product.getUnitPrice().compareTo(priceHigh) < 0)
							.collect(Collectors.toList());
		} else if (priceLow != null) {
			productsByCriteria = productsByCriteria.stream()
							.filter(product -> product.getUnitPrice().compareTo(priceLow) > 0)
							.collect(Collectors.toList());
		} else if (priceHigh != null) {
			productsByCriteria = productsByCriteria.stream()
							.filter(product -> product.getUnitPrice().compareTo(priceHigh) < 0)
							.collect(Collectors.toList());
		}
		return productsByCriteria;
	}

	@Override
	public void add(final ProductDto productToSave) {
		productDao.save(productReverseConverter.convert(productToSave));
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

	@Required
	public void setProductReverseConverter(final ReverseConverter<ProductDto, Product> productReverseConverter) {
		this.productReverseConverter = productReverseConverter;
	}
}
