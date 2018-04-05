/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProductIdValidator.class)
@Documented
public @interface Product {
	String message() default "{pl.bartek.webstore.validator.Product.message}";

	Class<?>[] groups() default {};

	public abstract Class<? extends Payload>[] payload() default {};
}
