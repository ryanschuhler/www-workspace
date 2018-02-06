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

package com.liferay.osb.www.marketing.events.hook.upgrade.v1_0_4;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Ryan Schuhler
 */
public class UpgradeMarketingEventUser extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (!hasColumn("OSB_MarketingEventUser", "status")) {
			runSQL(
				"alter table OSB_MarketingEventUser add column status INTEGER");
		}

		if (!hasColumn("OSB_MarketingEventUser", "statusByUserId")) {
			runSQL(
				"alter table OSB_MarketingEventUser add column " +
					"statusByUserId LONG");
		}

		if (!hasColumn("OSB_MarketingEventUser", "statusByUserName")) {
			runSQL(
				"alter table OSB_MarketingEventUser add column " +
					"statusByUserName STRING null");
		}

		if (!hasColumn("OSB_MarketingEventUser", "statusDate")) {
			runSQL(
				"alter table OSB_MarketingEventUser add column statusDate " +
					"DATE null");
		}

		runSQL("update OSB_MarketingEventUser set status = 0");
		runSQL("update OSB_MarketingEventUser set statusByUserId = userId");
		runSQL("update OSB_MarketingEventUser set statusByUserName = userName");
		runSQL("update OSB_MarketingEventUser set statusDate = createDate");
	}

}