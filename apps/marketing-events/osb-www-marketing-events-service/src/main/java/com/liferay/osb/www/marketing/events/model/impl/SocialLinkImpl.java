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

package com.liferay.osb.www.marketing.events.model.impl;

import com.liferay.osb.www.marketing.events.model.SocialLinkType;
import com.liferay.osb.www.marketing.events.service.SocialLinkTypeLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;

/**
 * @author Allen Ziegenfus
 */
public class SocialLinkImpl extends SocialLinkBaseImpl {

	public SocialLinkImpl() {
	}

	public SocialLinkType getSocialLinkType() throws PortalException {
		return SocialLinkTypeLocalServiceUtil.getSocialLinkType(
			getSocialLinkTypeId());
	}

	@JSON
	public String getSocialLinkTypeImageFileEntryURL() throws PortalException {
		return getSocialLinkType().getImageFileEntryURL();
	}

	@JSON
	public String getSocialLinkTypeName() throws PortalException {
		return getSocialLinkType().getName();
	}

}