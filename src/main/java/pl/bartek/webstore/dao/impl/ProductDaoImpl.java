/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import pl.bartek.webstore.dao.AbstractMongoDao;
import pl.bartek.webstore.dao.ProductDao;
import pl.bartek.webstore.entity.Product;

public class ProductDaoImpl extends AbstractMongoDao<Product> implements ProductDao {

	@Override
	public List<Product> findByCategory(final String category) {
		return mongoDb.find(new Query(Criteria.where("category").is(category)), Product.class);
	}
}
