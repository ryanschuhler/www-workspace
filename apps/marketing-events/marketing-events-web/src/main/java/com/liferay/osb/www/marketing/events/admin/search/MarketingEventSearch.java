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

package com.liferay.osb.www.marketing.events.admin.search;

import com.liferay.osb.www.marketing.events.model.MarketingEvent;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.TextFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * @author Rachael Koestartyo
 */
public class MarketingEventSearch extends SearchContainer<MarketingEvent> {

	public static final String EMPTY_RESULTS_MESSAGE =
		"thanks-for-stopping-by-we-are-working-on-new-events-that-will-be-" +
			"posted-shortly";

	public static List<String> headerNames = new ArrayList<>();
	public static Map<String, String> orderableHeaders = new HashMap<>();

	static {
		headerNames.add("type");
		headerNames.add("title");
		headerNames.add("start-date");
		headerNames.add("global-region");

		orderableHeaders.put("global-region", "global-region");
		orderableHeaders.put("start-date", "start-date");
		orderableHeaders.put("title", "title");
		orderableHeaders.put("type", "type");
	}

	public MarketingEventSearch(
		PortletRequest portletRequest, PortletURL iteratorURL) {

		super(
			portletRequest, new MarketingEventDisplayTerms(portletRequest),
			new MarketingEventSearchTerms(portletRequest), DEFAULT_CUR_PARAM,
			DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		MarketingEventDisplayTerms displayTerms =
			(MarketingEventDisplayTerms)getDisplayTerms();

		iteratorURL.setParameter(
			MarketingEventDisplayTerms.ANYTIME,
			String.valueOf(displayTerms.isAnytime()));
		iteratorURL.setParameter(
			MarketingEventDisplayTerms.GLOBAL_REGIONS,
			ArrayUtil.toStringArray(displayTerms.getGlobalRegions()));
		iteratorURL.setParameter(
			MarketingEventDisplayTerms.START_DATE_GT_DAY,
			String.valueOf(displayTerms.getStartDateGTDay()));
		iteratorURL.setParameter(
			MarketingEventDisplayTerms.START_DATE_GT_MONTH,
			String.valueOf(displayTerms.getStartDateGTMonth()));
		iteratorURL.setParameter(
			MarketingEventDisplayTerms.START_DATE_GT_YEAR,
			String.valueOf(displayTerms.getStartDateGTYear()));
		iteratorURL.setParameter(
			MarketingEventDisplayTerms.START_DATE_LT_DAY,
			String.valueOf(displayTerms.getStartDateLTDay()));
		iteratorURL.setParameter(
			MarketingEventDisplayTerms.START_DATE_LT_MONTH,
			String.valueOf(displayTerms.getStartDateLTMonth()));
		iteratorURL.setParameter(
			MarketingEventDisplayTerms.START_DATE_LT_YEAR,
			String.valueOf(displayTerms.getStartDateLTYear()));
		iteratorURL.setParameter(
			MarketingEventDisplayTerms.SUMMARY, displayTerms.getSummary());
		iteratorURL.setParameter(
			MarketingEventDisplayTerms.TITLE, displayTerms.getTitle());
		iteratorURL.setParameter(
			MarketingEventDisplayTerms.TYPES,
			ArrayUtil.toStringArray(displayTerms.getTypes()));

		String orderByCol = ParamUtil.getString(
			portletRequest, "orderByCol", "start-date");
		String orderByType = ParamUtil.getString(
			portletRequest, "orderByType", "desc");

		//TODO test this
		OrderByComparator orderByComparator =
			OrderByComparatorFactoryUtil.create(
				"MarketingEvent",
				TextFormatter.format(orderByCol, TextFormatter.M),
				orderByType.equals("asc"));

		setOrderableHeaders(orderableHeaders);
		setOrderByCol(orderByCol);
		setOrderByType(orderByType);
		setOrderByComparator(orderByComparator);
	}

}