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

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.osb.www.marketing.events.model.MarketingEventUser;
import com.liferay.osb.www.marketing.events.model.MarketingEventUserDisplay;
import com.liferay.osb.www.marketing.events.model.SocialLink;
import com.liferay.osb.www.marketing.events.model.SocialLinkDisplay;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Allen Ziegenfus
 */
public class MarketingEventUserDisplayImpl
	implements MarketingEventUserDisplay {

	public MarketingEventUserDisplayImpl(
			MarketingEventUser marketingEventUser, String languageId)
		throws PortalException {

		_companyLogoFileEntryURL =
			marketingEventUser.getCompanyLogoFileEntryURL();
		_companyName = marketingEventUser.getCompanyName();
		_description = marketingEventUser.getDescription(languageId);
		_fullName = marketingEventUser.getFullName();
		_imageFileEntryURL = marketingEventUser.getImageFileEntryURL();
		_jobTitle = marketingEventUser.getJobTitle(languageId);

		for (SocialLink socialLink : marketingEventUser.getSocialLinks()) {
			SocialLinkDisplay socialLinkDisplay = new SocialLinkDisplayImpl(
				socialLink);

			_socialLinkDisplays.add(socialLinkDisplay);
		}

		_hasCompanyLogo = marketingEventUser.getCompanyLogoFileEntryId() != 0;
		_hasCompanyName = Validator.isNotNull(_companyName);
		_hasJobTitle = Validator.isNotNull(_jobTitle);

		_keynoteSpeaker = false;
		List<AssetCategory> assetCategories =
			marketingEventUser.getAssetCategories();

		for (AssetCategory assetCategory : assetCategories) {
			if (StringUtil.containsIgnoreCase(
					assetCategory.getName(), "Keynote")) {

				_keynoteSpeaker = true;
			}
		}
	}

	@Override
	public String getCompanyLogoFileEntryURL() {
		return _companyLogoFileEntryURL;
	}

	@Override
	public String getCompanyName() {
		return _companyName;
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public String getFullName() {
		return _fullName;
	}

	@Override
	public String getImageFileEntryURL() {
		return _imageFileEntryURL;
	}

	@Override
	public String getJobTitle() {
		return _jobTitle;
	}

	@Override
	public List<SocialLinkDisplay> getSocialLinkDisplays() {
		return _socialLinkDisplays;
	}

	@Override
	public boolean hasCompanyLogo() {
		return _hasCompanyLogo;
	}

	@Override
	public boolean hasCompanyName() {
		return _hasCompanyName;
	}

	@Override
	public boolean hasJobTitle() {
		return _hasJobTitle;
	}

	@Override
	public boolean isKeynoteSpeaker() {
		return _keynoteSpeaker;
	}

	private String _companyLogoFileEntryURL;
	private String _companyName;
	private String _description;
	private String _fullName;
	private boolean _hasCompanyLogo;
	private boolean _hasCompanyName;
	private boolean _hasJobTitle;
	private String _imageFileEntryURL;
	private String _jobTitle;
	private boolean _keynoteSpeaker;
	private List<SocialLinkDisplay> _socialLinkDisplays = new ArrayList<>();

}