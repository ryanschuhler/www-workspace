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

package com.liferay.osb.www.marketing.events.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Allen Ziegenfus
 */
@ExtendedObjectClassDefinition(category = "osb-www-marketing-events")
@Meta.OCD(
	id = "com.liferay.osb.www.marketing.events.configuration.MarketingEventsConfiguration"
)
public interface MarketingEventsConfiguration {

	@Meta.AD(required = false)
	public String firebaseServerKey();

	@Meta.AD(deflt = "Marketing Events Administrator", required = false)
	public String administratorRoleName();

	@Meta.AD(deflt = "5", required = false)
	public int announcementSendInterval();

	@Meta.AD(deflt = "211933834", required = false)
	public String[] ddmStructureKeys();

	@Meta.AD(deflt = "/portlet_header_content.tmpl", required = false)
	public String portletHeaderContent();

	@Meta.AD(
		deflt = "Marketing Event Session Topics|Marketing Event Session Tracks|Marketing Event Session Types",
		required = false
	)
	public String[] sessionVocabularyNames();

}