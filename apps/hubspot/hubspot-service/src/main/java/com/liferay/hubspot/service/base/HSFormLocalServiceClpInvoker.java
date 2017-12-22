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

package com.liferay.hubspot.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.hubspot.service.HSFormLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Peter Shin
 * @generated
 */
@ProviderType
public class HSFormLocalServiceClpInvoker {
	public HSFormLocalServiceClpInvoker() {
		_methodName18 = "getOSGiServiceIdentifier";

		_methodParameterTypes18 = new String[] {  };

		_methodName21 = "fetchHSFormByGUID";

		_methodParameterTypes21 = new String[] { "java.lang.String" };

		_methodName22 = "getAllHSForms";

		_methodParameterTypes22 = new String[] {  };

		_methodName23 = "getHSFormByGUID";

		_methodParameterTypes23 = new String[] { "java.lang.String" };

		_methodName24 = "submitHSForm";

		_methodParameterTypes24 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String[][]"
			};

		_methodName25 = "submitHSForm";

		_methodParameterTypes25 = new String[] {
				"java.lang.String", "java.lang.String[][]"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return HSFormLocalServiceUtil.getOSGiServiceIdentifier();
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			return HSFormLocalServiceUtil.fetchHSFormByGUID((java.lang.String)arguments[0]);
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			return HSFormLocalServiceUtil.getAllHSForms();
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			return HSFormLocalServiceUtil.getHSFormByGUID((java.lang.String)arguments[0]);
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			return HSFormLocalServiceUtil.submitHSForm((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String[])arguments[7]);
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return HSFormLocalServiceUtil.submitHSForm((java.lang.String)arguments[0],
				(java.lang.String[])arguments[1]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
}