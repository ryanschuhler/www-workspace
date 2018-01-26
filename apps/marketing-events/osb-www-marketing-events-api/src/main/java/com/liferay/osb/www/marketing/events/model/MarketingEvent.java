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
 * The extended model interface for the MarketingEvent service. Represents a row in the &quot;OSB_MarketingEvent&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventModel
 * @see com.liferay.osb.www.marketing.events.model.impl.MarketingEventImpl
 * @see com.liferay.osb.www.marketing.events.model.impl.MarketingEventModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.osb.www.marketing.events.model.impl.MarketingEventImpl")
@ProviderType
public interface MarketingEvent extends MarketingEventModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<MarketingEvent, Long> MARKETING_EVENT_ID_ACCESSOR =
		new Accessor<MarketingEvent, Long>() {
			@Override
			public Long get(MarketingEvent marketingEvent) {
				return marketingEvent.getMarketingEventId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<MarketingEvent> getTypeClass() {
				return MarketingEvent.class;
			}
		};

	@com.liferay.portal.kernel.json.JSON()
	public com.liferay.portal.kernel.model.Address getAddress();

	@com.liferay.portal.kernel.json.JSON()
	public com.liferay.portal.kernel.model.Country getCountry();

	@com.liferay.portal.kernel.json.JSON()
	public com.liferay.portal.kernel.json.JSONObject getExtraSettingsJSONObject();

	public com.liferay.portal.kernel.util.UnicodeProperties getExtraSettingsProperties();

	public com.liferay.portal.kernel.repository.model.FileEntry getImageFileEntry();

	@com.liferay.portal.kernel.json.JSON()
	public java.lang.String getImageFileEntryURL();

	@com.liferay.portal.kernel.json.JSON()
	public com.liferay.portal.kernel.json.JSONObject getMarketingEventSessionAssetCategoriesJSONObject()
		throws com.liferay.portal.kernel.exception.PortalException;

	@com.liferay.portal.kernel.json.JSON()
	public com.liferay.portal.kernel.model.Region getRegion();

	public com.liferay.portal.kernel.repository.model.FileEntry getSlidesFileEntry();

	public java.lang.String getVideoURL(java.lang.String extension);

	public boolean hasVideo();

	public boolean isTypeCommunity();

	public boolean isTypeConference();

	public boolean isTypeIndustry();

	public boolean isTypePartner();

	public boolean isTypeRoadshow();

	public boolean isTypeWebinar();
}