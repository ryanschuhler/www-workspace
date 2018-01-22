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
 * The extended model interface for the MarketingEventSession service. Represents a row in the &quot;OSB_MarketingEventSession&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSessionModel
 * @see com.liferay.osb.www.marketing.events.model.impl.MarketingEventSessionImpl
 * @see com.liferay.osb.www.marketing.events.model.impl.MarketingEventSessionModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.osb.www.marketing.events.model.impl.MarketingEventSessionImpl")
@ProviderType
public interface MarketingEventSession extends MarketingEventSessionModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventSessionImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<MarketingEventSession, Long> MARKETING_EVENT_SESSION_ID_ACCESSOR =
		new Accessor<MarketingEventSession, Long>() {
			@Override
			public Long get(MarketingEventSession marketingEventSession) {
				return marketingEventSession.getMarketingEventSessionId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<MarketingEventSession> getTypeClass() {
				return MarketingEventSession.class;
			}
		};

	public java.util.List<com.liferay.asset.kernel.model.AssetCategory> getAssetCategories()
		throws com.liferay.portal.kernel.exception.PortalException;

	@com.liferay.portal.kernel.json.JSON()
	public com.liferay.portal.kernel.json.JSONArray getAssetCategoriesJSONArray()
		throws com.liferay.portal.kernel.exception.PortalException;

	@com.liferay.portal.kernel.json.JSON()
	public MarketingEventSessionRoom getMarketingEventSessionRoom()
		throws com.liferay.portal.kernel.exception.PortalException;

	public long[] getMarketingEventUserIds();

	@com.liferay.portal.kernel.json.JSON()
	public java.util.List<MarketingEventUser> getMarketingEventUsers();

	@com.liferay.portal.kernel.json.JSON()
	public java.lang.String getRemoteURL();

	public com.liferay.portal.kernel.repository.model.FileEntry getSlidesFileEntry();

	@com.liferay.portal.kernel.json.JSON()
	public java.lang.String getSlidesFileEntryURL();
}