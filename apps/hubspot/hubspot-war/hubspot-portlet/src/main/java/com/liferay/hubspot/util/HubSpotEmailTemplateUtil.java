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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.portlet.PortletProps;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author Joan H. Kim
 */
public class HubSpotEmailTemplateUtil {

	public static String getRenewalTemplateId(String countryCode)
		throws SystemException {

		Locale locale = getLocale(countryCode);

		if (locale == null) {
			locale = LocaleUtil.getDefault();
		}

		String templateId = PortletProps.get(
			PortletPropsKeys.HUBSPOT_RENEWAL_TEMPLATE_ID + StringPool.PERIOD +
			locale);

		if (Validator.isNull(templateId)) {
			templateId = PortletPropsValues.HUBSPOT_RENEWAL_TEMPLATE_ID;
		}

		return templateId;
	}

	protected static Locale getLocale(String countryCode) {
		if (_locales == null) {
			_locales = new HashMap<String, Locale>();

			for (String languageId :
					PortletPropsValues.HUBSPOT_RENEWAL_LANGUAGE_IDS) {

				Locale locale = LocaleUtil.fromLanguageId(languageId, false);

				_locales.put(locale.getCountry(), locale);
			}
		}

		return _locales.get(countryCode);
	}

	private static Map<String, Locale> _locales;

}
