/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.converter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import pl.bartek.webstore.dto.ProductDto;
import pl.bartek.webstore.entity.Product;

public class ProductReverseConverter implements ReverseConverter<ProductDto, Product> {

	@Override
	public Product convert(final ProductDto source) {
		final Product product = new Product();
		product.setId(source.getId());
		product.setUnitPrice(source.getUnitPrice());
		product.setDescription(source.getDescription());
		product.setManufacturer(source.getManufacturer());
		product.setCategory(source.getCategory());
		product.setUnitsInStock(source.getUnitsInStock());
		product.setUnitsInStock(source.getUnitsInStock());
		product.setUnitsInOrder(source.getUnitsInOrder());
		product.setDiscontinued(source.getDiscontinued());
		product.setCondition(source.getCondition());
		if (!source.getProductImage().isEmpty()) {
			product.setProductImage(convert(source.getProductImage()));
		}
		return product;
	}

	private File convert(final MultipartFile file) {
		final File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(convFile);
			convFile.createNewFile();
			fos.write(file.getBytes());
			fos.close();
		} catch (final IOException e) {
			throw new RuntimeException("Unsuccesfull attempt to convert image file", e);
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}
		return convFile;
	}

}
