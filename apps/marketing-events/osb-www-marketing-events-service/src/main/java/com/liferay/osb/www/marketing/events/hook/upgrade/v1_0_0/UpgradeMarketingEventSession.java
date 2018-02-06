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

package com.liferay.osb.www.marketing.events.hook.upgrade.v1_0_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.StringBundler;

/**
 * @author Joan H. Kim
 */
public class UpgradeMarketingEventSession extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		updateMarketingEventSession();
		updateMarketingEventSessionsMarketingEventUsers();
	}

	protected void updateMarketingEventSession() throws Exception {
		if (hasTable("OSB_MarketingEventSession")) {
			return;
		}

		StringBundler sb = new StringBundler(17);

		sb.append("create table OSB_MarketingEventSession (");
		sb.append("marketingEventSessionId LONG not null primary key, ");
		sb.append("userId LONG, ");
		sb.append("userName VARCHAR(75) null, ");
		sb.append("createDate DATE null, ");
		sb.append("modifiedDate DATE null, ");
		sb.append("marketingEventId LONG, ");
		sb.append("marketingEventSessionRoomId LONG, ");
		sb.append("title STRING null, ");
		sb.append("description STRING null, ");
		sb.append("keywords STRING null, ");
		sb.append("startDate DATE null, ");
		sb.append("endDate DATE null, ");
		sb.append("status INTEGER, ");
		sb.append("statusByUserId LONG, ");
		sb.append("statusByUserName VARCHAR(75) null, ");
		sb.append("statusDate DATE null)");

		runSQL(sb.toString());

		runSQL(
			"create index IX_A7BB5DE on OSB_MarketingEventSession " +
				"(marketingEventId, marketingEventSessionRoomId)");
		runSQL(
			"create index IX_9360B350 on OSB_MarketingEventSession " +
				"(marketingEventId, status)");
	}

	protected void updateMarketingEventSessionsMarketingEventUsers()
		throws Exception {

		if (hasTable("OSB_MarketingEventSessions_MarketingEventUsers")) {
			return;
		}

		StringBundler sb = new StringBundler(6);

		sb.append("create table ");
		sb.append("OSB_MarketingEventSessions_MarketingEventUsers (");
		sb.append("marketingEventSessionId LONG not null, ");
		sb.append("marketingEventUserId LONG not null, ");
		sb.append("primary key ");
		sb.append("(marketingEventSessionId, marketingEventUserId))");

		runSQL(sb.toString());

		runSQL(
			"create index IX_A9C3F140 on " +
				"OSB_MarketingEventSessions_MarketingEventUsers " +
					"(marketingEventSessionId)");
		runSQL(
			"create index IX_8408C51B on " +
				"OSB_MarketingEventSessions_MarketingEventUsers " +
					"(marketingEventUserId)");
	}

}