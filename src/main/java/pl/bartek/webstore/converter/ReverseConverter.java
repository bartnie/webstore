/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.converter;

import pl.bartek.webstore.dto.BaseDto;
import pl.bartek.webstore.entity.BaseEntity;

public interface ReverseConverter <S extends BaseDto, T extends BaseEntity>{
	T convert(S source);
}
