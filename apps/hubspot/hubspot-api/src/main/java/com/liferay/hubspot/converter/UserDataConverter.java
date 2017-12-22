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

package com.liferay.hubspot.converter;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.Website;

import java.util.List;

/**
 * @author Peter Shin
 */
public class UserDataConverter {

	public static long getCreateDate(User user) {
		return user.getCreateDate().getTime();
	}

	public static String getPhoneNumber(User user) {
		List<Phone> phones = null;

		try {
			phones = user.getPhones();
		}
		catch (Exception e) {
			return null;
		}

		Phone phone = null;

		for (Phone curPhone : phones) {
			ListType listType = null;

			try {
				listType = curPhone.getType();
			}
			catch (Exception e) {
				continue;
			}

			String typeName = GetterUtil.getString(listType.getName());

			if (!StringUtil.equalsIgnoreCase(typeName, "business")) {
				continue;
			}

			phone = curPhone;

			if (curPhone.isPrimary()) {
				break;
			}
		}

		if (phone == null) {
			return null;
		}

		if (Validator.isNull(phone.getNumber())) {
			return StringPool.BLANK;
		}

		String hsPhoneNumber = phone.getNumber();

		if (Validator.isNotNull(phone.getExtension())) {
			hsPhoneNumber = hsPhoneNumber + " ext " + phone.getExtension();
		}

		return hsPhoneNumber;
	}

	public static String getTwitterUserName(User user) {
		Contact contact = null;

		try {
			contact = user.getContact();
		}
		catch (Exception e) {
			return null;
		}

		if (contact == null) {
			return null;
		}

		return GetterUtil.getString(contact.getTwitterSn());
	}

	public static String getWebsiteURL(User user) {
		List<Website> websites = null;

		try {
			websites = user.getWebsites();
		}
		catch (Exception e) {
			return null;
		}

		Website website = null;

		for (Website curWebsite : websites) {
			ListType listType = null;

			try {
				listType = curWebsite.getType();
			}
			catch (Exception e) {
				continue;
			}

			String typeName = GetterUtil.getString(listType.getName());

			if (!StringUtil.equalsIgnoreCase(typeName, "business")) {
				continue;
			}

			website = curWebsite;

			if (curWebsite.isPrimary()) {
				break;
			}
		}

		if (website == null) {
			return null;
		}

		return GetterUtil.getString(website.getUrl());
	}

}