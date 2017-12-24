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

import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.hubspot.exception.HubSpotServerException;
import com.liferay.hubspot.exception.NoSuchHSContactException;
import com.liferay.hubspot.converter.DropDownValueConverter;
import com.liferay.hubspot.model.HSContact;
import com.liferay.hubspot.model.HSContactCache;
import com.liferay.hubspot.model.HSContactCacheConstants;
import com.liferay.hubspot.model.HSContactConstants;
import com.liferay.hubspot.model.impl.HSContactCacheImpl;
import com.liferay.hubspot.model.impl.HSContactImpl;
import com.liferay.hubspot.server.HubSpotServer;
import com.liferay.hubspot.server.HubSpotServer;
import com.liferay.hubspot.service.base.HSContactLocalServiceBaseImpl;
import com.liferay.hubspot.util.HubSpotURIUtil;
import com.liferay.hubspot.util.HubSpotUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Http.Body;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpStatus;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Peter Shin
 */
public class HSContactLocalServiceImpl extends HSContactLocalServiceBaseImpl {

	@Override
	public HSContact addHSContact(
			long companyId, String className, long classPK, String emailAddress,
			String firstName, String lastName, String phoneNumber,
			String street, String city, String region, String postalCode,
			String country, String jobTitle, String twitterUserName,
			String websiteURL, String notes, String lifeCycleStage,
			String persona, String sfLeadCountry, String sfLeadIndustry,
			String sfLeadCompany, String sfLeadDepartment, String sfLeadRole,
			String sfLeadSource)
		throws PortalException, SystemException {

		if (!HubSpotUtil.isEnabled()) {
			return null;
		}

		String uri = HubSpotURIUtil.get("contact");
		Map<String, String> headers = getHeaders(ContentTypes.APPLICATION_JSON);
		Body body = getBody(
			emailAddress, firstName, lastName, phoneNumber, street, city,
			region, postalCode, country, jobTitle, twitterUserName, websiteURL,
			notes, lifeCycleStage, persona, sfLeadCountry, sfLeadIndustry,
			sfLeadCompany, sfLeadDepartment, sfLeadRole, sfLeadSource,
			new HSContactImpl());

		Message message = _hubSpotServer.executePost(uri, headers, body);

		if (message.getInteger("statusCode") != HttpStatus.SC_OK) {
			throw new HubSpotServerException(message);
		}

		HSContact hsContact = getHSContactByEmailAddress(emailAddress);

		return updateHSContactCache(companyId, className, classPK, hsContact);
	}

	@Override
	public void deleteHSContact(long companyId, long userId, long visitorId)
		throws PortalException, SystemException {

		if (!HubSpotUtil.isEnabled()) {
			return;
		}

		String uri = HubSpotURIUtil.get("contact/vid/" + visitorId);
		Map<String, String> headers = getHeaders(ContentTypes.APPLICATION_JSON);

		Message message = _hubSpotServer.executeDelete(uri, headers);

		if (message.getInteger("statusCode") == HttpStatus.SC_NOT_FOUND) {
			throw new NoSuchHSContactException(message);
		}

		if (message.getInteger("statusCode") != HttpStatus.SC_OK) {
			throw new HubSpotServerException(message);
		}

		expandoValueLocalService.deleteValue(
			companyId, User.class.getName(),
			HSContactCacheConstants.EXPANDO_TABLE_NAME,
			HSContactCacheConstants.EXPANDO_COLUMN_NAME, userId);
	}

	@Override
	public HSContact fetchHSContactByEmailAddress(String emailAddress)
		throws PortalException {

		if (!HubSpotUtil.isEnabled()) {
			return null;
		}

		Message message = getMessageByEmailAddress(emailAddress);

		if (message.getInteger("statusCode") == HttpStatus.SC_NOT_FOUND) {
			return null;
		}

		if (message.getInteger("statusCode") != HttpStatus.SC_OK) {
			throw new HubSpotServerException(message);
		}

		return new HSContactImpl(
			JSONFactoryUtil.createJSONObject(message.getString("response")));
	}

