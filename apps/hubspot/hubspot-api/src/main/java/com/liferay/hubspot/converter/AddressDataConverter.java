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

import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.model.User;

import java.util.List;

/**
 * @author Peter Shin
 */
public class AddressDataConverter {

	public static Address getAddress(User user) {
		List<Address> addresses = null;

		try {
			addresses = user.getAddresses();
		}
		catch (Exception e) {
			return null;
		}

		Address address = null;

		for (Address curAddress : addresses) {
			ListType listType = null;

			try {
				listType = curAddress.getType();
			}
			catch (Exception e) {
				continue;
			}

			String typeName = GetterUtil.getString(listType.getName());

			if (!StringUtil.equalsIgnoreCase(typeName, "business")) {
				continue;
			}

			if (curAddress.isPrimary()) {
				return address;
			}

			address = curAddress;
		}

		return address;
	}

	public static String getCity(Address address) {
		if (address == null) {
			return null;
		}

		return GetterUtil.getString(address.getCity());
	}

	public static String getCountry(Address address) {
		if (address == null) {
			return null;
		}

		if (address.getCountry() == null) {
			return StringPool.BLANK;
		}

		Country country = address.getCountry();

		return GetterUtil.getString(country.getName());
	}

	public static String getPostalCode(Address address) {
		if (address == null) {
			return null;
		}

		return GetterUtil.getString(address.getZip());
	}

	public static String getRegion(Address address) {
		if (address == null) {
			return null;
		}

		if (address.getRegion() == null) {
			return StringPool.BLANK;
		}

		Region region = address.getRegion();

		return GetterUtil.getString(region.getName());
	}

	public static String getStreet(Address address) {
		if (address == null) {
			return null;
		}

		String[] streets = new String[0];

		if (Validator.isNotNull(address.getStreet1())) {
			streets = ArrayUtil.append(streets, address.getStreet1());
		}

		if (Validator.isNotNull(address.getStreet2())) {
			streets = ArrayUtil.append(streets, address.getStreet2());
		}

		if (Validator.isNotNull(address.getStreet3())) {
			streets = ArrayUtil.append(streets, address.getStreet3());
		}

		return StringUtil.merge(streets, StringPool.COMMA_AND_SPACE);
	}

}