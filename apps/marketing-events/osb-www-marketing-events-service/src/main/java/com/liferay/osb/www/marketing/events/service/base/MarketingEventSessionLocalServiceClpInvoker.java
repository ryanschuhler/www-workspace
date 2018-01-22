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

import com.liferay.osb.www.marketing.events.service.MarketingEventSessionLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class MarketingEventSessionLocalServiceClpInvoker {
	public MarketingEventSessionLocalServiceClpInvoker() {
		_methodName0 = "addMarketingEventSession";

		_methodParameterTypes0 = new String[] {
				"com.liferay.osb.www.marketing.events.model.MarketingEventSession"
			};

		_methodName1 = "createMarketingEventSession";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteMarketingEventSession";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteMarketingEventSession";

		_methodParameterTypes3 = new String[] {
				"com.liferay.osb.www.marketing.events.model.MarketingEventSession"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchMarketingEventSession";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchMarketingEventSessionByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "getMarketingEventSession";

		_methodParameterTypes12 = new String[] { "long" };

		_methodName13 = "getActionableDynamicQuery";

		_methodParameterTypes13 = new String[] {  };

		_methodName14 = "getIndexableActionableDynamicQuery";

		_methodParameterTypes14 = new String[] {  };

		_methodName16 = "getExportActionableDynamicQuery";

		_methodParameterTypes16 = new String[] {
				"com.liferay.exportimport.kernel.lar.PortletDataContext"
			};

		_methodName17 = "deletePersistedModel";

		_methodParameterTypes17 = new String[] {
				"com.liferay.portal.kernel.model.PersistedModel"
			};

		_methodName18 = "getPersistedModel";

		_methodParameterTypes18 = new String[] { "java.io.Serializable" };

		_methodName19 = "getMarketingEventSessionByUuidAndCompanyId";

		_methodParameterTypes19 = new String[] { "java.lang.String", "long" };

		_methodName20 = "getMarketingEventSessions";

		_methodParameterTypes20 = new String[] { "int", "int" };

		_methodName21 = "getMarketingEventSessionsCount";

		_methodParameterTypes21 = new String[] {  };

		_methodName22 = "updateMarketingEventSession";

		_methodParameterTypes22 = new String[] {
				"com.liferay.osb.www.marketing.events.model.MarketingEventSession"
			};

		_methodName23 = "addMarketingEventUserMarketingEventSession";

		_methodParameterTypes23 = new String[] { "long", "long" };

		_methodName24 = "addMarketingEventUserMarketingEventSession";

		_methodParameterTypes24 = new String[] {
				"long",
				"com.liferay.osb.www.marketing.events.model.MarketingEventSession"
			};

		_methodName25 = "addMarketingEventUserMarketingEventSessions";

		_methodParameterTypes25 = new String[] { "long", "long[][]" };

		_methodName26 = "addMarketingEventUserMarketingEventSessions";

		_methodParameterTypes26 = new String[] { "long", "java.util.List" };

		_methodName27 = "clearMarketingEventUserMarketingEventSessions";

		_methodParameterTypes27 = new String[] { "long" };

		_methodName28 = "deleteMarketingEventUserMarketingEventSession";

		_methodParameterTypes28 = new String[] { "long", "long" };

		_methodName29 = "deleteMarketingEventUserMarketingEventSession";

		_methodParameterTypes29 = new String[] {
				"long",
				"com.liferay.osb.www.marketing.events.model.MarketingEventSession"
			};

		_methodName30 = "deleteMarketingEventUserMarketingEventSessions";

		_methodParameterTypes30 = new String[] { "long", "long[][]" };

		_methodName31 = "deleteMarketingEventUserMarketingEventSessions";

		_methodParameterTypes31 = new String[] { "long", "java.util.List" };

		_methodName32 = "getMarketingEventUserPrimaryKeys";

		_methodParameterTypes32 = new String[] { "long" };

		_methodName33 = "getMarketingEventUserMarketingEventSessions";

		_methodParameterTypes33 = new String[] { "long" };

		_methodName34 = "getMarketingEventUserMarketingEventSessions";

		_methodParameterTypes34 = new String[] { "long", "int", "int" };

		_methodName35 = "getMarketingEventUserMarketingEventSessions";

		_methodParameterTypes35 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName36 = "getMarketingEventUserMarketingEventSessionsCount";

		_methodParameterTypes36 = new String[] { "long" };

		_methodName37 = "hasMarketingEventUserMarketingEventSession";

		_methodParameterTypes37 = new String[] { "long", "long" };

		_methodName38 = "hasMarketingEventUserMarketingEventSessions";

		_methodParameterTypes38 = new String[] { "long" };

		_methodName39 = "setMarketingEventUserMarketingEventSessions";

		_methodParameterTypes39 = new String[] { "long", "long[][]" };

		_methodName98 = "getOSGiServiceIdentifier";

		_methodParameterTypes98 = new String[] {  };

		_methodName103 = "addMarketingEventSession";

		_methodParameterTypes103 = new String[] {
				"long", "long", "long", "java.util.Map", "java.util.Map",
				"java.util.Map", "long", "java.lang.String", "int", "int", "int",
				"int", "int", "int", "int", "int", "int", "int", "int",
				"long[][]", "com.liferay.portal.kernel.service.ServiceContext"
			};

		_methodName104 = "deleteMarketingEventSession";

		_methodParameterTypes104 = new String[] { "long" };

		_methodName105 = "deleteMarketingEventSession";

		_methodParameterTypes105 = new String[] {
				"com.liferay.osb.www.marketing.events.model.MarketingEventSession"
			};

		_methodName106 = "getMarketingEventSessions";

		_methodParameterTypes106 = new String[] {
				"long", "int", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName107 = "getMarketingEventSessions";

		_methodParameterTypes107 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName108 = "getMarketingEventSessions";

		_methodParameterTypes108 = new String[] {
				"long[][]", "int[][]", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName109 = "getMarketingEventSessionsCount";

		_methodParameterTypes109 = new String[] { "long" };

		_methodName110 = "getMarketingEventSessionsCount";

		_methodParameterTypes110 = new String[] { "long", "long" };

		_methodName111 = "getMarketingEventSessionsMap";

		_methodParameterTypes111 = new String[] { "long", "boolean" };

		_methodName112 = "getMarketingEventSessionUsers";

		_methodParameterTypes112 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName113 = "updateMarketingEventSession";

		_methodParameterTypes113 = new String[] {
				"long", "long", "java.util.Map", "java.util.Map",
				"java.util.Map", "long", "java.lang.String", "int", "int", "int",
				"int", "int", "int", "int", "int", "int", "int", "int",
				"long[][]", "com.liferay.portal.kernel.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.addMarketingEventSession((com.liferay.osb.www.marketing.events.model.MarketingEventSession)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.createMarketingEventSession(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.deleteMarketingEventSession(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.deleteMarketingEventSession((com.liferay.osb.www.marketing.events.model.MarketingEventSession)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator<?>)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.fetchMarketingEventSession(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.fetchMarketingEventSessionByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.getMarketingEventSession(((Long)arguments[0]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.getActionableDynamicQuery();
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.getIndexableActionableDynamicQuery();
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.getExportActionableDynamicQuery((com.liferay.exportimport.kernel.lar.PortletDataContext)arguments[0]);
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.deletePersistedModel((com.liferay.portal.kernel.model.PersistedModel)arguments[0]);
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.getMarketingEventSessionByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.getMarketingEventSessions(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.getMarketingEventSessionsCount();
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.updateMarketingEventSession((com.liferay.osb.www.marketing.events.model.MarketingEventSession)arguments[0]);
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			MarketingEventSessionLocalServiceUtil.addMarketingEventUserMarketingEventSession(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			MarketingEventSessionLocalServiceUtil.addMarketingEventUserMarketingEventSession(((Long)arguments[0]).longValue(),
				(com.liferay.osb.www.marketing.events.model.MarketingEventSession)arguments[1]);

			return null;
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			MarketingEventSessionLocalServiceUtil.addMarketingEventUserMarketingEventSessions(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			MarketingEventSessionLocalServiceUtil.addMarketingEventUserMarketingEventSessions(((Long)arguments[0]).longValue(),
				(java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession>)arguments[1]);

			return null;
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			MarketingEventSessionLocalServiceUtil.clearMarketingEventUserMarketingEventSessions(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			MarketingEventSessionLocalServiceUtil.deleteMarketingEventUserMarketingEventSession(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			MarketingEventSessionLocalServiceUtil.deleteMarketingEventUserMarketingEventSession(((Long)arguments[0]).longValue(),
				(com.liferay.osb.www.marketing.events.model.MarketingEventSession)arguments[1]);

			return null;
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			MarketingEventSessionLocalServiceUtil.deleteMarketingEventUserMarketingEventSessions(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			MarketingEventSessionLocalServiceUtil.deleteMarketingEventUserMarketingEventSessions(((Long)arguments[0]).longValue(),
				(java.util.List<com.liferay.osb.www.marketing.events.model.MarketingEventSession>)arguments[1]);

			return null;
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.getMarketingEventUserPrimaryKeys(((Long)arguments[0]).longValue());
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.getMarketingEventUserMarketingEventSessions(((Long)arguments[0]).longValue());
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.getMarketingEventUserMarketingEventSessions(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.getMarketingEventUserMarketingEventSessions(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator<com.liferay.osb.www.marketing.events.model.MarketingEventSession>)arguments[3]);
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.getMarketingEventUserMarketingEventSessionsCount(((Long)arguments[0]).longValue());
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.hasMarketingEventUserMarketingEventSession(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.hasMarketingEventUserMarketingEventSessions(((Long)arguments[0]).longValue());
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			MarketingEventSessionLocalServiceUtil.setMarketingEventUserMarketingEventSessions(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.getOSGiServiceIdentifier();
		}

		if (_methodName103.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes103, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.addMarketingEventSession(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[3],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[4],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[5],
				((Long)arguments[6]).longValue(),
				(java.lang.String)arguments[7],
				((Integer)arguments[8]).intValue(),
				((Integer)arguments[9]).intValue(),
				((Integer)arguments[10]).intValue(),
				((Integer)arguments[11]).intValue(),
				((Integer)arguments[12]).intValue(),
				((Integer)arguments[13]).intValue(),
				((Integer)arguments[14]).intValue(),
				((Integer)arguments[15]).intValue(),
				((Integer)arguments[16]).intValue(),
				((Integer)arguments[17]).intValue(),
				((Integer)arguments[18]).intValue(), (long[])arguments[19],
				(com.liferay.portal.kernel.service.ServiceContext)arguments[20]);
		}

		if (_methodName104.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes104, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.deleteMarketingEventSession(((Long)arguments[0]).longValue());
		}

		if (_methodName105.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes105, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.deleteMarketingEventSession((com.liferay.osb.www.marketing.events.model.MarketingEventSession)arguments[0]);
		}

		if (_methodName106.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.getMarketingEventSessions(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[4]);
		}

		if (_methodName107.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes107, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.getMarketingEventSessions(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName108.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes108, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.getMarketingEventSessions((long[])arguments[0],
				(int[])arguments[1], ((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[4]);
		}

		if (_methodName109.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes109, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.getMarketingEventSessionsCount(((Long)arguments[0]).longValue());
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.getMarketingEventSessionsCount(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName111.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.getMarketingEventSessionsMap(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName112.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.getMarketingEventSessionUsers(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName113.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes113, parameterTypes)) {
			return MarketingEventSessionLocalServiceUtil.updateMarketingEventSession(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[2],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[3],
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[4],
				((Long)arguments[5]).longValue(),
				(java.lang.String)arguments[6],
				((Integer)arguments[7]).intValue(),
				((Integer)arguments[8]).intValue(),
				((Integer)arguments[9]).intValue(),
				((Integer)arguments[10]).intValue(),
				((Integer)arguments[11]).intValue(),
				((Integer)arguments[12]).intValue(),
				((Integer)arguments[13]).intValue(),
				((Integer)arguments[14]).intValue(),
				((Integer)arguments[15]).intValue(),
				((Integer)arguments[16]).intValue(),
				((Integer)arguments[17]).intValue(), (long[])arguments[18],
				(com.liferay.portal.kernel.service.ServiceContext)arguments[19]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName20;
	private String[] _methodParameterTypes20;
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
	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName27;
	private String[] _methodParameterTypes27;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName34;
	private String[] _methodParameterTypes34;
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName36;
	private String[] _methodParameterTypes36;
	private String _methodName37;
	private String[] _methodParameterTypes37;
	private String _methodName38;
	private String[] _methodParameterTypes38;
	private String _methodName39;
	private String[] _methodParameterTypes39;
	private String _methodName98;
	private String[] _methodParameterTypes98;
	private String _methodName103;
	private String[] _methodParameterTypes103;
	private String _methodName104;
	private String[] _methodParameterTypes104;
	private String _methodName105;
	private String[] _methodParameterTypes105;
	private String _methodName106;
	private String[] _methodParameterTypes106;
	private String _methodName107;
	private String[] _methodParameterTypes107;
	private String _methodName108;
	private String[] _methodParameterTypes108;
	private String _methodName109;
	private String[] _methodParameterTypes109;
	private String _methodName110;
	private String[] _methodParameterTypes110;
	private String _methodName111;
	private String[] _methodParameterTypes111;
	private String _methodName112;
	private String[] _methodParameterTypes112;
	private String _methodName113;
	private String[] _methodParameterTypes113;
}