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

package com.liferay.osb.www.marketing.events.hook.upgrade.v1_0_7;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Ryan Schuhler
 * @author Joan H. Kim
 * @author Allen Ziegenfus
 */
public class UpgradeMarketingEventUser extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (!hasColumn("OSB_MarketingEventUser", "uuid_")) {
			runSQL(
				"alter table OSB_MarketingEventUser add column uuid_ " +
					"VARCHAR(75)");
			runSQL(
				"create index IX_87A0720E on OSB_MarketingEventUser (uuid_)");

			updateUUIDs();
		}

		if (!hasColumn("OSB_MarketingEventUser", "companyLogoFileEntryId")) {
			runSQL(
				"alter table OSB_MarketingEventUser add column " +
					"companyLogoFileEntryId LONG");
		}

		runSQL(
			"create index IX_B87DF6CF on OSB_MarketingEventUser " +
				"(marketingEventId, status)");
	}

	protected void updateUUIDs() throws Exception {
		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getConnection();

			ps1 = con.prepareStatement(
				"select marketingEventUserId from OSB_MarketingEventUser " +
					"where uuid_ is null");

			rs = ps1.executeQuery();

			ps2 = con.prepareStatement(
				"update OSB_MarketingEventUser set uuid_ = ? where " +
					"marketingEventUserId = ?");

			while (rs.next()) {
				ps2.setString(1, PortalUUIDUtil.generate());
				ps2.setLong(2, rs.getLong("marketingEventUserId"));

				ps2.executeUpdate();
			}
		}
		finally {
			DataAccess.cleanUp(ps1);
			DataAccess.cleanUp(con, ps2, rs);
		}
	}

}