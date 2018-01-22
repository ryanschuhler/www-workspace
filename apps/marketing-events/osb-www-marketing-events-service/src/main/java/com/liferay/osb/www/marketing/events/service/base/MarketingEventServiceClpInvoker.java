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

package com.liferay.osb.www.marketing.events.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osb.www.marketing.events.service.MarketingEventServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class MarketingEventServiceClpInvoker {
	public MarketingEventServiceClpInvoker() {
		_methodName82 = "getOSGiServiceIdentifier";

		_methodParameterTypes82 = new String[] {  };

		_methodName87 = "getMarketingEvents";

		_methodParameterTypes87 = new String[] {
				"int", "java.util.Date", "int", "int"
			};

		_methodName88 = "getMarketingEvents";

		_methodParameterTypes88 = new String[] { "int", "int", "int" };

		_methodName89 = "getMarketingEvents";

		_methodParameterTypes89 = new String[] {
				"int[][]", "int[][]", "long[][]", "int[][]", "boolean",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return MarketingEventServiceUtil.getOSGiServiceIdentifier();
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return MarketingEventServiceUtil.getMarketingEvents(((Integer)arguments[0]).intValue(),
				(java.util.Date)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return MarketingEventServiceUtil.getMarketingEvents(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return MarketingEventServiceUtil.getMarketingEvents((int[])arguments[0],
				(int[])arguments[1], (long[])arguments[2], (int[])arguments[3],
				((Boolean)arguments[4]).booleanValue(),
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName87;
	private String[] _methodParameterTypes87;
	private String _methodName88;
	private String[] _methodParameterTypes88;
	private String _methodName89;
	private String[] _methodParameterTypes89;
}