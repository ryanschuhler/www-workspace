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

package com.liferay.hubspot.model.impl;

import com.liferay.hubspot.model.HSContact;
import com.liferay.hubspot.model.HSContactCache;
import com.liferay.hubspot.model.HSContactCacheConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.model.User;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;

/**
 * @author Peter Shin
 */
public class HSContactCacheImpl implements HSContactCache {

	public HSContactCacheImpl(HSContact hsContact) {
		this(hsContact.getVisitorId(), hsContact.getEmailAddress());
	}

	public HSContactCacheImpl(long companyId, long userId) {
		String data = null;

		try {
			data = ExpandoValueLocalServiceUtil.getData(
				companyId, User.class.getName(),
				HSContactCacheConstants.EXPANDO_TABLE_NAME,
				HSContactCacheConstants.EXPANDO_COLUMN_NAME, userId,
				StringPool.BLANK);
		}
		catch (PortalException pe) {
			return;
		}
		catch (SystemException se) {
			return;
		}

		JSONObject dataJSONObject = null;

		try {
			dataJSONObject = JSONFactoryUtil.createJSONObject(data);
		}
		catch (JSONException jsone) {
			return;
		}

		if (dataJSONObject.has(HSContactCacheConstants.KEY_EMAIL_ADDRESS)) {
			_emailAddress = dataJSONObject.getString(
				HSContactCacheConstants.KEY_EMAIL_ADDRESS);
		}

		if (dataJSONObject.has(HSContactCacheConstants.KEY_VISITOR_ID)) {
			_visitorId = dataJSONObject.getLong(
				HSContactCacheConstants.KEY_VISITOR_ID);
		}
	}

	public HSContactCacheImpl(Long visitorId, String emailAddress) {
		_emailAddress = emailAddress;
		_visitorId = visitorId;
	}

	@Override
	public String getEmailAddress() {
		return _emailAddress;
	}

	@Override
	public Long getVisitorId() {
		return _visitorId;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	@Override
	public void setVisitorId(Long visitorId) {
		_visitorId = visitorId;
	}

	@Override
	public String toString() {
		JSONObject dataJSONObject = JSONFactoryUtil.createJSONObject();

		if (getEmailAddress() != null) {
			dataJSONObject.put(
				HSContactCacheConstants.KEY_EMAIL_ADDRESS, getEmailAddress());
		}

		if (getVisitorId() != null) {
			dataJSONObject.put(
				HSContactCacheConstants.KEY_VISITOR_ID, getVisitorId());
		}

		return dataJSONObject.toString();
	}

	private String _emailAddress;
	private Long _visitorId;

}
