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

package com.liferay.osb.www.marketing.events.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncementClp;
import com.liferay.osb.www.marketing.events.model.MarketingEventClp;
import com.liferay.osb.www.marketing.events.model.MarketingEventSessionClp;
import com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoomClp;
import com.liferay.osb.www.marketing.events.model.MarketingEventSponsorClp;
import com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevelClp;
import com.liferay.osb.www.marketing.events.model.MarketingEventUserClp;
import com.liferay.osb.www.marketing.events.model.SocialLinkClp;
import com.liferay.osb.www.marketing.events.model.SocialLinkTypeClp;

import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
					"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
					new Class<?>[] {String.class});

				String portletPropsServletContextName = (String)getMethod.invoke(null,
					"osb-www-marketing-events-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
						"osb-www-marketing-events-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "osb-www-marketing-events-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(MarketingEventClp.class.getName())) {
			return translateInputMarketingEvent(oldModel);
		}

		if (oldModelClassName.equals(
					MarketingEventAnnouncementClp.class.getName())) {
			return translateInputMarketingEventAnnouncement(oldModel);
		}

		if (oldModelClassName.equals(MarketingEventSessionClp.class.getName())) {
			return translateInputMarketingEventSession(oldModel);
		}

		if (oldModelClassName.equals(
					MarketingEventSessionRoomClp.class.getName())) {
			return translateInputMarketingEventSessionRoom(oldModel);
		}

		if (oldModelClassName.equals(MarketingEventSponsorClp.class.getName())) {
			return translateInputMarketingEventSponsor(oldModel);
		}

		if (oldModelClassName.equals(
					MarketingEventSponsorLevelClp.class.getName())) {
			return translateInputMarketingEventSponsorLevel(oldModel);
		}

		if (oldModelClassName.equals(MarketingEventUserClp.class.getName())) {
			return translateInputMarketingEventUser(oldModel);
		}

		if (oldModelClassName.equals(SocialLinkClp.class.getName())) {
			return translateInputSocialLink(oldModel);
		}

		if (oldModelClassName.equals(SocialLinkTypeClp.class.getName())) {
			return translateInputSocialLinkType(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputMarketingEvent(BaseModel<?> oldModel) {
		MarketingEventClp oldClpModel = (MarketingEventClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMarketingEventRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMarketingEventAnnouncement(
		BaseModel<?> oldModel) {
		MarketingEventAnnouncementClp oldClpModel = (MarketingEventAnnouncementClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMarketingEventAnnouncementRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMarketingEventSession(
		BaseModel<?> oldModel) {
		MarketingEventSessionClp oldClpModel = (MarketingEventSessionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMarketingEventSessionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMarketingEventSessionRoom(
		BaseModel<?> oldModel) {
		MarketingEventSessionRoomClp oldClpModel = (MarketingEventSessionRoomClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMarketingEventSessionRoomRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMarketingEventSponsor(
		BaseModel<?> oldModel) {
		MarketingEventSponsorClp oldClpModel = (MarketingEventSponsorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMarketingEventSponsorRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMarketingEventSponsorLevel(
		BaseModel<?> oldModel) {
		MarketingEventSponsorLevelClp oldClpModel = (MarketingEventSponsorLevelClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMarketingEventSponsorLevelRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMarketingEventUser(BaseModel<?> oldModel) {
		MarketingEventUserClp oldClpModel = (MarketingEventUserClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMarketingEventUserRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSocialLink(BaseModel<?> oldModel) {
		SocialLinkClp oldClpModel = (SocialLinkClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSocialLinkRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSocialLinkType(BaseModel<?> oldModel) {
		SocialLinkTypeClp oldClpModel = (SocialLinkTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSocialLinkTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.liferay.osb.www.marketing.events.model.impl.MarketingEventImpl")) {
			return translateOutputMarketingEvent(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
					"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
					BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
					oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
					oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.osb.www.marketing.events.model.impl.MarketingEventAnnouncementImpl")) {
			return translateOutputMarketingEventAnnouncement(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
					"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
					BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
					oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
					oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.osb.www.marketing.events.model.impl.MarketingEventSessionImpl")) {
			return translateOutputMarketingEventSession(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
					"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
					BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
					oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
					oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.osb.www.marketing.events.model.impl.MarketingEventSessionRoomImpl")) {
			return translateOutputMarketingEventSessionRoom(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
					"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
					BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
					oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
					oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.osb.www.marketing.events.model.impl.MarketingEventSponsorImpl")) {
			return translateOutputMarketingEventSponsor(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
					"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
					BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
					oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
					oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.osb.www.marketing.events.model.impl.MarketingEventSponsorLevelImpl")) {
			return translateOutputMarketingEventSponsorLevel(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
					"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
					BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
					oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
					oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.osb.www.marketing.events.model.impl.MarketingEventUserImpl")) {
			return translateOutputMarketingEventUser(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
					"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
					BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
					oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
					oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.osb.www.marketing.events.model.impl.SocialLinkImpl")) {
			return translateOutputSocialLink(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
					"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
					BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
					oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
					oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.osb.www.marketing.events.model.impl.SocialLinkTypeImpl")) {
			return translateOutputSocialLinkType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
					"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
					BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
					oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
					oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			ObjectInputStream objectInputStream = null;
			ObjectOutputStream objectOutputStream = null;

			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();

				objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
					0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
					contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				return throwable;
			}
			catch (ClassNotFoundException cnfe) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
			finally {
				if (objectOutputStream != null) {
					try {
						objectOutputStream.close();
					}
					catch (Throwable throwable2) {
						_log.error(throwable2, throwable2);

						return throwable2;
					}
				}

				if (objectInputStream != null) {
					try {
						objectInputStream.close();
					}
					catch (Throwable throwable2) {
						_log.error(throwable2, throwable2);

						return throwable2;
					}
				}
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.DuplicateSiteGroupException")) {
			return new com.liferay.osb.www.marketing.events.exception.DuplicateSiteGroupException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.DuplicateSocialLinkTypeException")) {
			return new com.liferay.osb.www.marketing.events.exception.DuplicateSocialLinkTypeException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementDisplayDateException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementDisplayDateException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementLinkLabelException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementLinkLabelException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementLinkURLException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementLinkURLException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementMessageException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementMessageException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementTitleException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementTitleException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventEndDateException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventEndDateException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventHostedByException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventHostedByException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventHostedByURLException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventHostedByURLException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventRegistrationURLException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventRegistrationURLException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventSessionEndDateException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventSessionEndDateException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventSessionRoomNameException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventSessionRoomNameException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventSessionStartDateException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventSessionStartDateException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventSessionTitleException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventSessionTitleException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventSessionVideoURLException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventSessionVideoURLException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventSponsorLevelNameException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventSponsorLevelNameException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventSponsorMarketingEventSponsorLevelIdException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventSponsorMarketingEventSponsorLevelIdException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventSponsorNameException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventSponsorNameException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventStartDateException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventStartDateException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventTitleException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventTitleException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventTitleURLException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventTitleURLException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventUserCompanyException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventUserCompanyException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventUserFirstNameException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventUserFirstNameException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventUserLastNameException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventUserLastNameException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventUserPhoneNumberException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventUserPhoneNumberException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.MarketingEventVideoTitleException")) {
			return new com.liferay.osb.www.marketing.events.exception.MarketingEventVideoTitleException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.RequiredMarketingEventSessionRoomException")) {
			return new com.liferay.osb.www.marketing.events.exception.RequiredMarketingEventSessionRoomException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.RequiredMarketingEventSponsorLevelException")) {
			return new com.liferay.osb.www.marketing.events.exception.RequiredMarketingEventSponsorLevelException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.RequiredMarketingEventUserException")) {
			return new com.liferay.osb.www.marketing.events.exception.RequiredMarketingEventUserException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.RequiredSocialLinkTypeException")) {
			return new com.liferay.osb.www.marketing.events.exception.RequiredSocialLinkTypeException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.SocialLinkTypeNameException")) {
			return new com.liferay.osb.www.marketing.events.exception.SocialLinkTypeNameException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.SocialLinkURLException")) {
			return new com.liferay.osb.www.marketing.events.exception.SocialLinkURLException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventException")) {
			return new com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventAnnouncementException")) {
			return new com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventAnnouncementException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionException")) {
			return new com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionRoomException")) {
			return new com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSessionRoomException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSponsorException")) {
			return new com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSponsorException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSponsorLevelException")) {
			return new com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventSponsorLevelException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventUserException")) {
			return new com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventUserException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.NoSuchSocialLinkException")) {
			return new com.liferay.osb.www.marketing.events.exception.NoSuchSocialLinkException(throwable.getMessage(),
				throwable.getCause());
		}

		if (className.equals(
					"com.liferay.osb.www.marketing.events.exception.NoSuchSocialLinkTypeException")) {
			return new com.liferay.osb.www.marketing.events.exception.NoSuchSocialLinkTypeException(throwable.getMessage(),
				throwable.getCause());
		}

		return throwable;
	}

	public static Object translateOutputMarketingEvent(BaseModel<?> oldModel) {
		MarketingEventClp newModel = new MarketingEventClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMarketingEventRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMarketingEventAnnouncement(
		BaseModel<?> oldModel) {
		MarketingEventAnnouncementClp newModel = new MarketingEventAnnouncementClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMarketingEventAnnouncementRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMarketingEventSession(
		BaseModel<?> oldModel) {
		MarketingEventSessionClp newModel = new MarketingEventSessionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMarketingEventSessionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMarketingEventSessionRoom(
		BaseModel<?> oldModel) {
		MarketingEventSessionRoomClp newModel = new MarketingEventSessionRoomClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMarketingEventSessionRoomRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMarketingEventSponsor(
		BaseModel<?> oldModel) {
		MarketingEventSponsorClp newModel = new MarketingEventSponsorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMarketingEventSponsorRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMarketingEventSponsorLevel(
		BaseModel<?> oldModel) {
		MarketingEventSponsorLevelClp newModel = new MarketingEventSponsorLevelClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMarketingEventSponsorLevelRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMarketingEventUser(
		BaseModel<?> oldModel) {
		MarketingEventUserClp newModel = new MarketingEventUserClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMarketingEventUserRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSocialLink(BaseModel<?> oldModel) {
		SocialLinkClp newModel = new SocialLinkClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSocialLinkRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSocialLinkType(BaseModel<?> oldModel) {
		SocialLinkTypeClp newModel = new SocialLinkTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSocialLinkTypeRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}