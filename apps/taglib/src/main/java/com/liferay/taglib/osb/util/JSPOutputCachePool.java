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

package com.liferay.taglib.osb.util;

import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.PortalCache;

import java.io.Serializable;

/**
 * @author Allen Ziegenfus
 */
public class JSPOutputCachePool {

	public static void clearCache() {
		_portalCache.removeAll();
	}

	public static String getJSPOutput(String key) {
		String jspOutput = null;

		try {
			jspOutput = (String)_portalCache.get(key);
		}
		catch (ClassCastException cce) {
			_portalCache.remove(key);
		}

		return jspOutput;
	}

	public static void setJSPOutput(String key, String jspOutput) {
		_portalCache.put(key, jspOutput);
	}

	private static final String _CACHE_NAME =
		JSPOutputCachePool.class.getName();

	private static PortalCache<String, Serializable> _portalCache =
		MultiVMPoolUtil.getCache(_CACHE_NAME);

}