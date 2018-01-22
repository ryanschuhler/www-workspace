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

import com.liferay.osb.www.marketing.events.service.MarketingEventAnnouncementServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class MarketingEventAnnouncementServiceClpInvoker {
	public MarketingEventAnnouncementServiceClpInvoker() {
		_methodName76 = "getOSGiServiceIdentifier";

		_methodParameterTypes76 = new String[] {  };

		_methodName81 = "getMarketingEventAnnouncements";

		_methodParameterTypes81 = new String[] { "long", "boolean", "int", "int" };

		_methodName82 = "getMarketingEventAnnouncements";

		_methodParameterTypes82 = new String[] { "long", "int", "int" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return MarketingEventAnnouncementServiceUtil.getOSGiServiceIdentifier();
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return MarketingEventAnnouncementServiceUtil.getMarketingEventAnnouncements(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return MarketingEventAnnouncementServiceUtil.getMarketingEventAnnouncements(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName82;
	private String[] _methodParameterTypes82;
}