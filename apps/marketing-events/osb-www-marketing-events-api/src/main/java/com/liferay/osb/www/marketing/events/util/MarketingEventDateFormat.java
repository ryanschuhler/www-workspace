
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

import java.text.DateFormat;

/**
 * @author Allen Ziegenfus
 */
public enum MarketingEventDateFormat {

	CUSTOM("custom", -1), FULL("full", DateFormat.FULL),
	LONG("long", DateFormat.LONG), MEDIUM("medium", DateFormat.MEDIUM),
	SHORT("short", DateFormat.SHORT);

	public static MarketingEventDateFormat parse(String value) {
		if (CUSTOM.getValue().equals(value)) {
			return CUSTOM;
		}
		else if (FULL.getValue().equals(value)) {
			return FULL;
		}
		else if (LONG.getValue().equals(value)) {
			return LONG;
		}
		else if (MEDIUM.getValue().equals(value)) {
			return MEDIUM;
		}

		throw new IllegalArgumentException("Invalid value " + value);
	}

	public static MarketingEventDateFormat toMarketingEventDateFormat(
		int style) {

		for (MarketingEventDateFormat marketingEventDateFormat : values()) {
			if (marketingEventDateFormat.getStyle() == style) {
				return marketingEventDateFormat;
			}
		}

		return FULL;
	}

	public int getStyle() {
		return _style;
	}

	public String getValue() {
		return _value;
	}

	@Override
	public String toString() {
		return _value;
	}

	private MarketingEventDateFormat(String value, int style) {
		_style = style;
		_value = value;
	}

	private int _style;
	private String _value;

}