	@Override
	public HSContact fetchHSContactByUserToken(String userToken)
		throws PortalException {

		if (!HubSpotUtil.isEnabled()) {
			return null;
		}

		Message message = getMessageByUserToken(userToken);

		if (message.getInteger("statusCode") == HttpStatus.SC_NOT_FOUND) {
			return null;
		}

		if (message.getInteger("statusCode") != HttpStatus.SC_OK) {
			throw new HubSpotServerException(message);
		}

		return new HSContactImpl(
			JSONFactoryUtil.createJSONObject(message.getString("response")));
	}

	@Override
	public HSContact fetchHSContactByVisitorId(long visitorId)
		throws PortalException {

		if (!HubSpotUtil.isEnabled()) {
			return null;
		}

		Message message = getMessageByVisitorId(visitorId);

		if (message.getInteger("statusCode") == HttpStatus.SC_NOT_FOUND) {
			return null;
		}

		if (message.getInteger("statusCode") != HttpStatus.SC_OK) {
			throw new HubSpotServerException(message);
		}

		return new HSContactImpl(
			JSONFactoryUtil.createJSONObject(message.getString("response")));
	}

	@Override
	public Message getAllHSContactSummaries(int contactOffset, int count)
		throws PortalException {

		if (!HubSpotUtil.isEnabled()) {
			return new Message();
		}

		String uri = HubSpotURIUtil.get("lists/all/contacts/all");
		Map<String, String> headers = getHeaders(ContentTypes.APPLICATION_JSON);

		Map<String, String> parameters = new HashMap<String, String>();

		parameters.put("count", String.valueOf(count));
		parameters.put("vidOffset", String.valueOf(contactOffset));

		Message message = _hubSpotServer.executeGet(
			uri, headers, parameters);

		if (message.getInteger("statusCode") != HttpStatus.SC_OK) {
			throw new HubSpotServerException(message);
		}

		Message hsContactsMessage = new Message();

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
			message.getString("response"));

		hsContactsMessage.put("contactOffset", jsonObject.getInt("vid-offset"));
		hsContactsMessage.put("hasMore", jsonObject.getBoolean("has-more"));

		hsContactsMessage.setPayload(getHSContacts(jsonObject));

