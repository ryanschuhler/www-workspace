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
public class HSContactLocalServiceClp implements HSContactLocalService {
	public HSContactLocalServiceClp(InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

		_methodName0 = "addHSContact";

		_methodParameterTypes0 = new String[] {
				"long", "java.lang.String", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName1 = "fetchHSContactByEmailAddress";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName2 = "fetchHSContactByUserToken";

		_methodParameterTypes2 = new String[] { "java.lang.String" };

		_methodName3 = "fetchHSContactByVisitorId";

		_methodParameterTypes3 = new String[] { "long" };

		_methodName4 = "getHSContactByEmailAddress";

		_methodParameterTypes4 = new String[] { "java.lang.String" };

		_methodName5 = "getHSContactByUserToken";

		_methodParameterTypes5 = new String[] { "java.lang.String" };

		_methodName6 = "getHSContactByVisitorId";

		_methodParameterTypes6 = new String[] { "long" };

		_methodName7 = "updateHSContact";

		_methodParameterTypes7 = new String[] {
				"long", "java.lang.String", "long", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName8 = "updateHSContact";

		_methodParameterTypes8 = new String[] {
				"long", "java.lang.String", "long", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName9 = "getAllHSContactSummaries";

		_methodParameterTypes9 = new String[] { "int", "int" };

		_methodName10 = "getRecentHSContactSummaries";

		_methodParameterTypes10 = new String[] { "int", "int", "int" };

		_methodName11 = "search";

		_methodParameterTypes11 = new String[] { "java.lang.String", "int", "int" };

		_methodName13 = "getOSGiServiceIdentifier";

		_methodParameterTypes13 = new String[] {  };

		_methodName14 = "deleteHSContact";

		_methodParameterTypes14 = new String[] { "long", "long", "long" };
	}

	@Override
	public com.liferay.hubspot.model.HSContact addHSContact(long companyId,
		java.lang.String className, long classPK,
		java.lang.String emailAddress, java.lang.String firstName,
		java.lang.String lastName, java.lang.String phoneNumber,
		java.lang.String street, java.lang.String city,
		java.lang.String region, java.lang.String postalCode,
		java.lang.String country, java.lang.String jobTitle,
		java.lang.String twitterUserName, java.lang.String websiteURL,
		java.lang.String notes, java.lang.String lifeCycleStage,
		java.lang.String persona, java.lang.String sfLeadCountry,
		java.lang.String sfLeadIndustry, java.lang.String sfLeadCompany,
		java.lang.String sfLeadDepartment, java.lang.String sfLeadRole,
		java.lang.String sfLeadSource)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName0,
					_methodParameterTypes0,
					new Object[] {
						companyId,
						
					ClpSerializer.translateInput(className),
						
					classPK,
						
					ClpSerializer.translateInput(emailAddress),
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(phoneNumber),
						
					ClpSerializer.translateInput(street),
						
					ClpSerializer.translateInput(city),
						
					ClpSerializer.translateInput(region),
						
					ClpSerializer.translateInput(postalCode),
						
					ClpSerializer.translateInput(country),
						
					ClpSerializer.translateInput(jobTitle),
						
					ClpSerializer.translateInput(twitterUserName),
						
					ClpSerializer.translateInput(websiteURL),
						
					ClpSerializer.translateInput(notes),
						
					ClpSerializer.translateInput(lifeCycleStage),
						
					ClpSerializer.translateInput(persona),
						
					ClpSerializer.translateInput(sfLeadCountry),
						
					ClpSerializer.translateInput(sfLeadIndustry),
						
					ClpSerializer.translateInput(sfLeadCompany),
						
					ClpSerializer.translateInput(sfLeadDepartment),
						
					ClpSerializer.translateInput(sfLeadRole),
						
					ClpSerializer.translateInput(sfLeadSource)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.hubspot.model.HSContact)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.hubspot.model.HSContact fetchHSContactByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.PortalException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName1,
					_methodParameterTypes1,
					new Object[] { ClpSerializer.translateInput(emailAddress) });
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

		return (com.liferay.hubspot.model.HSContact)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.hubspot.model.HSContact fetchHSContactByUserToken(
		java.lang.String userToken)
		throws com.liferay.portal.kernel.exception.PortalException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName2,
					_methodParameterTypes2,
					new Object[] { ClpSerializer.translateInput(userToken) });
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

		return (com.liferay.hubspot.model.HSContact)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.hubspot.model.HSContact fetchHSContactByVisitorId(
		long visitorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3, new Object[] { visitorId });
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

		return (com.liferay.hubspot.model.HSContact)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.hubspot.model.HSContact getHSContactByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.PortalException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName4,
					_methodParameterTypes4,
					new Object[] { ClpSerializer.translateInput(emailAddress) });
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

