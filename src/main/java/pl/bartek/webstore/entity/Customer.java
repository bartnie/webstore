/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer extends BaseEntity {

	private String name;
	private String address;
	private Integer noOfOrdersMade;

	public Customer() {
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public Integer getNoOfOrdersMade() {
		return noOfOrdersMade;
	}

	public void setNoOfOrdersMade(final Integer noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}
}
