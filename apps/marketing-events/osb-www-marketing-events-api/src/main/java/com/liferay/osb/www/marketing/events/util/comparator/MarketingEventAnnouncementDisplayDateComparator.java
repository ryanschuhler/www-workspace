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

import com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Ryan Schuhler
 */
public class MarketingEventAnnouncementDisplayDateComparator
	extends OrderByComparator<MarketingEventAnnouncement> {

	//TODO: add table name?

	public static final String ORDER_BY_ASC = "displayDate ASC";

	public static final String ORDER_BY_DESC = "displayDate DESC";

	public static final String[] ORDER_BY_FIELDS = {"displayDate"};

	public MarketingEventAnnouncementDisplayDateComparator() {
		this(true);
	}

	public MarketingEventAnnouncementDisplayDateComparator(boolean asc) {
		_asc = asc;
	}

	@Override
	public int compare(
		MarketingEventAnnouncement marketingEventAnnouncement1,
		MarketingEventAnnouncement marketingEventAnnouncement2) {

		int value = DateUtil.compareTo(
			marketingEventAnnouncement1.getDisplayDate(),
			marketingEventAnnouncement2.getDisplayDate());

		if (_asc) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_asc) {
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

	private boolean _asc;

}