		return (com.liferay.hubspot.model.HSContact)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.hubspot.model.HSContact getHSContactByUserToken(
		java.lang.String userToken)
		throws com.liferay.portal.kernel.exception.PortalException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] { ClpSerializer.translateInput(userToken) });
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

		return (com.liferay.hubspot.model.HSContact)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.hubspot.model.HSContact getHSContactByVisitorId(
		long visitorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName6,
					_methodParameterTypes6, new Object[] { visitorId });
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

		return (com.liferay.hubspot.model.HSContact)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.hubspot.model.HSContact updateHSContact(long companyId,
		java.lang.String className, long classPK, long visitorId,
		java.lang.String emailAddress, java.lang.String firstName,
		java.lang.String lastName, java.lang.String phoneNumber,
		java.lang.String street, java.lang.String city,
		java.lang.String region, java.lang.String postalCode,
		java.lang.String country, java.lang.String jobTitle,
		java.lang.String twitterUserName, java.lang.String websiteURL,
		java.lang.String notes, java.lang.String lifeCycleStage,
		java.lang.String persona, java.lang.String sfLeadCountry,
		java.lang.String sfLeadIndustry, java.lang.String sfLeadCompany,
		java.lang.String sfLeadDepartment, java.lang.String sfLeadRole,
		java.lang.String sfLeadSource)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] {
						companyId,
						
					ClpSerializer.translateInput(className),
						
					classPK,
						
					visitorId,
						
					ClpSerializer.translateInput(emailAddress),
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(phoneNumber),
						
					ClpSerializer.translateInput(street),
						
					ClpSerializer.translateInput(city),
						
					ClpSerializer.translateInput(region),
						
					ClpSerializer.translateInput(postalCode),
						
					ClpSerializer.translateInput(country),
						
					ClpSerializer.translateInput(jobTitle),
						
					ClpSerializer.translateInput(twitterUserName),
						
					ClpSerializer.translateInput(websiteURL),
						
					ClpSerializer.translateInput(notes),
						
					ClpSerializer.translateInput(lifeCycleStage),
						
					ClpSerializer.translateInput(persona),
						
					ClpSerializer.translateInput(sfLeadCountry),
						
					ClpSerializer.translateInput(sfLeadIndustry),
						
					ClpSerializer.translateInput(sfLeadCompany),
						
					ClpSerializer.translateInput(sfLeadDepartment),
						
					ClpSerializer.translateInput(sfLeadRole),
						
					ClpSerializer.translateInput(sfLeadSource)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.hubspot.model.HSContact)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.hubspot.model.HSContact updateHSContact(long companyId,
		java.lang.String className, long classPK, long visitorId,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String phoneNumber, java.lang.String street,
		java.lang.String city, java.lang.String region,
		java.lang.String postalCode, java.lang.String country,
		java.lang.String jobTitle, java.lang.String twitterUserName,
		java.lang.String websiteURL, java.lang.String persona)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] {
						companyId,
						
					ClpSerializer.translateInput(className),
						
					classPK,
						
					visitorId,
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(lastName),
						
					ClpSerializer.translateInput(phoneNumber),
						
					ClpSerializer.translateInput(street),
						
					ClpSerializer.translateInput(city),
						
					ClpSerializer.translateInput(region),
						
					ClpSerializer.translateInput(postalCode),
						
					ClpSerializer.translateInput(country),
						
					ClpSerializer.translateInput(jobTitle),
						
					ClpSerializer.translateInput(twitterUserName),
						
					ClpSerializer.translateInput(websiteURL),
						
					ClpSerializer.translateInput(persona)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.hubspot.model.HSContact)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.messaging.Message getAllHSContactSummaries(
		int contactOffset, int count)
		throws com.liferay.portal.kernel.exception.PortalException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] { contactOffset, count });
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

		return (com.liferay.portal.kernel.messaging.Message)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.messaging.Message getRecentHSContactSummaries(
		int contactOffset, int timeOffset, int count)
		throws com.liferay.portal.kernel.exception.PortalException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName10,
					_methodParameterTypes10,
					new Object[] { contactOffset, timeOffset, count });
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

		return (com.liferay.portal.kernel.messaging.Message)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.messaging.Message search(
		java.lang.String query, int offset, int count)
		throws com.liferay.portal.kernel.exception.PortalException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName11,
					_methodParameterTypes11,
					new Object[] {
						ClpSerializer.translateInput(query),
						
					offset,
						
					count
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

		return (com.liferay.portal.kernel.messaging.Message)ClpSerializer.translateOutput(returnObj);
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
			returnObj = _invokableLocalService.invokeMethod(_methodName13,
					_methodParameterTypes13, new Object[] {  });
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
	public void deleteHSContact(long companyId, long userId, long visitorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName14,
				_methodParameterTypes14,
				new Object[] { companyId, userId, visitorId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
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
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
}