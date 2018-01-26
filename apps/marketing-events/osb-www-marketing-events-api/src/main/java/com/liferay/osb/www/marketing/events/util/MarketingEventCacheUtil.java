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

import com.liferay.osb.www.marketing.events.model.MarketingEventAgendaDisplay;
import com.liferay.osb.www.marketing.events.service.MarketingEventLocalServiceUtil;
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
public class MarketingEventCacheUtil {

	public static void clearCache() {
		_portalCache.removeAll();
	}

	public static MarketingEventAgendaDisplay getMarketingEventAgendaDisplay(
		long groupId) {

		StopWatch stopWatch = new StopWatch();

		stopWatch.start();

		String key = _encodeKey(groupId);

		MarketingEventAgendaDisplay marketingEventAgendaDisplay = null;

		try {
			marketingEventAgendaDisplay =
				(MarketingEventAgendaDisplay)_portalCache.get(key);
		}
		catch (ClassCastException cce) {
			_portalCache.remove(key);
		}

		if (marketingEventAgendaDisplay == null) {
			marketingEventAgendaDisplay = _getMarketingEventAgendaDisplay(
				groupId);

			_portalCache.put(key, marketingEventAgendaDisplay);
		}

		if (_log.isDebugEnabled()) {
			_log.debug(
				"Getting marketing event agenda display for group " + groupId +
					" takes " + stopWatch.getTime() + " ms");
		}

		return marketingEventAgendaDisplay;
	}

	private static String _encodeKey(long groupId) {
		StringBundler sb = new StringBundler(3);

		sb.append(_CACHE_NAME);
		sb.append(StringPool.POUND);
		sb.append(StringUtil.toHexString(groupId));

		return sb.toString();
	}

	private static MarketingEventAgendaDisplay _getMarketingEventAgendaDisplay(
		long groupId) {

		try {
			if (_log.isInfoEnabled()) {
				_log.info(
					"Getting marketing event agenda display for group " +
						groupId);
			}

			return
				MarketingEventLocalServiceUtil.getMarketingEventAgendaDisplay(
					groupId);
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to get marketing event agenda display for group " +
						groupId);
			}

			return null;
		}
	}

	private static final String _CACHE_NAME =
		MarketingEventCacheUtil.class.getName();

	private static Log _log = LogFactoryUtil.getLog(
		MarketingEventCacheUtil.class);

	private static PortalCache<String, Serializable> _portalCache =
		MultiVMPoolUtil.getCache(_CACHE_NAME);

}