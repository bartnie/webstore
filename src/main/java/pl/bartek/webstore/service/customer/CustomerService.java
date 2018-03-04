/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.service.customer;

import java.util.List;

import pl.bartek.webstore.entity.Customer;

public interface CustomerService {
	List<Customer> findAll();
}
