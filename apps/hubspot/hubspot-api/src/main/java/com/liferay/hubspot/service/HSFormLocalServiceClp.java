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

package com.liferay.hubspot.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.InvokableLocalService;

/**
 * @author Peter Shin
 * @generated
 */
@ProviderType
public class HSFormLocalServiceClp implements HSFormLocalService {
	public HSFormLocalServiceClp(InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

		_methodName0 = "fetchHSFormByGUID";

		_methodParameterTypes0 = new String[] { "java.lang.String" };

		_methodName1 = "getHSFormByGUID";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName2 = "submitHSForm";

		_methodParameterTypes2 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String[][]"
			};

		_methodName3 = "submitHSForm";

		_methodParameterTypes3 = new String[] {
				"java.lang.String", "java.lang.String[][]"
			};

		_methodName5 = "getOSGiServiceIdentifier";

		_methodParameterTypes5 = new String[] {  };

		_methodName6 = "getAllHSForms";

		_methodParameterTypes6 = new String[] {  };
	}

	@Override
	public com.liferay.hubspot.model.HSForm fetchHSFormByGUID(
		java.lang.String guid)
		throws com.liferay.portal.kernel.exception.PortalException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName0,
					_methodParameterTypes0,
					new Object[] { ClpSerializer.translateInput(guid) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.hubspot.model.HSForm)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.hubspot.model.HSForm getHSFormByGUID(
		java.lang.String guid)
		throws com.liferay.portal.kernel.exception.PortalException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName1,
					_methodParameterTypes1,
					new Object[] { ClpSerializer.translateInput(guid) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.hubspot.model.HSForm)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.hubspot.model.HSForm submitHSForm(
		java.lang.String guid, java.lang.String userToken,
		java.lang.String ipAddress, java.lang.String pageURL,
		java.lang.String pageName, java.lang.String redirectURL,
		java.lang.String salesforceCampaignId, java.lang.String[] fields)
		throws com.liferay.portal.kernel.exception.PortalException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName2,
					_methodParameterTypes2,
					new Object[] {
						ClpSerializer.translateInput(guid),
						
					ClpSerializer.translateInput(userToken),
						
					ClpSerializer.translateInput(ipAddress),
						
					ClpSerializer.translateInput(pageURL),
						
					ClpSerializer.translateInput(pageName),
						
					ClpSerializer.translateInput(redirectURL),
						
					ClpSerializer.translateInput(salesforceCampaignId),
						
					ClpSerializer.translateInput(fields)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.hubspot.model.HSForm)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.hubspot.model.HSForm submitHSForm(
		java.lang.String guid, java.lang.String[] fields)
		throws com.liferay.portal.kernel.exception.PortalException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] {
						ClpSerializer.translateInput(guid),
						
					ClpSerializer.translateInput(fields)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.hubspot.model.HSForm)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName5,
					_methodParameterTypes5, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.hubspot.model.HSForm> getAllHSForms()
		throws com.liferay.portal.kernel.exception.PortalException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName6,
					_methodParameterTypes6, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.hubspot.model.HSForm>)ClpSerializer.translateOutput(returnObj);
	}

	private InvokableLocalService _invokableLocalService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
}