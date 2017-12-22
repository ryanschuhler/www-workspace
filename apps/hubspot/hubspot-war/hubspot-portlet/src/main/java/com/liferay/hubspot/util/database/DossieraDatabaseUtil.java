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

package com.liferay.hubspot.util.database;

import com.liferay.hubspot.util.HubSpotEmailTemplateUtil;
import com.liferay.hubspot.util.PortletPropsValues;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Properties;

/**
 * @author Joan H. Kim
 */
public class DossieraDatabaseUtil {

	public static JSONArray getOpportunitiesJSONArray() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		try {
			con = getConnection();

			String sql = CustomSQLUtil.get(
				_CUSTOM_SQL_ID_FIND_OPPORTUNITY_RENEWALS);

			sql = StringUtil.replace(
				sql, "[$HUBSPOT_RENEWAL_COUNTRY_CODES_TEMPLATE$]",
				toQueryValues(
					PortletPropsValues.HUBSPOT_RENEWAL_COUNTRY_CODES));
			sql = StringUtil.replace(
				sql, "[$HUBSPOT_RENEWAL_DAYS_INTERVAL_TEMPLATE$]",
				PortletPropsValues.HUBSPOT_RENEWAL_DAYS_INTERVAL);
			sql = StringUtil.replace(
				sql, "[$HUBSPOT_RENEWAL_EMAIL_TEMPLATE$]",
				PortletPropsValues.HUBSPOT_RENEWAL_EMAIL);
			sql = StringUtil.replace(
				sql, "[$HUBSPOT_RENEWAL_SUBJECT_TEMPLATE$]",
				PortletPropsValues.HUBSPOT_RENEWAL_SUBJECT);
			sql = StringUtil.replace(
				sql, "[$HUBSPOT_RENEWAL_USER_ID_TEMPLATE$]",
				PortletPropsValues.HUBSPOT_RENEWAL_USER_ID);

			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

				JSONArray customPropertiesJSONArray =
					JSONFactoryUtil.createJSONArray();

				JSONObject opportunitiesJSONObject =
					JSONFactoryUtil.createJSONObject();

				opportunitiesJSONObject.put("name", "osb_opportunities");
				opportunitiesJSONObject.put(
					"value", rs.getString("opportunities"));

				customPropertiesJSONArray.put(opportunitiesJSONObject);

				jsonObject.put("customProperties", customPropertiesJSONArray);

				jsonObject.put(
					"emailId",
					HubSpotEmailTemplateUtil.getRenewalTemplateId(
						rs.getString("countryCode")));

				JSONObject messageJSONObject =
					JSONFactoryUtil.createJSONObject();

				messageJSONObject.put("to", rs.getString("email"));

				jsonObject.put("message", messageJSONObject);

				jsonArray.put(jsonObject);
			}
		}
		catch (SQLException se) {
			_log.error(se, se);
		}
		finally {
			DataAccess.cleanUp(con, ps, rs);
		}

		return jsonArray;
	}

	protected static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		String url =
			"jdbc:mysql://" + PortletPropsValues.DOSSIERA_DATABASE_HOST +
				StringPool.SLASH + PortletPropsValues.DOSSIERA_DATABASE_NAME;

		Properties properties = new Properties();

		properties.put("characterEncoding", "UTF-8");
		properties.put(
			"password", PortletPropsValues.DOSSIERA_DATABASE_PASSWORD);
		properties.put("useFastDateParsing", "false");
		properties.put("useUnicode", "true");
		properties.put("user", PortletPropsValues.DOSSIERA_DATABASE_USER);

		return DriverManager.getConnection(url, properties);
	}

	protected static String toQueryValues(String value) {
		String queryValues = StringPool.BLANK;

		String[] values = StringUtil.split(value);

		for (int i = 0; i < values.length; i++) {
			queryValues += StringUtil.quote(values[i]);

			if ((i + 1) < values.length) {
				queryValues += StringPool.COMMA;
			}
		}

		return queryValues;
	}

	private static final String _CUSTOM_SQL_ID_FIND_OPPORTUNITY_RENEWALS =
		DossieraDatabaseUtil.class.getName() + ".findOpportunityRenewals";

	private static Log _log = LogFactoryUtil.getLog(DossieraDatabaseUtil.class);

}