		return hsContactsMessage;
	}

	@Override
	public HSContact getHSContactByEmailAddress(String emailAddress)
		throws PortalException {

		if (!HubSpotUtil.isEnabled()) {
			return null;
		}

		Message message = getMessageByEmailAddress(emailAddress);

		if (message.getInteger("statusCode") == HttpStatus.SC_NOT_FOUND) {
			throw new NoSuchHSContactException(message);
		}

		if (message.getInteger("statusCode") != HttpStatus.SC_OK) {
			throw new HubSpotServerException(message);
		}

		return new HSContactImpl(
			JSONFactoryUtil.createJSONObject(message.getString("response")));
	}

	@Override
	public HSContact getHSContactByUserToken(String userToken)
		throws PortalException {

		if (!HubSpotUtil.isEnabled()) {
			return null;
		}

		Message message = getMessageByUserToken(userToken);

		if (message.getInteger("statusCode") == HttpStatus.SC_NOT_FOUND) {
			throw new NoSuchHSContactException(message);
		}

		if (message.getInteger("statusCode") != HttpStatus.SC_OK) {
			throw new HubSpotServerException(message);
		}

		return new HSContactImpl(
			JSONFactoryUtil.createJSONObject(message.getString("response")));
	}

	@Override
	public HSContact getHSContactByVisitorId(long visitorId)
		throws PortalException {

		if (!HubSpotUtil.isEnabled()) {
			return null;
		}

		Message message = getMessageByVisitorId(visitorId);

		if (message.getInteger("statusCode") == HttpStatus.SC_NOT_FOUND) {
			throw new NoSuchHSContactException(message);
		}

		if (message.getInteger("statusCode") != HttpStatus.SC_OK) {
			throw new HubSpotServerException(message);
		}

		return new HSContactImpl(
			JSONFactoryUtil.createJSONObject(message.getString("response")));
	}

	@Override
	public Message getRecentHSContactSummaries(
			int contactOffset, int timeOffset, int count)
		throws PortalException {

		if (!HubSpotUtil.isEnabled()) {
			return new Message();
		}

		String uri = HubSpotURIUtil.get(
			"lists/recently_updated/contacts/recent");
		Map<String, String> headers = getHeaders(ContentTypes.APPLICATION_JSON);

		Map<String, String> parameters = new HashMap<String, String>();

		parameters.put("count", String.valueOf(count));

		if ((contactOffset > 0) && (timeOffset > 0)) {
			parameters.put("timeOffset", String.valueOf(timeOffset));
			parameters.put("vidOffset", String.valueOf(contactOffset));
		}

		Message message = _hubSpotServer.executeGet(
			uri, headers, parameters);

		if (message.getInteger("statusCode") != HttpStatus.SC_OK) {
			throw new HubSpotServerException(message);
		}

		Message hsContactsMessage = new Message();

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
			message.getString("response"));

		hsContactsMessage.put("contactOffset", jsonObject.getInt("vid-offset"));
		hsContactsMessage.put("hasMore", jsonObject.getBoolean("has-more"));
		hsContactsMessage.put("timeOffset", jsonObject.getInt("time-offset"));

		hsContactsMessage.setPayload(getHSContacts(jsonObject));

		return hsContactsMessage;
	}

	@Override
	public Message search(String query, int offset, int count)
		throws PortalException {

		if (!HubSpotUtil.isEnabled()) {
			return new Message();
		}

		String uri = HubSpotURIUtil.get("search/query");
		Map<String, String> headers = getHeaders(ContentTypes.APPLICATION_JSON);

		Map<String, String> parameters = new HashMap<String, String>();

		parameters.put("count", String.valueOf(count));
		parameters.put("offset", String.valueOf(offset));
		parameters.put("q", query);

		Message message = _hubSpotServer.executeGet(
			uri, headers, parameters);

		if (message.getInteger("statusCode") != HttpStatus.SC_OK) {
			throw new HubSpotServerException(message);
		}

		Message hsContactsMessage = new Message();

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
			message.getString("response"));

		hsContactsMessage.put("hasMore", jsonObject.getBoolean("has-more"));
		hsContactsMessage.put("offset", jsonObject.getInt("offset"));

		hsContactsMessage.setPayload(getHSContacts(jsonObject));

		return hsContactsMessage;
	}

	@Override
	public HSContact updateHSContact(
			long companyId, String className, long classPK, long visitorId,
			String firstName, String lastName, String phoneNumber,
			String street, String city, String region, String postalCode,
			String country, String jobTitle, String twitterUserName,
			String websiteURL, String persona)
		throws PortalException, SystemException {

		String emailAddress = null;
		String notes = null;
		String lifeCycleStage = null;
		String sfLeadCountry = null;
		String sfLeadIndustry = null;
		String sfLeadCompany = null;
		String sfLeadDepartment = null;
		String sfLeadRole = null;
		String sfLeadSource = null;

		return updateHSContact(
			companyId, className, classPK, visitorId, emailAddress, firstName,
			lastName, phoneNumber, street, city, region, postalCode, country,
			jobTitle, twitterUserName, websiteURL, notes, lifeCycleStage,
			persona, sfLeadCountry, sfLeadIndustry, sfLeadCompany,
			sfLeadDepartment, sfLeadRole, sfLeadSource);
	}

	@Override
	public HSContact updateHSContact(
			long companyId, String className, long classPK, long visitorId,
			String emailAddress, String firstName, String lastName,
			String phoneNumber, String street, String city, String region,
			String postalCode, String country, String jobTitle,
			String twitterUserName, String websiteURL, String notes,
			String lifeCycleStage, String persona, String sfLeadCountry,
			String sfLeadIndustry, String sfLeadCompany,
			String sfLeadDepartment, String sfLeadRole, String sfLeadSource)
		throws PortalException, SystemException {

		if (!HubSpotUtil.isEnabled()) {
			return null;
		}

		HSContact hsContact = getHSContactByVisitorId(visitorId);

		String uri = HubSpotURIUtil.get(
			"contact/vid/" + visitorId + "/profile");
		Map<String, String> headers = getHeaders(ContentTypes.APPLICATION_JSON);
		Body body = getBody(
			emailAddress, firstName, lastName, phoneNumber, street, city,
			region, postalCode, country, jobTitle, twitterUserName, websiteURL,
			notes, lifeCycleStage, persona, sfLeadCountry, sfLeadIndustry,
			sfLeadCompany, sfLeadDepartment, sfLeadRole, sfLeadSource,
			hsContact);

		Message message = _hubSpotServer.executePost(uri, headers, body);

		if (message.getInteger("statusCode") == HttpStatus.SC_NOT_FOUND) {
			throw new NoSuchHSContactException(message);
		}

		if (message.getInteger("statusCode") != HttpStatus.SC_NO_CONTENT) {
			throw new HubSpotServerException(message);
		}

		hsContact = getHSContactByVisitorId(visitorId);

		return updateHSContactCache(companyId, className, classPK, hsContact);
	}

	protected Body getBody(
		String emailAddress, String firstName, String lastName,
		String phoneNumber, String street, String city, String region,
		String postalCode, String country, String jobTitle,
		String twitterUserName, String websiteURL, String notes,
		String lifeCycleStage, String persona, String sfLeadCountry,
		String sfLeadIndustry, String sfLeadCompany, String sfLeadDepartment,
		String sfLeadRole, String sfLeadSource, HSContact hsContact) {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		// HubSpot's fields that are owned by HubSpot smart forms

		jsonArray = processProperty(
			HSContactConstants.PROPERTY_EMAIL_ADDRESS, emailAddress,
			hsContact.getEmailAddress(), hsContact, true, jsonArray);

		jsonArray = processProperty(
			HSContactConstants.PROPERTY_FIRST_NAME, firstName,
			hsContact.getFirstName(), hsContact, true, jsonArray);

		jsonArray = processProperty(
			HSContactConstants.PROPERTY_LAST_NAME, lastName,
			hsContact.getLastName(), hsContact, true, jsonArray);

		jsonArray = processProperty(
			HSContactConstants.PROPERTY_PHONE_NUMBER, phoneNumber,
			hsContact.getPhoneNumber(), hsContact, true, jsonArray);

		jsonArray = processAddress(
			street, city, region, postalCode, country, hsContact, jsonArray);

		jsonArray = processProperty(
			HSContactConstants.PROPERTY_JOB_TITLE, jobTitle,
			hsContact.getJobTitle(), hsContact, true, jsonArray);

		jsonArray = processProperty(
			HSContactConstants.PROPERTY_TWITTER_USERNAME, twitterUserName,
			hsContact.getTwitterUserName(), hsContact, true, jsonArray);

		jsonArray = processProperty(
			HSContactConstants.PROPERTY_WEBSITE_URL, websiteURL,
			hsContact.getWebsiteURL(), hsContact, true, jsonArray);

		jsonArray = processProperty(
			HSContactConstants.PROPERTY_NOTES, notes, hsContact.getNotes(),
			hsContact, true, jsonArray);

		jsonArray = processProperty(
			HSContactConstants.PROPERTY_LIFE_CYCLE_STAGE, lifeCycleStage,
			hsContact.getLifeCycleStage(), hsContact, true, jsonArray);

		jsonArray = processProperty(
			HSContactConstants.PROPERTY_PERSONA, persona,
			hsContact.getPersona(), hsContact, true, jsonArray);

		// HubSpot's salesforce.com fields that are owned by by liferay.com

		if (Validator.isNull(hsContact.getSFLeadCountry()) &&
			Validator.isNotNull(sfLeadCountry)) {

			jsonArray = processProperty(
				HSContactConstants.PROPERTY_SF_LEAD_COUNTRY,
				DropDownValueConverter.getSFLeadCountry(sfLeadCountry),
				hsContact.getSFLeadCountry(), hsContact, false, jsonArray);
		}

		if (Validator.isNotNull(sfLeadIndustry)) {
			jsonArray = processProperty(
				HSContactConstants.PROPERTY_SF_LEAD_INDUSTRY,
				DropDownValueConverter.getSFLeadIndustry(sfLeadIndustry),
				hsContact.getSFLeadIndustry(), hsContact, false, jsonArray);
		}

		if (Validator.isNotNull(sfLeadCompany)) {
			jsonArray = processProperty(
				HSContactConstants.PROPERTY_SF_LEAD_COMPANY, sfLeadCompany,
				hsContact.getSFLeadCompany(), hsContact, false, jsonArray);
		}

		if (Validator.isNotNull(sfLeadDepartment)) {
			jsonArray = processProperty(
				HSContactConstants.PROPERTY_SF_LEAD_DEPARTMENT,
				DropDownValueConverter.getSFLeadDepartment(sfLeadDepartment),
				hsContact.getSFLeadDepartment(), hsContact, false, jsonArray);
		}

		if (Validator.isNotNull(sfLeadRole)) {
			jsonArray = processProperty(
				HSContactConstants.PROPERTY_SF_LEAD_ROLE,
				DropDownValueConverter.getSFLeadRole(sfLeadRole),
				hsContact.getSFLeadRole(), hsContact, false, jsonArray);
		}

		if (Validator.isNotNull(sfLeadSource)) {
			jsonArray = processProperty(
				HSContactConstants.PROPERTY_SF_LEAD_SOURCE, sfLeadSource,
				hsContact.getSFLeadSource(), hsContact, true, jsonArray);
		}

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("properties", jsonArray);

		return new Body(
			jsonObject.toString(), ContentTypes.APPLICATION_JSON,
			StringPool.UTF8);
	}

	protected Map<String, String> getHeaders(String contentType) {
		Map<String, String> headers = new HashMap<String, String>();

		headers.put(HttpHeaders.CONTENT_TYPE, contentType);
		headers.put(HttpHeaders.USER_AGENT, "HS_Contacts");

		return headers;
	}

	protected List<HSContact> getHSContacts(JSONObject jsonObject) {
		JSONArray contactsJSONArray = jsonObject.getJSONArray("contacts");

		List<HSContact> hsContacts = new ArrayList<HSContact>();

		for (int i = 0; i < contactsJSONArray.length(); i++) {
			JSONObject contactJSONObject = contactsJSONArray.getJSONObject(i);

			hsContacts.add(new HSContactImpl(contactJSONObject));
		}

		return hsContacts;
	}

	protected Message getMessageByEmailAddress(String emailAddress)
		throws PortalException {

		String encodedEmailAddress = HttpUtil.encodeURL(emailAddress, true);

		String uri = HubSpotURIUtil.get(
			"contact/email/" + encodedEmailAddress + "/profile");
		Map<String, String> headers = getHeaders(ContentTypes.APPLICATION_JSON);

		return _hubSpotServer.executeGet(uri, headers);
	}

	protected Message getMessageByUserToken(String userToken)
		throws PortalException {

		String encodedUserToken = HttpUtil.encodeURL(userToken, true);

		String uri = HubSpotURIUtil.get(
			"contact/utk/" + encodedUserToken + "/profile");
		Map<String, String> headers = getHeaders(ContentTypes.APPLICATION_JSON);

		return _hubSpotServer.executeGet(uri, headers);
	}

	protected Message getMessageByVisitorId(long visitorId)
		throws PortalException {

		String uri = HubSpotURIUtil.get(
			"contact/vid/" + visitorId + "/profile");
		Map<String, String> headers = getHeaders(ContentTypes.APPLICATION_JSON);

		return _hubSpotServer.executeGet(uri, headers);
	}

	protected JSONArray processAddress(
		String street, String city, String region, String postalCode,
		String country, HSContact hsContact, JSONArray jsonArray) {

		if (Validator.isNotNull(hsContact.getStreet()) ||
			Validator.isNotNull(hsContact.getCity()) ||
			Validator.isNotNull(hsContact.getRegion()) ||
			Validator.isNotNull(hsContact.getPostalCode()) ||
			Validator.isNotNull(hsContact.getCountry())) {

			return jsonArray;
		}

		if (Validator.isNull(street) && Validator.isNull(city) &&
			Validator.isNull(region) && Validator.isNull(postalCode) &&
			Validator.isNull(country)) {

			return jsonArray;
		}

		jsonArray = processProperty(
			HSContactConstants.PROPERTY_STREET, GetterUtil.getString(street),
			null, null, false, jsonArray);

		jsonArray = processProperty(
			HSContactConstants.PROPERTY_CITY, GetterUtil.getString(city), null,
			null, false, jsonArray);

		jsonArray = processProperty(
			HSContactConstants.PROPERTY_REGION, GetterUtil.getString(region),
			null, null, false, jsonArray);

		jsonArray = processProperty(
			HSContactConstants.PROPERTY_POSTAL_CODE,
			GetterUtil.getString(postalCode), null, null, false, jsonArray);

		jsonArray = processProperty(
			HSContactConstants.PROPERTY_COUNTRY, GetterUtil.getString(country),
			null, null, false, jsonArray);

		return jsonArray;
	}

	protected JSONArray processProperty(
		String name, Object value, Object hsValue, HSContact hsContact,
		boolean hsValueHasPrecedence, JSONArray jsonArray) {

		if (!requiresUpdate(value, hsValue, hsContact, hsValueHasPrecedence)) {
			return jsonArray;
		}

		if (value instanceof Boolean) {
			Boolean valueBoolean = (Boolean)value;

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			jsonObject.put("property", name);
			jsonObject.put("value", valueBoolean);

			jsonArray.put(jsonObject);
		}
		else if (value instanceof Date) {
			Date valueDate = (Date)value;

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			jsonObject.put("property", name);
			jsonObject.put("value", valueDate.getTime());

			jsonArray.put(jsonObject);
		}
		else if (value instanceof Integer) {
			Integer valueInteger = (Integer)value;

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			jsonObject.put("property", name);
			jsonObject.put("value", valueInteger);

			jsonArray.put(jsonObject);
		}
		else if (value instanceof Long) {
			Long valueLong = (Long)value;

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			jsonObject.put("property", name);
			jsonObject.put("value", valueLong);

			jsonArray.put(jsonObject);
		}
		else if (value instanceof String) {
			String valueString = (String)value;

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			jsonObject.put("property", name);
			jsonObject.put("value", valueString);

			jsonArray.put(jsonObject);
		}

		return jsonArray;
	}

	protected boolean requiresUpdate(long[] value, long[] hsValue) {
		if (value == null) {
			return false;
		}

		if (hsValue == null) {
			return true;
		}

		List<Long> valueLongList = ListUtil.toList(value);
		List<Long> hsValueLongList = ListUtil.toList(hsValue);

		valueLongList = ListUtil.sort(valueLongList);
		hsValueLongList = ListUtil.sort(hsValueLongList);

		return !valueLongList.equals(hsValueLongList);
	}

	protected boolean requiresUpdate(
		Object value, Object hsValue, HSContact hsContact,
		boolean hsValueHasPrecedence) {

		if (hsValueHasPrecedence && (hsContact != null) && (hsValue != null) &&
			GetterUtil.getLong(hsContact.getVisitorId()) > 0) {

			return false;
		}

		if (value == null) {
			return false;
		}

		if (hsValue == null) {
			return true;
		}

		if ((value instanceof Boolean) && (hsValue instanceof Boolean)) {
			Boolean valueBoolean = (Boolean)value;
			Boolean hsValueBoolean = (Boolean)hsValue;

			if (valueBoolean == hsValueBoolean) {
				return false;
			}
		}
		else if ((value instanceof Date) && (hsValue instanceof Date)) {
			Date valueDate = (Date)value;
			Date hsValueDate = (Date)hsValue;

			if (DateUtil.getDaysBetween(valueDate, hsValueDate) == 0) {
				return false;
			}
		}
		else if ((value instanceof Integer) && (hsValue instanceof Integer)) {
			Integer valueInteger = (Integer)value;
			Integer hsValueInteger = (Integer)hsValue;

			if (valueInteger == hsValueInteger) {
				return false;
			}
		}
		else if ((value instanceof Long) && (hsValue instanceof Long)) {
			Long valueLong = (Long)value;
			Long hsValueLong = (Long)hsValue;

			if (valueLong == hsValueLong) {
				return false;
			}
		}
		else if ((value instanceof String) && (hsValue instanceof String)) {
			String valueString = (String)value;
			String hsValueString = (String)hsValue;

			if (valueString.equals(hsValueString)) {
				return false;
			}
		}

		return true;
	}

	protected HSContact updateHSContactCache(
			long companyId, String className, long classPK, HSContact hsContact)
		throws PortalException, SystemException {

		if (Validator.equals(className, User.class.getName())) {
			HSContactCache hsContactCache = new HSContactCacheImpl(hsContact);

			expandoValueLocalService.addValue(
				companyId, User.class.getName(),
				HSContactCacheConstants.EXPANDO_TABLE_NAME,
				HSContactCacheConstants.EXPANDO_COLUMN_NAME, classPK,
				hsContactCache.toString());
		}

		return hsContact;
	}

	@ServiceReference(type = HubSpotServer.class)
	private HubSpotServer _hubSpotServer;

}