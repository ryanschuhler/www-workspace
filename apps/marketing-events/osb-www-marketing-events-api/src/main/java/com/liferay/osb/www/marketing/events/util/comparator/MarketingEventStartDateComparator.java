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

import com.liferay.osb.www.marketing.events.model.MarketingEvent;
import com.liferay.osb.www.marketing.events.model.MarketingEventConstants;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Locale;

/**
 * @author Rachael Koestartyo
 * @author Joan H. Kim
 */
public class MarketingEventStartDateComparator
	extends OrderByComparator<MarketingEvent> {

	// TODO: add table name here?

	public static final String ORDER_BY_ASC = "startDate ASC";

	public static final String ORDER_BY_DESC = "startDate DESC";

	public static final String[] ORDER_BY_FIELDS = {"startDate"};

	public MarketingEventStartDateComparator() {
		this(LocaleUtil.getDefault(), true);
	}

	public MarketingEventStartDateComparator(Locale locale, boolean asc) {
		_locale = locale;
		_asc = asc;
	}

	@Override
	public int compare(
		MarketingEvent marketingEvent1, MarketingEvent marketingEvent2) {

		int value = DateUtil.compareTo(
			marketingEvent1.getStartDate(), marketingEvent2.getStartDate());

		if (value == 0) {
			//Collator collator = Collator.getInstance(_locale);

			String typeLabel1 = MarketingEventConstants.getTypeLabel(
				marketingEvent1.getType());

			String typeValue1 = LanguageUtil.get(_locale, typeLabel1);

			String typeLabel2 = MarketingEventConstants.getTypeLabel(
				marketingEvent2.getType());

			String typeValue2 = LanguageUtil.get(_locale, typeLabel2);

			// TODO: use collator

			//value = collator.compare(typeValue1, typeValue2);
			value = typeValue1.compareTo(typeValue2);
		}

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
	private Locale _locale;

}