
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.osb.www.marketing.events.util;

/**
 * @author Allen Ziegenfus
 */
public enum MarketingEventSessionLogoType {

	LOGO_TYPE_SESSION("session"), LOGO_TYPE_SPEAKER_COMPANY("speaker-company");

	public static MarketingEventSessionLogoType parse(String value) {
		if (LOGO_TYPE_SESSION.getValue().equals(value)) {
			return LOGO_TYPE_SESSION;
		}
		else if (LOGO_TYPE_SPEAKER_COMPANY.getValue().equals(value)) {
			return LOGO_TYPE_SPEAKER_COMPANY;
		}

		throw new IllegalArgumentException("Invalid value " + value);
	}

	public String getValue() {
		return _value;
	}

	@Override
	public String toString() {
		return _value;
	}

	private MarketingEventSessionLogoType(String value) {
		_value = value;
	}

	private String _value;

}