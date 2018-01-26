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

package com.liferay.osb.www.marketing.events.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osb.www.marketing.events.service.MarketingEventServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link MarketingEventServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.osb.www.marketing.events.model.MarketingEventSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.osb.www.marketing.events.model.MarketingEvent}, that is translated to a
 * {@link com.liferay.osb.www.marketing.events.model.MarketingEventSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventServiceHttp
 * @see com.liferay.osb.www.marketing.events.model.MarketingEventSoap
 * @see MarketingEventServiceUtil
 * @generated
 */
@ProviderType
public class MarketingEventServiceSoap {
	public static com.liferay.osb.www.marketing.events.model.MarketingEventSoap[] getMarketingEvents(
		int type, java.util.Date startDate, int start, int end)
		throws RemoteException {
		try {
			java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEvent> returnValue =
				MarketingEventServiceUtil.getMarketingEvents(type, startDate,
					start, end);

			return com.liferay.osb.www.marketing.events.model.MarketingEventSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.osb.www.marketing.events.model.MarketingEventSoap[] getMarketingEvents(
		int type, int start, int end) throws RemoteException {
		try {
			java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEvent> returnValue =
				MarketingEventServiceUtil.getMarketingEvents(type, start, end);

			return com.liferay.osb.www.marketing.events.model.MarketingEventSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.osb.www.marketing.events.model.MarketingEventSoap[] getMarketingEvents(
		int[] types, int[] globalRegions, long[] countryIds,
		int[] locationTypes, boolean pastEvents,
		java.lang.String userLanguageId, java.lang.String orderByCol,
		java.lang.String orderByType) throws RemoteException {
		try {
			java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEvent> returnValue =
				MarketingEventServiceUtil.getMarketingEvents(types,
					globalRegions, countryIds, locationTypes, pastEvents,
					userLanguageId, orderByCol, orderByType);

			return com.liferay.osb.www.marketing.events.model.MarketingEventSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(MarketingEventServiceSoap.class);
}