/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.dto;

import java.math.BigDecimal;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import pl.bartek.webstore.enums.ProductConditionEnum;
import pl.bartek.webstore.validator.Product;

@Product
public class ProductDto extends BaseDto {

	@Size(min = 4, max = 50, message = "{validation.product.name.size}")
	private String name;

	@Min(value = 0, message = "{validation.product.unitPrice.min}")
	@Digits(integer = 8, fraction = 2, message = "{validation.product.unitPrice.digits}")
	@NotNull(message = "{validation.product.unitPrice.notNull}")
	private BigDecimal unitPrice;

	private String description;
	private String manufacturer;

	@NotNull(message = "{validation.product.category.notNull}")
	private String category;

	@Min(value=0, message = "{validation.product.unitsInStock.min}")
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
