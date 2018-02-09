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

import com.liferay.osb.www.marketing.events.model.MarketingEventUser;
import com.liferay.osb.www.marketing.events.model.MarketingEventUserDisplay;
import com.liferay.osb.www.marketing.events.model.MarketingEventUsersDisplay;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Allen Ziegenfus
 */
public class MarketingEventUsersDisplayImpl
	implements MarketingEventUsersDisplay {

	public MarketingEventUsersDisplayImpl(
			List<MarketingEventUser> marketingEventUsers, String languageId)
		throws PortalException {

		for (MarketingEventUser marketingEventUser : marketingEventUsers) {
			MarketingEventUserDisplay marketingEventUserDisplay =
				new MarketingEventUserDisplayImpl(
					marketingEventUser, languageId);

			_marketingEventUserDisplays.add(marketingEventUserDisplay);
		}
	}

	@Override
	public List<MarketingEventUserDisplay> getMarketingEventUserDisplays() {
		return _marketingEventUserDisplays;
	}

	private List<MarketingEventUserDisplay> _marketingEventUserDisplays =
		new ArrayList<>();

}