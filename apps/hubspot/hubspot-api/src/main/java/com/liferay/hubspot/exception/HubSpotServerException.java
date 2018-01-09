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

package com.liferay.hubspot.exception;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Peter Shin
 */
public class HubSpotServerException extends PortalException {

	public HubSpotServerException() {
		super();
	}

	public HubSpotServerException(Message message) {
		super(message.getString("response"));

		_response = message.getString("response");
		_statusCode = message.getInteger("statusCode");
		_uri = message.getString("uri");
	}

	public HubSpotServerException(String msg) {
		super(msg);
	}

	public HubSpotServerException(String uri, int statusCode, String response) {
		super(response);

		_response = response;
		_statusCode = statusCode;
		_uri = uri;
	}

	public HubSpotServerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public HubSpotServerException(Throwable cause) {
		super(cause);
	}

	public String getResponse() {
		return _response;
	}

	public JSONObject getResponseJSONObject() {
		try {
			return JSONFactoryUtil.createJSONObject(getResponse());
		}
		catch (JSONException jsone) {
			return null;
		}
	}

	public int getStatusCode() {
		return _statusCode;
	}

	public String getURI() {
		return _uri;
	}

	private String _response;
	private int _statusCode;
	private String _uri;

}
