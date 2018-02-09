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

package com.liferay.osb.www.marketing.events.model;

import java.io.Serializable;

import java.util.List;

/**
 * @author Allen Ziegenfus
 */
public interface MarketingEventUserDisplay extends Serializable {

	public String getCompanyLogoFileEntryURL();

	public String getCompanyName();

	public String getDescription();

	public String getFullName();

	public String getImageFileEntryURL();

	public String getJobTitle();

	public List<SocialLinkDisplay> getSocialLinkDisplays();

	public boolean hasCompanyLogo();

	public boolean hasCompanyName();

	public boolean hasJobTitle();

	public boolean isKeynoteSpeaker();

}