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

package com.liferay.hubspot.service.impl;

import com.liferay.hubspot.exception.HubSpotServerException;
import com.liferay.hubspot.exception.NoSuchHSFormException;
import com.liferay.hubspot.model.HSContact;
import com.liferay.hubspot.model.HSForm;
import com.liferay.hubspot.model.HSFormDisplay;
import com.liferay.hubspot.model.impl.HSFormDisplayImpl;
import com.liferay.hubspot.model.impl.HSFormImpl;
import com.liferay.hubspot.server.HubSpotServer;
import com.liferay.hubspot.service.HSContactLocalServiceUtil;
import com.liferay.hubspot.service.base.HSFormLocalServiceBaseImpl;
import com.liferay.hubspot.util.HubSpotURIUtil;
import com.liferay.hubspot.util.HubSpotUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Http.Body;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpStatus;

/**
 * @author Peter Shin
 * @author Allen Ziegenfus
 */
public class HSFormLocalServiceImpl extends HSFormLocalServiceBaseImpl {

	public HSForm fetchHSFormByGUID(String guid) throws PortalException {
		String encodedGUID = HttpUtil.encodeURL(guid, true);

		if (!HubSpotUtil.isEnabled()) {
			return null;
		}

		String uri = HubSpotURIUtil.get("forms", "forms/" + encodedGUID);
		Map<String, String> headers = getHeaders(ContentTypes.APPLICATION_JSON);

		Message message = _hubSpotServer.executeGet(uri, headers);

		if (message.getInteger("statusCode") == HttpStatus.SC_NOT_FOUND) {
			return null;
		}

		if (message.getInteger("statusCode") != HttpStatus.SC_OK) {
			throw new HubSpotServerException(message);
		}

		return new HSFormImpl(
			JSONFactoryUtil.createJSONObject(message.getString("response")));
	}

	public List<HSForm> getAllHSForms() throws PortalException {
		String uri = HubSpotURIUtil.get("forms");
		Map<String, String> headers = getHeaders(ContentTypes.APPLICATION_JSON);

		if (!HubSpotUtil.isEnabled()) {
			return Collections.emptyList();
		}

		Message message = _hubSpotServer.executeGet(uri, headers);

		if (message.getInteger("statusCode") != HttpStatus.SC_OK) {
			throw new HubSpotServerException(message);
		}

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray(
			message.getString("response"));

		List<HSForm> hsForms = new ArrayList<HSForm>();

		for (int i = 0; i < jsonArray.length(); i++) {
			hsForms.add(new HSFormImpl(jsonArray.getJSONObject(i)));
		}

		return hsForms;
	}

	public HSForm getHSFormByGUID(String guid) throws PortalException {
		String encodedGUID = HttpUtil.encodeURL(guid, true);

		if (!HubSpotUtil.isEnabled()) {
			return null;
		}

		String uri = HubSpotURIUtil.get("forms", "forms/" + encodedGUID);
		Map<String, String> headers = getHeaders(ContentTypes.APPLICATION_JSON);

		Message message = _hubSpotServer.executeGet(uri, headers);

		if (message.getInteger("statusCode") == HttpStatus.SC_NOT_FOUND) {
			throw new NoSuchHSFormException(message);
		}

		if (message.getInteger("statusCode") != HttpStatus.SC_OK) {
			throw new HubSpotServerException(message);
		}

		return new HSFormImpl(
			JSONFactoryUtil.createJSONObject(message.getString("response")));
	}

	public HSFormDisplay getHSFormDisplay(String guid, String userToken) {
		try {
			HSContact hsContact = null;
			
			if (Validator.isNotNull(userToken)) {
				hsContact = 
					HSContactLocalServiceUtil.fetchHSContactByUserToken(userToken);
			}
			
			HSForm hsForm = fetchHSFormByGUID(guid);
			
			return new HSFormDisplayImpl(hsForm, hsContact);
		}
		catch (PortalException pe) {
			
		}
		
		return new HSFormDisplayImpl();	
	}
	
