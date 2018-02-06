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

package com.liferay.osb.www.marketing.events.hook.upgrade.v1_0_9;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Ryan Schuhler
 */
public class UpgradeMarketingEventAnnouncement extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		runSQL(
			"alter table OSB_MarketingEventAnnouncement modify linkURL " +
				"VARCHAR(150)");
		runSQL(
			"alter table OSB_MarketingEventAnnouncement modify linkLabel " +
				"VARCHAR(150)");

		if (!hasColumn("OSB_MarketingEventAnnouncement", "status")) {
			runSQL(
				"alter table OSB_MarketingEventAnnouncement add column " +
					"status INTEGER");
		}

		if (!hasColumn("OSB_MarketingEventAnnouncement", "statusByUserId")) {
			runSQL(
				"alter table OSB_MarketingEventAnnouncement add column " +
					"statusByUserId LONG");
		}

		if (!hasColumn("OSB_MarketingEventAnnouncement", "statusByUserName")) {
			runSQL(
				"alter table OSB_MarketingEventAnnouncement add column " +
					"statusByUserName STRING null");
		}

		if (!hasColumn("OSB_MarketingEventAnnouncement", "statusDate")) {
			runSQL(
				"alter table OSB_MarketingEventAnnouncement add column " +
					"statusDate DATE null");
		}

		runSQL(
			"update OSB_MarketingEventAnnouncement set status = 0, " +
				"statusByUserId = userId, statusByUserName = userName, " +
					"statusDate = createDate where status is null");

		runSQL(
			"create index IX_1EF95061 on OSB_MarketingEventAnnouncement " +
				"(marketingEventId, displayDate, status)");
	}

}