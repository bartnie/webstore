/*
 * Copyright (c) 2018.
 * Bartosz Niesobski - All rights reserved.
 */

package pl.bartek.webstore.converter;

import pl.bartek.webstore.dto.BaseDto;
import pl.bartek.webstore.entity.BaseEntity;

public interface Converter <S extends BaseEntity, T extends BaseDto>{
	T convert(S source);
}
