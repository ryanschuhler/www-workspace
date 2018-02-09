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

package com.liferay.osb.www.marketing.events.util.comparator;

import com.liferay.osb.www.marketing.events.model.MarketingEventUser;
import com.liferay.portal.kernel.model.ClassedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Comparator;

/**
 * @author Joan H. Kim
 */
public class MarketingEventUserFirstNameComparator
	extends OrderByComparator<MarketingEventUser> {

	public static final String ORDER_BY_ASC = "firstName ASC, lastName ASC";

	public static final String ORDER_BY_DESC = "firstName DESC, lastName DESC";

	public static final String[] ORDER_BY_FIELDS = {"firstName", "lastName"};

	public MarketingEventUserFirstNameComparator() {
		this(false);
	}

	public MarketingEventUserFirstNameComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(
		MarketingEventUser marketingEventUser1,
		MarketingEventUser marketingEventUser2) {

		String firstName1 = marketingEventUser1.getFirstName();
		String firstName2 = marketingEventUser2.getFirstName();

		int value = firstName1.compareTo(firstName2);

		if (value == 0) {
			String lastName1 = marketingEventUser1.getLastName();
			String lastName2 = marketingEventUser2.getLastName();

			value = lastName1.compareTo(lastName2);
		}

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}