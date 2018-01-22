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

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Date;
import java.util.TimeZone;

import javax.portlet.PortletRequest;

/**
 * @author Rachael Koestartyo
 */
public class MarketingEventSearchTerms extends MarketingEventDisplayTerms {

	public MarketingEventSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);

		anytime = DAOParamUtil.getBoolean(portletRequest, ANYTIME);
		globalRegions = ParamUtil.getIntegerValues(
			portletRequest, GLOBAL_REGIONS);
		startDateGTDay = DAOParamUtil.getInteger(
			portletRequest, START_DATE_GT_DAY);
		startDateGTMonth = DAOParamUtil.getInteger(
			portletRequest, START_DATE_GT_MONTH);
		startDateGTYear = DAOParamUtil.getInteger(
			portletRequest, START_DATE_GT_YEAR);
		startDateLTDay = DAOParamUtil.getInteger(
			portletRequest, START_DATE_LT_DAY);
		startDateLTMonth = DAOParamUtil.getInteger(
			portletRequest, START_DATE_LT_MONTH);
		startDateLTYear = DAOParamUtil.getInteger(
			portletRequest, START_DATE_LT_YEAR);
		summary = DAOParamUtil.getString(portletRequest, SUMMARY);
		title = DAOParamUtil.getString(portletRequest, TITLE);
		types = ParamUtil.getIntegerValues(portletRequest, TYPES);
	}

	public Date getStartDateGTDate(TimeZone timeZone) throws PortalException {
		if (anytime) {
			return null;
		}

		return PortalUtil.getDate(
			startDateGTMonth, startDateGTDay, startDateGTYear, timeZone,
			(Class<? extends PortalException>)null);
	}

	public Date getStartDateLTDate(TimeZone timeZone) throws PortalException {
		if (anytime) {
			return null;
		}

		return PortalUtil.getDate(
			startDateLTMonth, startDateLTDay, startDateLTYear, timeZone,
			(Class<? extends PortalException>)null);
	}

}