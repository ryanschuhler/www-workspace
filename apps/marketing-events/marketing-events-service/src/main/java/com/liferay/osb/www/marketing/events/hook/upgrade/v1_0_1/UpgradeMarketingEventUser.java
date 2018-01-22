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

package com.liferay.osb.www.marketing.events.hook.upgrade.v1_0_1;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Joan H. Kim
 */
public class UpgradeMarketingEventUser extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (hasColumn("OSB_MarketingEventUser", "slidesFileEntryId")) {
			runSQL(
				"alter table OSB_MarketingEventUser drop column " +
					"slidesFileEntryId");
		}

		runSQL("drop index IX_59FD1023 on OSB_MarketingEventUser");

		runSQL(
			"create index IX_37A6B0E9 on OSB_MarketingEventUser " +
				"(marketingEventId)");
	}

}