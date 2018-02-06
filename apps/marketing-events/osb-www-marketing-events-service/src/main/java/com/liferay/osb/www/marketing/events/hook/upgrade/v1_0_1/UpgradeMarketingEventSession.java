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
 * @author Ryan Schuhler
 * @author Joan H. Kim
 */
public class UpgradeMarketingEventSession extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (!hasColumn("OSB_MarketingEventSession", "slidesFileEntryId")) {
			runSQL(
				"alter table OSB_MarketingEventSession add column " +
					"slidesFileEntryId LONG");
		}

		if (!hasColumn("OSB_MarketingEventSession", "type_")) {
			runSQL(
				"alter table OSB_MarketingEventSession add column type_ " +
					"INTEGER");
		}

		runSQL(
			"create index IX_C71CC02B on OSB_MarketingEventSession " +
				"(marketingEventId, type_)");
	}

}