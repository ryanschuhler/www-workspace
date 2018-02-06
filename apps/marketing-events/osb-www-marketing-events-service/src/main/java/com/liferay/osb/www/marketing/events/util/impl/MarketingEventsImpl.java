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

package com.liferay.osb.www.marketing.events.util.impl;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.osb.www.marketing.events.model.MarketingEvent;
import com.liferay.osb.www.marketing.events.model.MarketingEventSession;
import com.liferay.osb.www.marketing.events.model.MarketingEventUser;
import com.liferay.osb.www.marketing.events.service.MarketingEventLocalServiceUtil;
import com.liferay.osb.www.marketing.events.service.MarketingEventSessionLocalServiceUtil;
import com.liferay.osb.www.marketing.events.service.MarketingEventUserLocalServiceUtil;
import com.liferay.osb.www.marketing.events.util.MarketingEvents;
import com.liferay.osb.www.marketing.events.util.MarketingEventsUtil;
import com.liferay.osb.www.marketing.events.util.comparator.MarketingEventUserFirstNameComparator;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.osgi.service.component.annotations.Component;

/**
 * @author Allen Ziegenfus
 */
@Component
public class MarketingEventsImpl implements MarketingEvents {

	@Override
	public List<Map.Entry<MarketingEventUser, List<MarketingEventSession>>>
			getMarketingEventUserMarketingEventSessions(
				long marketingEventId, String vocabularyName,
				String categoryName)
		throws PortalException {

		Map<MarketingEventUser, List<MarketingEventSession>>
			marketingEventUserMarketingEventSessionsMap =
				getMarketingEventUserMarketingEventSessionsMap(
					marketingEventId, vocabularyName, categoryName);

		List<Map.Entry<MarketingEventUser, List<MarketingEventSession>>>
			marketingEventUserMarketingEventSessions = new ArrayList<>();

		marketingEventUserMarketingEventSessions.addAll(
			marketingEventUserMarketingEventSessionsMap.entrySet());

		return marketingEventUserMarketingEventSessions;
	}

	@Override
	public Map<MarketingEventUser, List<MarketingEventSession>>
			getMarketingEventUserMarketingEventSessionsMap(
				long marketingEventId, String vocabularyName,
				String categoryName)
		throws PortalException {

		MarketingEvent marketingEvent =
			MarketingEventLocalServiceUtil.getMarketingEvent(marketingEventId);

		List<MarketingEventSession> marketingEventSessions = new ArrayList<>();

		try {
			AssetVocabulary assetVocabulary =
				AssetVocabularyLocalServiceUtil.getGroupVocabulary(
					marketingEvent.getSiteGroupId(), vocabularyName);

			AssetCategory assetCategory =
				MarketingEventsUtil.fetchAssetCategory(
					categoryName, assetVocabulary.getVocabularyId());

			marketingEventSessions =
				MarketingEventSessionLocalServiceUtil.getMarketingEventSessions(
					new long[] {assetCategory.getCategoryId()},
					new int[] {WorkflowConstants.STATUS_APPROVED},
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
		}
		catch (Exception e) {
			return Collections.emptyMap();
		}

		Map<MarketingEventUser, List<MarketingEventSession>>
			marketingEventUserMarketingEventSessionsMap = new TreeMap<>(
				new MarketingEventUserFirstNameComparator());

		for (MarketingEventSession marketingEventSession :
				marketingEventSessions) {

			for (MarketingEventUser marketingEventUser :
					marketingEventSession.getMarketingEventUsers()) {

				List<MarketingEventSession>
					marketingEventUserMarketingEventSessionList;

				if (marketingEventUserMarketingEventSessionsMap.containsKey(
						marketingEventUser)) {

					marketingEventUserMarketingEventSessionList =
						marketingEventUserMarketingEventSessionsMap.get(
							marketingEventUser);
				}
				else {
					marketingEventUserMarketingEventSessionList =
						new ArrayList<>();
				}

				marketingEventUserMarketingEventSessionList.add(
					marketingEventSession);

				marketingEventUserMarketingEventSessionsMap.put(
					marketingEventUser,
					marketingEventUserMarketingEventSessionList);
			}
		}

		return marketingEventUserMarketingEventSessionsMap;
	}

	@Override
	public List<MarketingEventUser> getMarketingEventUsers(
			long marketingEventId, String vocabularyName, String categoryName)
		throws PortalException {

		MarketingEvent marketingEvent =
			MarketingEventLocalServiceUtil.getMarketingEvent(marketingEventId);

		try {
			AssetVocabulary assetVocabulary =
				AssetVocabularyLocalServiceUtil.getGroupVocabulary(
					marketingEvent.getSiteGroupId(), vocabularyName);

			AssetCategory assetCategory =
				MarketingEventsUtil.fetchAssetCategory(
					categoryName, assetVocabulary.getVocabularyId());

			return MarketingEventUserLocalServiceUtil.getMarketingEventUsers(
				new long[] {assetCategory.getCategoryId()},
				new int[] {WorkflowConstants.STATUS_APPROVED},
				QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				new MarketingEventUserFirstNameComparator());
		}
		catch (Exception e) {
			return Collections.emptyList();
		}
	}

}