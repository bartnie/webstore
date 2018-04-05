/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.validator;

import java.util.Set;
import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.lang.Nullable;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pl.bartek.webstore.dto.ProductDto;

public class ProductValidator implements Validator {

	private javax.validation.Validator beanValidator;

	private Set<Validator> springValidators;

	@Override
	public boolean supports(final Class<?> aClass) {
		return ProductDto.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(@Nullable final Object o, final Errors errors) {
		final Set<ConstraintViolation<Object>> constraintViolations = beanValidator.validate(o);
		for (final ConstraintViolation constraintViolation : constraintViolations) {
			final String propertyPath = constraintViolation.getPropertyPath().toString();
			final String message = constraintViolation.getMessage();
			errors.rejectValue(propertyPath, "", message);
		}
		for (final Validator validator : springValidators) {
			validator.validate(o, errors);
		}
	}

	@Required
	public void setSpringValidators(final Set<Validator> springValidators) {
		this.springValidators = springValidators;
	}

	@Required
	public void setBeanValidator(final javax.validation.Validator beanValidator) {
		this.beanValidator = beanValidator;
	}
}
