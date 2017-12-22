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

package com.liferay.hubspot.messaging;

import com.liferay.compat.portal.kernel.servlet.HttpHeaders;
import com.liferay.hubspot.model.HSContact;
import com.liferay.hubspot.server.HubSpotServerUtil;
import com.liferay.hubspot.service.HSContactLocalServiceUtil;
import com.liferay.hubspot.util.HubSpotURIUtil;
import com.liferay.hubspot.util.PortletPropsValues;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.Http.Body;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.TimeZoneUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpStatus;

/**
 * @author Joan H. Kim
 */
public class SyncHubSpotVIDMessageListener extends BaseMessageListener {

	@Override
	@SuppressWarnings("unchecked")
	protected void doReceive(Message message) throws Exception {
		Calendar calendar = CalendarFactoryUtil.getCalendar(
			TimeZoneUtil.getTimeZone(StringPool.UTC));

		calendar.setTime(new Date());

		calendar.add(
			Calendar.MINUTE, -PortletPropsValues.HUBSPOT_VID_SYNC_INTERVAL);

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		int contactOffset = 0;
		boolean hasMore = true;
		int timeOffset = 0;

		while (hasMore) {
			Message contactsMessage =
				HSContactLocalServiceUtil.getRecentHSContactSummaries(
					contactOffset, timeOffset,
					PortletPropsValues.HUBSPOT_VID_SYNC_MAX_RESULTS);

			hasMore = contactsMessage.getBoolean("hasMore");

			List<HSContact> hsContacts =
				(List<HSContact>)contactsMessage.getPayload();

			for (HSContact hsContact : hsContacts) {
				if (DateUtil.compareTo(
						calendar.getTime(), hsContact.getModifiedDate()) == 1) {

					hasMore = false;

					break;
				}

				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

				jsonObject.put("vid", String.valueOf(hsContact.getVisitorId()));

				JSONArray propertiesJSONArray =
					JSONFactoryUtil.createJSONArray();

				JSONObject vidJSONObject = JSONFactoryUtil.createJSONObject();

				vidJSONObject.put("property", "vid__c");
				vidJSONObject.put(
					"value", String.valueOf(hsContact.getVisitorId()));

				propertiesJSONArray.put(vidJSONObject);

				jsonObject.put("properties", propertiesJSONArray);

				jsonArray.put(jsonObject);
			}

			contactOffset = contactsMessage.getInteger("contactOffset");
			timeOffset = contactsMessage.getInteger("timeOffset");
		}

		if (jsonArray.length() == 0) {
			return;
		}

		String uri = HubSpotURIUtil.get("contact/batch");

		Map<String, String> headers = new HashMap<String, String>();

		headers.put(HttpHeaders.CONTENT_TYPE, ContentTypes.APPLICATION_JSON);
		headers.put(HttpHeaders.USER_AGENT, "HS_Contacts");

		Body body = new Body(
			jsonArray.toString(), ContentTypes.APPLICATION_JSON,
			StringPool.UTF8);

		Message updateMessage = HubSpotServerUtil.executePost(
			uri, headers, body);

		if (_log.isErrorEnabled() &&
			(updateMessage.getInteger("statusCode") !=
				HttpStatus.SC_ACCEPTED)) {

			_log.error(
				"Unable to update HubSpot contacts. " +
				updateMessage.get("response"));
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		SyncHubSpotVIDMessageListener.class);

}
