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

package com.liferay.osb.www.marketing.events.hook.upgrade.v1_0_5;

import com.liferay.osb.www.marketing.events.model.impl.MarketingEventAnnouncementModelImpl;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Ryan Schuhler
 */
public class UpgradeMarketingEventAnnouncement extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (hasTable("OSB_MarketingEventAnnouncement")) {
			return;
		}

		runSQL(MarketingEventAnnouncementModelImpl.TABLE_SQL_CREATE);

		runSQL(
			"create index IX_6630D765 on OSB_MarketingEventAnnouncement " +
				"(marketingEventId)");
		runSQL(
			"create index IX_8E6D8112 on OSB_MarketingEventAnnouncement " +
				"(uuid_)");
	}

}