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

package com.liferay.osb.www.marketing.events.hook.upgrade.v1_0_8;

import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.osb.www.marketing.events.model.MarketingEvent;
import com.liferay.osb.www.marketing.events.model.MarketingEventUser;
import com.liferay.osb.www.marketing.events.service.MarketingEventLocalServiceUtil;
import com.liferay.osb.www.marketing.events.service.MarketingEventUserLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.ContentTypes;

import java.util.List;

/**
 * @author Allen Ziegenfus
 */
public class UpgradeAssetEntry extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		List<MarketingEventUser> marketingEventUsers =
			MarketingEventUserLocalServiceUtil.getMarketingEventUsers(
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (MarketingEventUser marketingEventUser : marketingEventUsers) {
			MarketingEvent marketingEvent =
				MarketingEventLocalServiceUtil.getMarketingEvent(
					marketingEventUser.getMarketingEventId());

			AssetEntryLocalServiceUtil.updateEntry(
				marketingEventUser.getUserId(), marketingEvent.getSiteGroupId(),
				marketingEventUser.getCreateDate(),
				marketingEventUser.getModifiedDate(),
				MarketingEventUser.class.getName(),
				marketingEventUser.getMarketingEventUserId(),
				marketingEventUser.getUuid(), 0, null, null, true, null, null,
				null, ContentTypes.TEXT, marketingEventUser.getFullName(),
				marketingEventUser.getDescription(), null, null, null, 0, 0,
				null, false);
		}
	}

}