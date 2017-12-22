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

package com.liferay.hubspot.hook.events;

import com.liferay.hubspot.model.HSContactCacheConstants;
import com.liferay.hubspot.model.HSGuestCacheConstants;
import com.liferay.hubspot.util.HubSpotConstants;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portlet.expando.DuplicateColumnNameException;
import com.liferay.portlet.expando.DuplicateTableNameException;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;

/**
 * @author Peter Shin
 */
public class StartupAction extends SimpleAction {

	@Override
	public void run(String[] ids) throws ActionException {
		try {
			doRun(GetterUtil.getLong(ids[0]));
		}
		catch (Exception e) {
			throw new ActionException(e);
		}
	}

	protected void doRun(long companyId) throws Exception {
		setUpExpando(companyId);
	}

	protected void setUpExpando(long companyId) throws Exception {
		ExpandoTable table = null;

		try {
			table = ExpandoTableLocalServiceUtil.addTable(
				companyId, User.class.getName(),
				HSContactCacheConstants.EXPANDO_TABLE_NAME);
		}
		catch (DuplicateTableNameException dtne) {
			table = ExpandoTableLocalServiceUtil.getTable(
				companyId, User.class.getName(),
				HSContactCacheConstants.EXPANDO_TABLE_NAME);
		}

		try {
			ExpandoColumnLocalServiceUtil.addColumn(
				table.getTableId(), HSContactCacheConstants.EXPANDO_COLUMN_NAME,
				ExpandoColumnConstants.STRING);
		}
		catch (DuplicateColumnNameException dcne) {
		}

		try {
			ExpandoColumnLocalServiceUtil.addColumn(
				table.getTableId(), HSGuestCacheConstants.EXPANDO_COLUMN_NAME,
				ExpandoColumnConstants.STRING);
		}
		catch (DuplicateColumnNameException dcne) {
		}

		try {
			table = ExpandoTableLocalServiceUtil.addTable(
				companyId, Company.class.getName(),
				HubSpotConstants.EXPANDO_TABLE_HUBSPOT);
		}
		catch (DuplicateTableNameException dtne) {
			table = ExpandoTableLocalServiceUtil.getTable(
				companyId, Company.class.getName(),
				HubSpotConstants.EXPANDO_TABLE_HUBSPOT);
		}

		try {
			ExpandoColumnLocalServiceUtil.addColumn(
				table.getTableId(),
				HubSpotConstants.EXPANDO_COLUMN_HUBSPOT_SYNCHRONIZE_DATES,
				ExpandoColumnConstants.DATE_ARRAY);
		}
		catch (DuplicateColumnNameException dcne) {
		}
	}

}