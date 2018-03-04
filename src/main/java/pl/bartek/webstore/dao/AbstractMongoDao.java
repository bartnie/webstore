/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.mongodb.core.MongoOperations;

import com.sun.javafx.binding.StringFormatter;

public abstract class AbstractMongoDao<T> implements DataAccessObject<T> {

	private static final Logger logger = LoggerFactory.getLogger(AbstractMongoDao.class);
	private MongoOperations mongoDb;
	private Class<T> entityType;

	@Override
	public T findById(final String id) {
		T entity = mongoDb.findById(id, entityType);
		if (entity == null) {
			logger.error("Couldn't find %s with id %s.", entityType, id);
			throw new IllegalArgumentException(
							String.valueOf(StringFormatter.format("Couldn't find %s with id %s.", entityType, id)));
		}
		return entity;
	}

	@Override
	public List<T> findAll() {
		return mongoDb.findAll(entityType);
	}

	@Override
	public void save(final T objToSave) {
		mongoDb.save(objToSave);
	}

	@Override
	public void removeById(final String id) {
		try {
			mongoDb.remove(this.findById(id));
		} catch (final IllegalArgumentException e) {
			logger.error(String.valueOf(StringFormatter.format("Couldn't delete %s with id %s.", entityType, id)));
		}
	}

	@Required
	public void setMongoDb(final MongoOperations mongoDb) {
		this.mongoDb = mongoDb;
	}

	@Required
	public void setEntityType(final Class<T> entityType) {
		this.entityType = entityType;
	}
}
