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

package com.liferay.osb.www.marketing.events.util;

import com.liferay.osb.www.marketing.events.model.MarketingEventSession;
import com.liferay.osb.www.marketing.events.model.MarketingEventUser;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;
import java.util.Map;

/**
 * @author Allen Ziegenfus
 */
public interface MarketingEvents {

	public List<Map.Entry<MarketingEventUser, List<MarketingEventSession>>>
			getMarketingEventUserMarketingEventSessions(
				long marketingEventId, String vocabularyName,
				String categoryName)
		throws PortalException;

	public Map<MarketingEventUser, List<MarketingEventSession>>
			getMarketingEventUserMarketingEventSessionsMap(
				long marketingEventId, String vocabularyName,
				String categoryName)
		throws PortalException;

	public List<MarketingEventUser> getMarketingEventUsers(
			long marketingEventId, String vocabularyName, String categoryName)
		throws PortalException;

}