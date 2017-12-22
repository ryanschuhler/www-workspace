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

package com.liferay.hubspot.server;

import com.liferay.hubspot.exception.HubSpotServerException;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.util.Http.Body;

import java.util.Map;

/**
 * @author Peter Shin
 * @author Weston Hancock
 */
public class HubSpotServerUtil {

	public static Message executeDelete(String uri, Map<String, String> headers)
		throws HubSpotServerException {

		return getHubSpotServer().executeDelete(uri, headers);
	}

	public static Message executeDelete(
			String uri, Map<String, String> headers,
			Map<String, String> parameters)
		throws HubSpotServerException {

		return getHubSpotServer().executeDelete(uri, headers, parameters);
	}

	public static Message executeGet(String uri, Map<String, String> headers)
		throws HubSpotServerException {

		return getHubSpotServer().executeGet(uri, headers);
	}

	public static Message executeGet(
			String uri, Map<String, String> headers,
			Map<String, String> parameters)
		throws HubSpotServerException {

		return getHubSpotServer().executeGet(uri, headers, parameters);
	}

	public static Message executePost(
			String uri, Map<String, String> headers, Body body)
		throws HubSpotServerException {

		return getHubSpotServer().executePost(uri, headers, body);
	}

	public static Message executePost(
			String uri, Map<String, String> headers, Body body,
			Map<String, String> parameters)
		throws HubSpotServerException {

		return getHubSpotServer().executePost(uri, headers, body, parameters);
	}

	public static HubSpotServer getHubSpotServer() {
		return _hubSpotServer;
	}

	public static void shutdown() {
		getHubSpotServer().shutdown();
	}

	public static void startup() {
		getHubSpotServer().startup();
	}

	public void setHubSpotServer(HubSpotServer hubSpotServer) {
		_hubSpotServer = hubSpotServer;
	}

	private static HubSpotServer _hubSpotServer;

}