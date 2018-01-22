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
public class UpgradeMarketingEventUser extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		updateMarketingEventUser();
	}

	protected void updateMarketingEventUser() throws Exception {
		if (hasTable("OSB_MarketingEventUser")) {
			return;
		}

		StringBundler sb = new StringBundler(15);

		sb.append("create table OSB_MarketingEventUser (");
		sb.append("marketingEventUserId LONG not null primary key, ");
		sb.append("userId LONG, ");
		sb.append("userName VARCHAR(75) null, ");
		sb.append("createDate DATE null, ");
		sb.append("modifiedDate DATE null, ");
		sb.append("marketingEventId LONG, ");
		sb.append("firstName VARCHAR(75) null, ");
		sb.append("lastName VARCHAR(75) null, ");
		sb.append("companyName VARCHAR(75) null, ");
		sb.append("jobTitle STRING null, ");
		sb.append("description STRING null, ");
		sb.append("imageFileEntryId LONG, ");
		sb.append("slidesFileEntryId LONG, ");
		sb.append("phoneNumber VARCHAR(75) null)");

		runSQL(sb.toString());

		runSQL(
			"create unique index IX_59FD1023 on OSB_MarketingEventUser " +
				"(marketingEventId, userId)");
	}

}