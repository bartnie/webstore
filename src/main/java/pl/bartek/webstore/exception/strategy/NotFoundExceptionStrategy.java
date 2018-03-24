/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.exception.strategy;

import java.util.Map;

import org.springframework.beans.factory.annotation.Required;

import pl.bartek.webstore.entity.EntityType;
import pl.bartek.webstore.exception.ProductNotFoundException;

public class NotFoundExceptionStrategy {

	private Map<Class, EntityType> entityClassToEnumMapping;

	public void chooseException(final Class clazz, final Map<String, String> context) {
		final EntityType entityType = entityClassToEnumMapping.get(clazz);
		switch (entityType) {
		case PRODUCT:
			throw new ProductNotFoundException(context.get("id"));
		}
	}

	@Required
	public void setEntityClassToEnumMapping(final Map<Class, EntityType> entityClassToEnumMapping) {
		this.entityClassToEnumMapping = entityClassToEnumMapping;
	}
}
