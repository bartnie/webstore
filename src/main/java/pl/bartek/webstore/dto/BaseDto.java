/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.dto;

import javax.validation.constraints.Pattern;

public abstract class BaseDto {

	@Pattern(regexp = "[0-9]+", message = "{validation.id.pattern}")
	protected String id;
}
