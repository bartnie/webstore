/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.dto;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import pl.bartek.webstore.enums.ProductConditionEnum;

public class ProductDto extends BaseDto {

	private String name;
	private BigDecimal unitPrice;
	private String description;
	private String manufacturer;
	private String category;
	private Long unitsInStock;
	private Long unitsInOrder;
	private Boolean discontinued;
	private ProductConditionEnum condition;
	private MultipartFile productImage;

	public String getId() {
		return this.id;
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

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(final MultipartFile productImage) {
		this.productImage = productImage;
	}
}
