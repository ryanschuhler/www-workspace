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

package com.liferay.osb.www.marketing.events.hook.upgrade.v1_0_6;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Ryan Schuhler
 */
public class UpgradeMarketingEvent extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (!hasColumn("OSB_MarketingEvent", "latitude")) {
			runSQL("alter table OSB_MarketingEvent add column latitude DOUBLE");
		}

		if (!hasColumn("OSB_MarketingEvent", "longitude")) {
			runSQL(
				"alter table OSB_MarketingEvent add column longitude DOUBLE");
		}

		if (!hasColumn("OSB_MarketingEvent", "extraSettings")) {
			runSQL(
				"alter table OSB_MarketingEvent add column extraSettings " +
					"STRING null");
		}
	}

}