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
public class UpgradeMarketingEventSessionRoom extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		updateMarketingEventSessionRoom();
	}

	protected void updateMarketingEventSessionRoom() throws Exception {
		if (hasTable("OSB_MarketingEventSessionRoom")) {
			return;
		}

		StringBundler sb = new StringBundler(7);

		sb.append("create table OSB_MarketingEventSessionRoom (");
		sb.append("marketingEventSessionRoomId LONG not null primary key, ");
		sb.append("createDate DATE null, ");
		sb.append("modifiedDate DATE null, ");
		sb.append("marketingEventId LONG, ");
		sb.append("name VARCHAR(75) null, ");
		sb.append("imageFileEntryId LONG)");

		runSQL(sb.toString());

		runSQL(
			"create index IX_EE2FEF65 on OSB_MarketingEventSessionRoom " +
				"(marketingEventId)");
	}

}