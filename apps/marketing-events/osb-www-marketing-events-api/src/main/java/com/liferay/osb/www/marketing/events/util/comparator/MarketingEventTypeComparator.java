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
import com.liferay.portal.kernel.util.CollatorUtil;

import java.text.Collator;

import java.util.Comparator;
import java.util.Locale;

/**
 * @author Rachael Koestartyo
 * @author Allen Ziegenfus
 */
public class MarketingEventTypeComparator
	implements Comparator<MarketingEvent> {

	public MarketingEventTypeComparator(Locale locale, boolean asc) {
		_locale = locale;
		_asc = asc;
	}

	@Override
	public int compare(
		MarketingEvent marketingEvent1, MarketingEvent marketingEvent2) {

		String typeLabel1 = MarketingEventConstants.getTypeLabel(
			marketingEvent1.getType());

		String typeValue1 = LanguageUtil.get(_locale, typeLabel1);

		String typeLabel2 = MarketingEventConstants.getTypeLabel(
			marketingEvent2.getType());

		String typeValue2 = LanguageUtil.get(_locale, typeLabel2);

		Collator collator = CollatorUtil.getInstance(_locale);

		int value = collator.compare(typeValue1, typeValue2);

		if (_asc) {
			return value;
		}
		else {
			return -value;
		}
	}

	private final boolean _asc;
	private final Locale _locale;

}