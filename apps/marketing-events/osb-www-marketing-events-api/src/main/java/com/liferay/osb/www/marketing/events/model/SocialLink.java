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
 * The extended model interface for the SocialLink service. Represents a row in the &quot;OSB_SocialLink&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SocialLinkModel
 * @see com.liferay.osb.www.marketing.events.model.impl.SocialLinkImpl
 * @see com.liferay.osb.www.marketing.events.model.impl.SocialLinkModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.osb.www.marketing.events.model.impl.SocialLinkImpl")
@ProviderType
public interface SocialLink extends SocialLinkModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.osb.www.marketing.events.model.impl.SocialLinkImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SocialLink, Long> SOCIAL_LINK_ID_ACCESSOR = new Accessor<SocialLink, Long>() {
			@Override
			public Long get(SocialLink socialLink) {
				return socialLink.getSocialLinkId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SocialLink> getTypeClass() {
				return SocialLink.class;
			}
		};

	public SocialLinkType getSocialLinkType()
		throws com.liferay.portal.kernel.exception.PortalException;

	@com.liferay.portal.kernel.json.JSON()
	public java.lang.String getSocialLinkTypeImageFileEntryURL()
		throws com.liferay.portal.kernel.exception.PortalException;

	@com.liferay.portal.kernel.json.JSON()
	public java.lang.String getSocialLinkTypeName()
		throws com.liferay.portal.kernel.exception.PortalException;
}