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

package com.liferay.osb.www.marketing.events.upgrade.v1_0_0;

import com.liferay.osb.www.marketing.events.constants.OSBWWWMarketingEventsPortletKeys;
import com.liferay.portal.kernel.upgrade.BaseUpgradePortletId;

/**
 * @author Allen Ziegenfus
 */
public class UpgradePortletId extends BaseUpgradePortletId {

	@Override
	protected String[][] getRenamePortletIdsArray() {
		return new String[][] {
			new String[] 
			{"1_WAR_osbwwwmarketingeventsportlet",OSBWWWMarketingEventsPortletKeys.MARKETING_EVENTS_ADMIN},
			{"2_WAR_osbwwwmarketingeventsportlet", OSBWWWMarketingEventsPortletKeys.MARKETING_EVENTS_DISPLAY}
			//{"3_WAR_osbwwwmarketingeventsportlet", OSBWWWMarketingEventsPortletKeys.MARKETING_EVENTS_DISPLAY},
			
		};
	}

}