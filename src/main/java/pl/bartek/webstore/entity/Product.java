/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.entity;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

import pl.bartek.webstore.enums.ProductConditionEnum;

@Document(collection = "products")
public class Product extends BaseEntity{

	private String name;
	private BigDecimal unitPrice;
	private String description;
	private String manufacturer;
	private String category;
	private Long unitsInStock;
	private Long unitsInOrder;
	private Boolean discontinued;
	private ProductConditionEnum condition;

	public Product(){}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(final BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(final String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(final String category) {
		this.category = category;
	}

	public Long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(final Long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public Long getUnitsInOrder() {
		return unitsInOrder;
	}

	public void setUnitsInOrder(final Long unitsInOrder) {
		this.unitsInOrder = unitsInOrder;
	}

	public Boolean getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(final Boolean discontinued) {
		this.discontinued = discontinued;
	}

	public ProductConditionEnum getCondition() {
		return condition;
	}

	public void setCondition(final ProductConditionEnum condition) {
		this.condition = condition;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		final Product product = (Product) o;

		return id != null ? id.equals(product.id) : product.id == null;
	}

	@Override
	public int hashCode() {

		return 31 * (id != null ? id.hashCode() : 0);
	}

	@Override
	public String toString() {
		return "Product{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
	}
}