	public HSForm submitHSForm(
			String guid, String userToken, String ipAddress, String pageURL,
			String pageName, String redirectURL, String salesforceCampaignId,
			String[] fields)
		throws PortalException {

		if (!HubSpotUtil.isEnabled()) {
			return null;
		}

		if ((fields.length == 0) || ((fields.length % 2) != 0)) {
			throw new IllegalArgumentException(
				"Fields length must be an even number");
		}

		String uri = HubSpotURIUtil.getSubmitForm(guid);
		Map<String, String> headers = getHeaders(
			ContentTypes.APPLICATION_X_WWW_FORM_URLENCODED);
		Body body = getBody(
			userToken, ipAddress, pageURL, pageName, redirectURL,
			salesforceCampaignId, fields);

		if (_log.isDebugEnabled()) {
			_log.debug(
				"HubSpot form submission: " +
					HttpUtil.decodeURL(body.getContent()));
		}

		Message message = _hubSpotServer.executePost(uri, headers, body);

		if (message.getInteger("statusCode") == HttpStatus.SC_NOT_FOUND) {
			throw new NoSuchHSFormException(message);
		}

		if (!ArrayUtil.contains(
				_HTTP_STATUS_CODES_SUCCESS, message.getInteger("statusCode"))) {

			throw new HubSpotServerException(message);
		}

		return getHSFormByGUID(guid);
	}

	public HSForm submitHSForm(String guid, String[] fields)
		throws PortalException {

		return submitHSForm(guid, null, null, null, null, null, null, fields);
	}

	protected Body getBody(
		String userToken, String ipAddress, String pageURL, String pageName,
		String redirectURL, String salesforceCampaignId, String[] fields) {

		String content = StringPool.BLANK;

		for (int i = 0; i < fields.length; i += 2) {
			String fieldName = fields[i];
			String fieldValue = fields[i + 1];

			if (Validator.isNotNull(fieldName) && (fieldValue != null)) {
				fieldName = HttpUtil.encodeURL(fieldName, true);
				fieldValue = HttpUtil.encodeURL(fieldValue, true);

				if (content.equals(StringPool.BLANK)) {
					content = fieldName + "=" + fieldValue;
				}
				else {
					content = content + "&" + fieldName + "=" + fieldValue;
				}
			}
		}

		if (Validator.isNotNull(userToken) || Validator.isNotNull(ipAddress) ||
			Validator.isNotNull(pageURL) || Validator.isNotNull(pageName) ||
			Validator.isNotNull(redirectURL) ||
			Validator.isNotNull(salesforceCampaignId)) {

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			if (Validator.isNotNull(userToken)) {
				jsonObject.put("hutk", userToken);
			}

			if (Validator.isNotNull(ipAddress)) {
				jsonObject.put("ipAddress", ipAddress);
			}

			if (Validator.isNotNull(pageURL)) {
				jsonObject.put("pageUrl", pageURL);
			}

			if (Validator.isNotNull(pageName)) {
				jsonObject.put("pageName", pageName);
			}

			if (Validator.isNotNull(redirectURL)) {
				jsonObject.put("redirectUrl", redirectURL);
			}

			if (Validator.isNotNull(salesforceCampaignId)) {
				jsonObject.put("sfdcCampaignId", salesforceCampaignId);
			}

			String encodedContext = HttpUtil.encodeURL(
				jsonObject.toString(), true);

			if (content.equals(StringPool.BLANK)) {
				content = "hs_context=" + encodedContext;
			}
			else {
				content = content + "&hs_context=" + encodedContext;
			}
		}

		return new Body(content, ContentTypes.TEXT_PLAIN, StringPool.UTF8);
	}

	protected Map<String, String> getHeaders(String contentType) {
		Map<String, String> headers = new HashMap<String, String>();

		headers.put(HttpHeaders.CONTENT_TYPE, contentType);
		headers.put(HttpHeaders.USER_AGENT, "HS_Forms");

		return headers;
	}

	private static final int[] _HTTP_STATUS_CODES_SUCCESS = {
		HttpStatus.SC_MOVED_TEMPORARILY, HttpStatus.SC_NO_CONTENT
	};

	@ServiceReference(type = HubSpotServer.class)
	private HubSpotServer _hubSpotServer;

	private static Log _log = LogFactoryUtil.getLog(
		HSFormLocalServiceImpl.class);

}