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
 * The extended model interface for the MarketingEventAnnouncement service. Represents a row in the &quot;OSB_MarketingEventAnnouncement&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventAnnouncementModel
 * @see com.liferay.osb.www.marketing.events.model.impl.MarketingEventAnnouncementImpl
 * @see com.liferay.osb.www.marketing.events.model.impl.MarketingEventAnnouncementModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.osb.www.marketing.events.model.impl.MarketingEventAnnouncementImpl")
@ProviderType
public interface MarketingEventAnnouncement
	extends MarketingEventAnnouncementModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventAnnouncementImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<MarketingEventAnnouncement, Long> MARKETING_EVENT_ANNOUNCEMENT_ID_ACCESSOR =
		new Accessor<MarketingEventAnnouncement, Long>() {
			@Override
			public Long get(
				MarketingEventAnnouncement marketingEventAnnouncement) {
				return marketingEventAnnouncement.getMarketingEventAnnouncementId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<MarketingEventAnnouncement> getTypeClass() {
				return MarketingEventAnnouncement.class;
			}
		};

	public com.liferay.portal.kernel.repository.model.FileEntry getImageFileEntry();

	@com.liferay.portal.kernel.json.JSON()
	public java.lang.String getImageFileEntryURL();
}