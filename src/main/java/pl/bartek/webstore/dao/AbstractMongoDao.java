/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public abstract class AbstractMongoDao<T> implements DataAccessObject<T> {

	private static final Logger logger = LoggerFactory.getLogger(AbstractMongoDao.class);
	protected MongoOperations mongoDb;
	private Class<T> entityType;

	@Override
	public T findById(final String id) {
		final T entity = mongoDb.findById(id, entityType);
		if (entity == null) {
			logger.error("Couldn't find %s with id %s.", entityType, id);
			throw new IllegalArgumentException(String.format("Couldn't find %s with id %s.", entityType, id));
		}
		return entity;
	}

	@Override
	public List<T> findAll() {
		return mongoDb.findAll(entityType);
	}

	@Override
	public List<T> findByCriteria(final Map<String, List<String>> criteria) {
		final Query query = new Query();
		for (final String criterionKey : criteria.keySet()) {
			query.addCriteria(Criteria.where(criterionKey).regex(prepareRegEx(criteria.get(criterionKey)), "i"));
		}
		return mongoDb.find(query, entityType);
	}

	private String prepareRegEx(final List<String> criteria) {
		final StringBuilder regEx = new StringBuilder();
		for (final String criterion : criteria) {
			regEx.append("(").append(criterion).append(")|");
		}
		regEx.deleteCharAt(regEx.length() - 1);
		return regEx.toString();
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
			logger.error(String.format("Couldn't delete %s with id %s.", entityType, id));
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
