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

package com.liferay.osb.www.marketing.events.service.persistence.impl;

import com.liferay.osb.www.marketing.events.model.MarketingEventSession;
import com.liferay.osb.www.marketing.events.service.persistence.MarketingEventSessionPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.ReflectionUtil;

import java.lang.reflect.Field;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MarketingEventSessionFinderBaseImpl extends BasePersistenceImpl<MarketingEventSession> {
	public MarketingEventSessionFinderBaseImpl() {
		setModelClass(MarketingEventSession.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	@Override
	public Set<String> getBadColumnNames() {
		return getMarketingEventSessionPersistence().getBadColumnNames();
	}

	/**
	 * Returns the marketing event session persistence.
	 *
	 * @return the marketing event session persistence
	 */
	public MarketingEventSessionPersistence getMarketingEventSessionPersistence() {
		return marketingEventSessionPersistence;
	}

	/**
	 * Sets the marketing event session persistence.
	 *
	 * @param marketingEventSessionPersistence the marketing event session persistence
	 */
	public void setMarketingEventSessionPersistence(
		MarketingEventSessionPersistence marketingEventSessionPersistence) {
		this.marketingEventSessionPersistence = marketingEventSessionPersistence;
	}

	@BeanReference(type = MarketingEventSessionPersistence.class)
	protected MarketingEventSessionPersistence marketingEventSessionPersistence;
	private static final Log _log = LogFactoryUtil.getLog(MarketingEventSessionFinderBaseImpl.class);
}