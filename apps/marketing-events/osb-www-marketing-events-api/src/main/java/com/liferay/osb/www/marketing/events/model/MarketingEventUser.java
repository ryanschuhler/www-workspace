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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the MarketingEventUser service. Represents a row in the &quot;OSB_MarketingEventUser&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventUserModel
 * @see com.liferay.osb.www.marketing.events.model.impl.MarketingEventUserImpl
 * @see com.liferay.osb.www.marketing.events.model.impl.MarketingEventUserModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.osb.www.marketing.events.model.impl.MarketingEventUserImpl")
@ProviderType
public interface MarketingEventUser extends MarketingEventUserModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventUserImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<MarketingEventUser, Long> MARKETING_EVENT_USER_ID_ACCESSOR =
		new Accessor<MarketingEventUser, Long>() {
			@Override
			public Long get(MarketingEventUser marketingEventUser) {
				return marketingEventUser.getMarketingEventUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<MarketingEventUser> getTypeClass() {
				return MarketingEventUser.class;
			}
		};

	public java.util.List<com.liferay.asset.kernel.model.AssetCategory> getAssetCategories()
		throws com.liferay.portal.kernel.exception.PortalException;

	@com.liferay.portal.kernel.json.JSON()
	public com.liferay.portal.kernel.json.JSONArray getAssetCategoriesJSONArray()
		throws com.liferay.portal.kernel.exception.PortalException;

	public com.liferay.portal.kernel.repository.model.FileEntry getCompanyLogoFileEntry();

	@com.liferay.portal.kernel.json.JSON()
	public java.lang.String getCompanyLogoFileEntryURL();

	public java.lang.String getFullName();

	public com.liferay.portal.kernel.repository.model.FileEntry getImageFileEntry();

	@com.liferay.portal.kernel.json.JSON()
	public java.lang.String getImageFileEntryURL();

	@com.liferay.portal.kernel.json.JSON()
	public java.util.List<SocialLink> getSocialLinks()
		throws com.liferay.portal.kernel.exception.PortalException;

	public com.liferay.portal.kernel.model.User getUser()
		throws com.liferay.portal.kernel.exception.PortalException;
}