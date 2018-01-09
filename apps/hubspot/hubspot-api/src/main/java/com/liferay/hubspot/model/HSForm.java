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

package com.liferay.hubspot.model;

import com.liferay.portal.kernel.json.JSONObject;

import java.io.Serializable;

import java.util.Date;

/**
 * @author Peter Shin
 */
public interface HSForm extends Serializable {

	public String getAction();

	public Date getCreateDate();

	public String getCSSClass();

	public Boolean getDeletable();

	public String getEmbeddedCode();

	public String getFollowUpId();

	public String getGUID();

	public JSONObject getHSFormJSONObject();

	public Boolean getIgnoreCurrentValues();

	public String getLeadNurturingCampaignId();

	public String getMethod();

	public String getMigratedForm();

	public Date getModifiedDate();

	public String getName();

	public String getNotifyRecipients();

	public String getPerformableHTML();

	public String getRedirect();

	public String getSubmitText();

	public void setAction(String action);

	public void setCreateDate(Date createDate);

	public void setCSSClass(String cssClass);

	public void setDeletable(Boolean deletable);

	public void setEmbeddedCode(String embeddedCode);

	public void setFollowUpId(String followUpId);

	public void setGUID(String guid);

	public void setHSFormJSONObject(JSONObject hsFormJSONObject);

	public void setIgnoreCurrentValues(Boolean ignoreCurrentValues);

	public void setLeadNurturingCampaignId(String leadNurturingCampaignId);

	public void setMethod(String method);

	public void setMigratedForm(String migratedForm);

	public void setModifiedDate(Date modifiedDate);

	public void setName(String name);

	public void setNotifyRecipients(String notifyRecipients);

	public void setPerformableHTML(String performableHTML);

	public void setRedirect(String redirect);

	public void setSubmitText(String submitText);

}