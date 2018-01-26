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

package com.liferay.osb.www.marketing.events.asset;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.osb.www.marketing.events.constants.OSBWWWMarketingEventsPortletKeys;
import com.liferay.osb.www.marketing.events.model.MarketingEventUser;
import com.liferay.osb.www.marketing.events.service.MarketingEventUserLocalServiceUtil;
import com.liferay.osb.www.marketing.events.service.permission.OSBWWWMarketingEventPermissionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;

/**
 * @author Phillip Chan
 * @author Joan H. Kim
 */
@Component(
	immediate = true,
	property = {"javax.portlet.name=" + OSBWWWMarketingEventsPortletKeys.MARKETING_EVENTS_ADMIN},
	service = AssetRendererFactory.class
)
public class MarketingEventUserAssetRendererFactory
	extends BaseAssetRendererFactory<MarketingEventUser> {

	public static final String CLASS_NAME = MarketingEventUser.class.getName();

	public static final String TYPE = "marketing_event_user";

	public MarketingEventUserAssetRendererFactory() {
		setClassName(CLASS_NAME);
		setLinkable(true);
		setPortletId(OSBWWWMarketingEventsPortletKeys.MARKETING_EVENTS_ADMIN);
		setSearchable(true);
	}

	@Override
	public AssetRenderer<MarketingEventUser> getAssetRenderer(
			long classPK, int type)
		throws PortalException {

		MarketingEventUser marketingEventUser =
			MarketingEventUserLocalServiceUtil.getMarketingEventUser(classPK);

		return new MarketingEventUserAssetRenderer(marketingEventUser);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, long classPK, String actionId)
		throws Exception {

		return OSBWWWMarketingEventPermissionUtil.contains(
			permissionChecker, actionId);
	}

}