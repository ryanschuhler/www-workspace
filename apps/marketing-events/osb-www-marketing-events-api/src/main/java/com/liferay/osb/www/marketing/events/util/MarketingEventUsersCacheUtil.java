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

package com.liferay.osb.www.marketing.events.util;

import com.liferay.osb.www.marketing.events.model.MarketingEventUsersDisplay;
import com.liferay.osb.www.marketing.events.service.MarketingEventUserLocalServiceUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import org.apache.commons.lang.time.StopWatch;

/**
 * @author Allen Ziegenfus
 */
public class MarketingEventUsersCacheUtil {

	public static void clearCache() {
		_portalCache.removeAll();
	}

	public static MarketingEventUsersDisplay getMarketingEventUsersDisplay(
		long marketingEventSiteGroup, long[] anyAssetCategoryIds,
		long[] notAnyAssetCategoryIds, String orderByCol, String orderByType,
		String languageId) {

		StopWatch stopWatch = new StopWatch();

		stopWatch.start();

		String key = _encodeKey(
			marketingEventSiteGroup, anyAssetCategoryIds,
			notAnyAssetCategoryIds, orderByCol, orderByType, languageId);

		MarketingEventUsersDisplay marketingEventUsersDisplay = null;

		try {
			marketingEventUsersDisplay =
				(MarketingEventUsersDisplay)_portalCache.get(key);
		}
		catch (ClassCastException cce) {
			_portalCache.remove(key);
		}

		if (marketingEventUsersDisplay == null) {
			marketingEventUsersDisplay = _getMarketingEventUsersDisplay(
				marketingEventSiteGroup, anyAssetCategoryIds,
				notAnyAssetCategoryIds, orderByCol, orderByType, languageId,
				key);

			_portalCache.put(key, marketingEventUsersDisplay);
		}

		if (_log.isDebugEnabled()) {
			_log.debug(
				"Getting marketing event users display for key " + key +
					" takes " + stopWatch.getTime() + " ms");
		}

		return marketingEventUsersDisplay;
	}

	private static String _encodeKey(
		long marketingEventSiteGroup, long[] anyAssetCategoryIds,
		long[] notAnyAssetCategoryIds, String orderByCol, String orderByType,
		String languageId) {

		StringBundler sb = new StringBundler(13);

		sb.append(_CACHE_NAME);
		sb.append(StringPool.POUND);
		sb.append(StringUtil.toHexString(marketingEventSiteGroup));
		sb.append(StringPool.POUND);
		sb.append(StringUtil.merge(anyAssetCategoryIds));
		sb.append(StringPool.POUND);
		sb.append(StringUtil.merge(notAnyAssetCategoryIds));
		sb.append(StringPool.POUND);
		sb.append(orderByCol);
		sb.append(StringPool.POUND);
		sb.append(orderByType);
		sb.append(StringPool.POUND);
		sb.append(languageId);

		return sb.toString();
	}

	private static MarketingEventUsersDisplay _getMarketingEventUsersDisplay(
		long marketingEventSiteGroup, long[] anyAssetCategoryIds,
		long[] notAnyAssetCategoryIds, String orderByCol, String orderByType,
		String languageId, String key) {

		try {
			if (_log.isInfoEnabled()) {
				_log.info(
					"Getting marketing event users display for key " + key);
			}

			return MarketingEventUserLocalServiceUtil.
				getMarketingEventUsersDisplay(
					marketingEventSiteGroup, anyAssetCategoryIds,
					notAnyAssetCategoryIds, orderByCol, orderByType,
					languageId);
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to get marketing event users display for key " +
						key);
			}

			return null;
		}
	}

	private static final String _CACHE_NAME =
		MarketingEventUsersCacheUtil.class.getName();

	private static Log _log = LogFactoryUtil.getLog(
		MarketingEventUsersCacheUtil.class);

	private static PortalCache<String, Serializable> _portalCache =
		MultiVMPoolUtil.getCache(_CACHE_NAME);

}