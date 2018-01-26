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

import com.liferay.osb.www.marketing.events.model.MarketingEventUser;
import com.liferay.osb.www.marketing.events.model.impl.MarketingEventUserImpl;
import com.liferay.osb.www.marketing.events.service.persistence.MarketingEventUserFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.Collections;
import java.util.List;

/**
 * @author Allen Ziegenfus
 */
public class MarketingEventUserFinderImpl
	extends MarketingEventUserFinderBaseImpl
	implements MarketingEventUserFinder {

	public static final String FIND_BY_CI_S =
		MarketingEventUserFinder.class.getName() + ".findByCI_S";

	public List<MarketingEventUser> findByCI_S(
		long[] categoryIds, int[] statuses, int start, int end,
		OrderByComparator obc) {

		if (ArrayUtil.isEmpty(categoryIds)) {
			return Collections.emptyList();
		}

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(getClass(), FIND_BY_CI_S);

			sql = StringUtil.replace(
				sql, "[$CATEGORY_IDS$]", StringUtil.merge(categoryIds));
			sql = StringUtil.replace(
				sql, "[$STATUSES$]", StringUtil.merge(statuses));
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addEntity("OSB_MarketingEventUser", MarketingEventUserImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(
				PortalUtil.getClassNameId(MarketingEventUser.class.getName()));

			return (List<MarketingEventUser>)QueryUtil.list(
				q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

}