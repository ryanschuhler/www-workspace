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

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.osb.www.marketing.events.constants.OSBWWWMarketingEventsConstants;
import com.liferay.osb.www.marketing.events.constants.OSBWWWMarketingEventsPortletKeys;
import com.liferay.osb.www.marketing.events.constants.OSBWWWMarketingEventsWebKeys;
import com.liferay.osb.www.marketing.events.model.MarketingEventUser;
import com.liferay.osb.www.marketing.events.service.permission.OSBWWWMarketingEventPermissionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.HtmlUtil;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Phillip Chan
 * @author Joan H. Kim
 */
public class MarketingEventUserAssetRenderer
	extends BaseJSPAssetRenderer<MarketingEventUser> {

	public MarketingEventUserAssetRenderer(
		MarketingEventUser marketingEventUser) {

		_marketingEventUser = marketingEventUser;
	}

	@Override
	public MarketingEventUser getAssetObject() {
		return _marketingEventUser;
	}

	@Override
	public String getClassName() {
		return MarketingEventUser.class.getName();
	}

	@Override
	public long getClassPK() {
		return _marketingEventUser.getMarketingEventUserId();
	}

	@Override
	public long getGroupId() {
		return OSBWWWMarketingEventsConstants.GROUP_GUEST_ID;
	}

	@Override
	public String getJspPath(
		HttpServletRequest renderRequest, String template) {

		if (template.equals(TEMPLATE_FULL_CONTENT)) {
			renderRequest.setAttribute(
				OSBWWWMarketingEventsWebKeys.MARKETING_EVENT_USER,
				_marketingEventUser);

			return "/admin/asset/user_" + template + ".jsp";
		}
		else {
			return null;
		}
	}

	@Override
	public String getSummary(
		PortletRequest portletRequest, PortletResponse portletResponse) {

		Locale locale = portletRequest.getLocale();

		return HtmlUtil.stripHtml(_marketingEventUser.getDescription(locale));
	}

	@Override
	public String getTitle(Locale locale) {
		return _marketingEventUser.getFullName();
	}

	@Override
	public PortletURL getURLEdit(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse)
		throws Exception {

		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
			getControlPanelPlid(liferayPortletRequest),
			OSBWWWMarketingEventsPortletKeys.MARKETING_EVENTS_ADMIN,
			PortletRequest.RENDER_PHASE);

		portletURL.setParameter(
			"mvcPath", "/admin/edit_marketing_event_user.jsp");
		portletURL.setParameter(
			"marketingEventUserId",
			String.valueOf(_marketingEventUser.getMarketingEventUserId()));
		portletURL.setParameter(
			"marketingEventId",
			String.valueOf(_marketingEventUser.getMarketingEventId()));

		return portletURL;
	}

	@Override
	public long getUserId() {
		return _marketingEventUser.getUserId();
	}

	@Override
	public String getUserName() {
		return _marketingEventUser.getUserName();
	}

	@Override
	public String getUuid() {
		return _marketingEventUser.getUuid();
	}

	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker)
		throws PortalException {

		return OSBWWWMarketingEventPermissionUtil.contains(
			permissionChecker, ActionKeys.UPDATE);
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker)
		throws PortalException {

		return OSBWWWMarketingEventPermissionUtil.contains(
			permissionChecker, ActionKeys.VIEW);
	}

	private final MarketingEventUser _marketingEventUser;

}