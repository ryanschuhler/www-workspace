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

package com.liferay.hubspot.util;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;

import java.util.Date;

/**
 * @author Peter Shin
 */
public class HubSpotUtil {

	public static Date getLastSynchronizedDate(long companyId)
		throws SystemException {

		Date[] synchronizeDates = getSynchronizeDates(companyId);

		if (synchronizeDates.length == 0) {
			return null;
		}

		return synchronizeDates[0];
	}

	public static String getSFLeadCompany(User user)
		throws PortalException, SystemException {

		return ExpandoValueLocalServiceUtil.getData(
			user.getCompanyId(), User.class.getName(),
			HubSpotConstants.EXPANDO_TABLE_DEFAULT,
			HubSpotConstants.EXPANDO_COLUMN_DEFAULT_COMPANY, user.getUserId(),
			StringPool.BLANK);
	}

	public static String getSFLeadCountry(User user)
		throws PortalException, SystemException {

		String[] countries = ExpandoValueLocalServiceUtil.getData(
			user.getCompanyId(), User.class.getName(),
			HubSpotConstants.EXPANDO_TABLE_DEFAULT,
			HubSpotConstants.EXPANDO_COLUMN_DEFAULT_COUNTRY, user.getUserId(),
			new String[0]);

		return StringUtil.merge(countries, StringPool.COMMA_AND_SPACE);
	}

	public static String getSFLeadDepartment(User user)
		throws PortalException, SystemException {

		String[] departments = ExpandoValueLocalServiceUtil.getData(
			user.getCompanyId(), User.class.getName(),
			HubSpotConstants.EXPANDO_TABLE_DEFAULT,
			HubSpotConstants.EXPANDO_COLUMN_DEFAULT_DEPARTMENT,
			user.getUserId(), new String[0]);

		return StringUtil.merge(departments, StringPool.COMMA_AND_SPACE);
	}

	public static String getSFLeadIndustry(User user)
		throws PortalException, SystemException {

		String[] industries = ExpandoValueLocalServiceUtil.getData(
			user.getCompanyId(), User.class.getName(),
			HubSpotConstants.EXPANDO_TABLE_DEFAULT,
			HubSpotConstants.EXPANDO_COLUMN_DEFAULT_INDUSTRY, user.getUserId(),
			new String[0]);

		return StringUtil.merge(industries, StringPool.COMMA_AND_SPACE);
	}

	public static String getSFLeadRole(User user)
		throws PortalException, SystemException {

		String[] companyRoles = ExpandoValueLocalServiceUtil.getData(
			user.getCompanyId(), User.class.getName(),
			HubSpotConstants.EXPANDO_TABLE_DEFAULT,
			HubSpotConstants.EXPANDO_COLUMN_DEFAULT_COMPANY_ROLE,
			user.getUserId(), new String[0]);

		return StringUtil.merge(companyRoles, StringPool.COMMA_AND_SPACE);
	}

	public static boolean isEnabled() {
		if (Validator.isNull(PortletPropsValues.HUBSPOT_SETTINGS_HAPIKEY) &&
			Validator.isNull(PortletPropsValues.HUBSPOT_SETTINGS_PORTAL_ID)) {

			return false;
		}

		return true;
	}

	public static boolean isSynchronizing(long companyId)
		throws SystemException {

		Date[] synchronizeDates = getSynchronizeDates(companyId);

		if (synchronizeDates.length == 1) {
			return true;
		}

		return false;
	}

	protected static Date[] getSynchronizeDates(long companyId)
		throws SystemException {

		// Workaround for 6.1.20 ExpandoValueImpl#getDateArray

		ExpandoValue expandoValue = ExpandoValueLocalServiceUtil.getValue(
			companyId, Company.class.getName(),
			HubSpotConstants.EXPANDO_TABLE_HUBSPOT,
			HubSpotConstants.EXPANDO_COLUMN_HUBSPOT_SYNCHRONIZE_DATES,
			companyId);

		if (expandoValue == null) {
			return new Date[0];
		}

		String[] data = StringUtil.split(expandoValue.getData());

		Date[] dates = new Date[data.length];

		for (int i = 0; i < data.length; i++) {
			String value = data[i];

			// LPS-38542 ExpandoValueImpl#setDateArray

			if (Validator.isNumber(value)) {
				dates[i] = new Date(GetterUtil.getLong(value));
			}
			else {
				dates[i] = new Date(value);
			}
		}

		return dates;
	}

}