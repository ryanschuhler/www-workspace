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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link MarketingEventServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventServiceSoap
 * @see HttpPrincipal
 * @see MarketingEventServiceUtil
 * @generated
 */
@ProviderType
public class MarketingEventServiceHttp {
	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEvent> getMarketingEvents(
		HttpPrincipal httpPrincipal, int type, java.util.Date startDate,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(MarketingEventServiceUtil.class,
					"getMarketingEvents", _getMarketingEventsParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, type,
					startDate, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEvent>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEvent> getMarketingEvents(
		HttpPrincipal httpPrincipal, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(MarketingEventServiceUtil.class,
					"getMarketingEvents", _getMarketingEventsParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, type,
					start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEvent>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEvent> getMarketingEvents(
		HttpPrincipal httpPrincipal, int[] types, int[] globalRegions,
		long[] countryIds, int[] locationTypes, boolean pastEvents,
		java.lang.String userLanguageId, java.lang.String orderByCol,
		java.lang.String orderByType)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(MarketingEventServiceUtil.class,
					"getMarketingEvents", _getMarketingEventsParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, types,
					globalRegions, countryIds, locationTypes, pastEvents,
					userLanguageId, orderByCol, orderByType);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEvent>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(MarketingEventServiceHttp.class);
	private static final Class<?>[] _getMarketingEventsParameterTypes0 = new Class[] {
			int.class, java.util.Date.class, int.class, int.class
		};
	private static final Class<?>[] _getMarketingEventsParameterTypes1 = new Class[] {
			int.class, int.class, int.class
		};
	private static final Class<?>[] _getMarketingEventsParameterTypes2 = new Class[] {
			int[].class, int[].class, long[].class, int[].class, boolean.class,
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class
		};
}