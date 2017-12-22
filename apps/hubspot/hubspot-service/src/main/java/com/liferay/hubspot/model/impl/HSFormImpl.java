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

import com.liferay.hubspot.model.HSForm;
import com.liferay.hubspot.model.HSFormConstants;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.DateUtil;

import java.util.Date;

/**
 * @author Peter Shin
 */
public class HSFormImpl implements HSForm {

	public HSFormImpl(JSONObject hsFormJSONObject) {
		setAction(hsFormJSONObject.getString(HSFormConstants.KEY_ACTION));
		setCSSClass(hsFormJSONObject.getString(HSFormConstants.KEY_CSS_CLASS));
		setCreateDate(
			DateUtil.newDate(
				hsFormJSONObject.getLong(HSFormConstants.KEY_CREATE_DATE)));
		setDeletable(
			hsFormJSONObject.getBoolean(HSFormConstants.KEY_DELETABLE));
		setEmbeddedCode(
			hsFormJSONObject.getString(HSFormConstants.KEY_EMBEDDED_CODE));
		setFollowUpId(
			hsFormJSONObject.getString(HSFormConstants.KEY_FOLLOW_UP_ID));
		setGUID(hsFormJSONObject.getString(HSFormConstants.KEY_GUID));
		setHSFormJSONObject(hsFormJSONObject);
		setIgnoreCurrentValues(
			hsFormJSONObject.getBoolean(
				HSFormConstants.KEY_IGNORE_CURRENT_VALUES));
		setLeadNurturingCampaignId(
			hsFormJSONObject.getString(
				HSFormConstants.KEY_LEAD_NURTURING_CAMPAIGN_ID));
		setMethod(hsFormJSONObject.getString(HSFormConstants.KEY_METHOD));
		setMigratedForm(
			hsFormJSONObject.getString(HSFormConstants.KEY_MIGRATED_FORM));
		setModifiedDate(
			DateUtil.newDate(
				hsFormJSONObject.getLong(HSFormConstants.KEY_MODIFIED_DATE)));
		setName(hsFormJSONObject.getString(HSFormConstants.KEY_NAME));
		setNotifyRecipients(
			hsFormJSONObject.getString(HSFormConstants.KEY_NOTIFY_RECIPIENTS));
		setPerformableHTML(
			hsFormJSONObject.getString(HSFormConstants.KEY_PERFORMABLE_HTML));
		setRedirect(hsFormJSONObject.getString(HSFormConstants.KEY_REDIRECT));
		setSubmitText(
			hsFormJSONObject.getString(HSFormConstants.KEY_SUBMIT_TEXT));
	}

	public HSFormImpl(
		String guid, String name, String action, String method, String cssClass,
		String redirect, String submitText, String followUpId,
		String notifyRecipients, String leadNurturingCampaignId,
		Date createDate, Date modifiedDate, String performableHTML,
		String migratedForm, Boolean ignoreCurrentValues, Boolean deletable,
		String embeddedCode, JSONObject hsFormJSONObject) {

		_action = action;
		_cssClass = cssClass;
		_createDate = createDate;
		_deletable = deletable;
		_embeddedCode = embeddedCode;
		_followUpId = followUpId;
		_guid = guid;
		_hsFormJSONObject = hsFormJSONObject;
		_ignoreCurrentValues = ignoreCurrentValues;
		_leadNurturingCampaignId = leadNurturingCampaignId;
		_method = method;
		_migratedForm = migratedForm;
		_modifiedDate = modifiedDate;
		_name = name;
		_notifyRecipients = notifyRecipients;
		_performableHTML = performableHTML;
		_redirect = redirect;
		_submitText = submitText;
	}

	@Override
	public String getAction() {
		return _action;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public String getCSSClass() {
		return _cssClass;
	}

	@Override
	public Boolean getDeletable() {
		return _deletable;
	}

	@Override
	public String getEmbeddedCode() {
		return _embeddedCode;
	}

	@Override
	public String getFollowUpId() {
		return _followUpId;
	}

	@Override
	public String getGUID() {
		return _guid;
	}

	@Override
	public JSONObject getHSFormJSONObject() {
		return _hsFormJSONObject;
	}

	@Override
	public Boolean getIgnoreCurrentValues() {
		return _ignoreCurrentValues;
	}

	@Override
	public String getLeadNurturingCampaignId() {
		return _leadNurturingCampaignId;
	}

	@Override
	public String getMethod() {
		return _method;
	}

	@Override
	public String getMigratedForm() {
		return _migratedForm;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public String getNotifyRecipients() {
		return _notifyRecipients;
	}

	@Override
	public String getPerformableHTML() {
		return _performableHTML;
	}

	@Override
	public String getRedirect() {
		return _redirect;
	}

	@Override
	public String getSubmitText() {
		return _submitText;
	}

	@Override
	public void setAction(String action) {
		_action = action;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public void setCSSClass(String cssClass) {
		_cssClass = cssClass;
	}

	@Override
	public void setDeletable(Boolean deletable) {
		_deletable = deletable;
	}

	@Override
	public void setEmbeddedCode(String embeddedCode) {
		_embeddedCode = embeddedCode;
	}

	@Override
	public void setFollowUpId(String followUpId) {
		_followUpId = followUpId;
	}

	@Override
	public void setGUID(String guid) {
		_guid = guid;
	}

	@Override
	public void setHSFormJSONObject(JSONObject hsFormJSONObject) {
		_hsFormJSONObject = hsFormJSONObject;
	}

	@Override
	public void setIgnoreCurrentValues(Boolean ignoreCurrentValues) {
		_ignoreCurrentValues = ignoreCurrentValues;
	}

	@Override
	public void setLeadNurturingCampaignId(String leadNurturingCampaignId) {
		_leadNurturingCampaignId = leadNurturingCampaignId;
	}

	@Override
	public void setMethod(String method) {
		_method = method;
	}

	@Override
	public void setMigratedForm(String migratedForm) {
		_migratedForm = migratedForm;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public void setNotifyRecipients(String notifyRecipients) {
		_notifyRecipients = notifyRecipients;
	}

	@Override
	public void setPerformableHTML(String performableHTML) {
		_performableHTML = performableHTML;
	}

	@Override
	public void setRedirect(String redirect) {
		_redirect = redirect;
	}

	@Override
	public void setSubmitText(String submitText) {
		_submitText = submitText;
	}

	private String _action;
	private Date _createDate;
	private String _cssClass;
	private Boolean _deletable;
	private String _embeddedCode;
	private String _followUpId;
	private String _guid;
	private JSONObject _hsFormJSONObject;
	private Boolean _ignoreCurrentValues;
	private String _leadNurturingCampaignId;
	private String _method;
	private String _migratedForm;
	private Date _modifiedDate;
	private String _name;
	private String _notifyRecipients;
	private String _performableHTML;
	private String _redirect;
	private String _submitText;

}