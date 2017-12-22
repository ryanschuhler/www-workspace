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
import com.liferay.hubspot.server.HubSpotServerUtil;
import com.liferay.hubspot.util.HubSpotURIUtil;
import com.liferay.hubspot.util.database.DossieraDatabaseUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Http.Body;
import com.liferay.portal.kernel.util.StringPool;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpStatus;

/**
 * @author Joan H. Kim
 */
public class SendHubSpotEmailRenewalsMessageListener
	extends BaseMessageListener {

	@Override
	@SuppressWarnings("unchecked")
	protected void doReceive(Message message) throws Exception {
		JSONArray jsonArray = DossieraDatabaseUtil.getOpportunitiesJSONArray();

		if (jsonArray.length() == 0) {
			return;
		}

		String uri = HubSpotURIUtil.get(
			HubSpotURIUtil.API_CALL_EMAIL, "singleEmail/send");

		Map<String, String> headers = new HashMap<String, String>();

		headers.put(HttpHeaders.CONTENT_TYPE, ContentTypes.APPLICATION_JSON);
		headers.put(HttpHeaders.USER_AGENT, "HS_Email");

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);

			Body body = new Body(
				jsonObject.toString(), ContentTypes.APPLICATION_JSON,
				StringPool.UTF8);

			Message sendMessage = HubSpotServerUtil.executePost(
				uri, headers, body);

			if (_log.isErrorEnabled() &&
				(sendMessage.getInteger("statusCode") != HttpStatus.SC_OK)) {

				_log.error(
					"Unable to send HubSpot email. " +
						sendMessage.get("response"));
			}
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		SendHubSpotEmailRenewalsMessageListener.class);

}