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

import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Brian Wing Shun Chan
 * @author Douglas Wong
 * @author Peter Shin
 */
public class CustomSQLUtil {

	public static String get(String id) {
		return _instance._get(id);
	}

	@SuppressWarnings("unchecked")
	private CustomSQLUtil() {
		_sqlPool = new HashMap<String, String>();

		try {
			Class<?> clazz = getClass();

			ClassLoader classLoader = clazz.getClassLoader();

			Document document = SAXReaderUtil.read(
				classLoader.getResourceAsStream("/custom-sql/default.xml"));

			Element rootElement = document.getRootElement();

			List<Element> sqlElements = rootElement.elements("sql");

			for (Element sqlElement : sqlElements) {
				String elementId = sqlElement.attributeValue("id");
				String elementContent = sqlElement.getText();

				_sqlPool.put(elementId, elementContent);
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	private String _get(String id) {
		return _sqlPool.get(id);
	}

	private static Log _log = LogFactory.getLog(CustomSQLUtil.class);

	private static CustomSQLUtil _instance = new CustomSQLUtil();

	private Map<String, String> _sqlPool;

}