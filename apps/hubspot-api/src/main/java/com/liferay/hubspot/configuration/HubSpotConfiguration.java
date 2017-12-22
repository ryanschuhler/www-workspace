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
package com.liferay.hubspot.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Joan H. Kim
 */

@ExtendedObjectClassDefinition(category = "webteam-woo")
@Meta.OCD(id = "com.liferay.hubspot.configuration.HubSpotConfiguration")
public interface HubSpotConfiguration {

	@Meta.AD(id = "dossiera.database.host", required = true)
	public String dossieraDatabaeHost();

	@Meta.AD(id = "dossiera.database.name", required = true)
	public String dossieraDatabaseName();

	@Meta.AD(id = "dossiera.database.password", required = true)
	public String dossieraDatabasePassword();
	
	@Meta.AD(id = "dossiera.database.user", required = true)
	public String dossieraDatabaseUser();
	
	@Meta.AD(id = "http.client.max.connections.per.host", required = true)
	public String httpClientMaxConnectionPerHost();
	
	@Meta.AD(id = "http.client.max.total.connections", required = true)
	public String httpClientMaxTotalConnections();
	
	@Meta.AD(id = "http.client.timeout", required = true)
	public String httpClientTimeout();
	
	@Meta.AD(id = "hubspot.api.domain", required = true)
	public String hubspotApiDomain();

	@Meta.AD(id = "hubspot.api.version", required = true)
	public String hubspotApiVersion();
	
	@Meta.AD(id = "hubspot.forms.domain", required = true)
	public String hubspotFormsDomain();
	
	@Meta.AD(id = "hubspot.forms.subdomain", required = true)
	public String hubspotFormsSubdomain();
	
	@Meta.AD(id = "hubspot.forms.version", required = true)
	public String hubspotFormsVersion();
	
	@Meta.AD(id = "hubspot.renewal.country.codes", required = true)
	public String hubspotRenewalCountryCodes();
	
	@Meta.AD(id = "hubspot.renewal.days.interval", required = true)
	public String hubspotRenewalDaysInterval();
	
	@Meta.AD(id = "hubspot.renewal.email", required = true)
	public String hubspotRenewalEmail();
	
	@Meta.AD(id = "hubspot.renewal.language.ids", required = true)
	public String hubspotRenewalLanguageIds();

	@Meta.AD(id = "hubspot.renewal.subject", required = true)
	public String hubspotRenewalSubject();

	@Meta.AD(id = "hubspot.renewal.template.id", required = true)
	public String hubspotRenewalTemplateId();

	@Meta.AD(id = "hubspot.renewal.user.id", required = true)
	public String hubspotRenewalUserId();

	@Meta.AD(id = "hubspot.settings.hapikey", required = true)
	public String hubspotSettingsHapikey();

	@Meta.AD(id = "hubspot.settings.portal.id", required = true)
	public String hubspotSettingsPortalId();

	@Meta.AD(id = "hubspot.vid.sync.interval", required = true)
	public String hubspotVidSyncInterval();

	@Meta.AD(id = "hubspot.vid.sync.max.results", required = true)
	public String hubspotVidSyncResults();

}