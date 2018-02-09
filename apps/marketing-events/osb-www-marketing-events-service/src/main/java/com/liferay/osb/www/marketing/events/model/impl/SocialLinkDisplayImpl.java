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

import com.liferay.osb.www.marketing.events.model.SocialLink;
import com.liferay.osb.www.marketing.events.model.SocialLinkDisplay;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Allen Ziegenfus
 */
public class SocialLinkDisplayImpl implements SocialLinkDisplay {

	public SocialLinkDisplayImpl(SocialLink socialLink) throws PortalException {
		_socialLinkTypeName = socialLink.getSocialLinkTypeName();
		_socialLinkTypeImageFileEntryURL =
			socialLink.getSocialLinkTypeImageFileEntryURL();
		_url = socialLink.getUrl();
	}

	@Override
	public String getSocialLinkTypeImageFileEntryURL() {
		return _socialLinkTypeImageFileEntryURL;
	}

	@Override
	public String getSocialLinkTypeName() {
	return _socialLinkTypeName;
	}

	@Override
	public String getURL() {return _url;
	}

	private String _socialLinkTypeImageFileEntryURL;
	private String _socialLinkTypeName;
	private String _url;

}