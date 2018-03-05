/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.dao;

import java.util.List;
import java.util.Map;

public interface DataAccessObject<T> {
	T findById(String id);

	List<T> findByCriteria(Map<String, List<String>> criteria);

	List<T> findAll();

	void save(T objToSave);

	void removeById(String id);
}
