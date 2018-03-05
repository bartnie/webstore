/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.service.customer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import pl.bartek.webstore.dao.CustomerDao;
import pl.bartek.webstore.entity.Customer;
import pl.bartek.webstore.service.customer.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;

	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	@Required
	public void setCustomerDao(final CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
}
