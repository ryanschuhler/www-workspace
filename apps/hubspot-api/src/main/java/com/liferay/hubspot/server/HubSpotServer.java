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
public interface HubSpotServer {

	public Message executeDelete(String uri, Map<String, String> headers)
		throws HubSpotServerException;

	public Message executeDelete(
			String uri, Map<String, String> headers,
			Map<String, String> parameters)
		throws HubSpotServerException;

	public Message executeGet(String uri, Map<String, String> headers)
		throws HubSpotServerException;

	public Message executeGet(
			String uri, Map<String, String> headers,
			Map<String, String> parameters)
		throws HubSpotServerException;

	public Message executePost(
			String uri, Map<String, String> headers, Body body)
		throws HubSpotServerException;

	public Message executePost(
			String uri, Map<String, String> headers, Body body,
			Map<String, String> parameters)
		throws HubSpotServerException;

	public void shutdown();

	public void startup();

}