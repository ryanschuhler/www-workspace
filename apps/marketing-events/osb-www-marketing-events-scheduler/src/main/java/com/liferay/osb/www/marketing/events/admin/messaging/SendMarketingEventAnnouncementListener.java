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

package com.liferay.osb.www.marketing.events.admin.messaging;

import com.liferay.mobile.fcm.Condition;
import com.liferay.mobile.fcm.Notification;
import com.liferay.mobile.fcm.Sender;
import com.liferay.mobile.fcm.Status;
import com.liferay.mobile.fcm.Topic;
import com.liferay.osb.www.marketing.events.configuration.MarketingEventsConfiguration;
import com.liferay.osb.www.marketing.events.model.MarketingEvent;
import com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement;
import com.liferay.osb.www.marketing.events.model.MarketingEventConstants;
import com.liferay.osb.www.marketing.events.service.MarketingEventAnnouncementLocalService;
import com.liferay.osb.www.marketing.events.service.MarketingEventLocalService;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ryan Schuhler
 * @author Allen Ziegenfus
 */
@Component(
	configurationPid = "com.liferay.osb.www.marketing.events.configuration.MarketingEventsConfiguration",
	configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
	service = SendMarketingEventAnnouncementListener.class
)
public class SendMarketingEventAnnouncementListener
	extends BaseMessageListener {

	@Activate
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(
			MarketingEventsConfiguration.class, properties);

		Class<?> clazz = getClass();

		String className = clazz.getName();

		Trigger trigger = _triggerFactory.createTrigger(
			className, className, null, null,
			_configuration.announcementSendInterval(), TimeUnit.MINUTE);

		//TODO move to new syntax somehow...
		SchedulerEntryImpl schedulerEntry = new SchedulerEntryImpl();

		schedulerEntry.setEventListenerClass(className);
		schedulerEntry.setTrigger(trigger);

		_schedulerEngineHelper.register(
			this, schedulerEntry, DestinationNames.SCHEDULER_DISPATCH);
	}

	@Deactivate
	protected void deactivate() {
		_schedulerEngineHelper.unregister(this);
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		if (_log.isInfoEnabled()) {
			_log.info("Checking for notifications to send");
		}

		Date now = new Date();

		List<MarketingEventAnnouncement> marketingEventAnnouncements =
			new ArrayList<>();

		List<MarketingEvent> marketingEvents =
			_marketingEventLocalService.getMarketingEvents(
				MarketingEventConstants.TYPE_CONFERENCE, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null);

		for (MarketingEvent marketingEvent : marketingEvents) {
			if (marketingEvent.getSiteGroupId() <= 0) {
				continue;
			}

			marketingEventAnnouncements.addAll(
				_marketingEventAnnouncementLocalService.
					getMarketingEventAnnouncements(
						marketingEvent.getMarketingEventId(), now,
						WorkflowConstants.STATUS_SCHEDULED, QueryUtil.ALL_POS,
						QueryUtil.ALL_POS, null));
		}

		for (MarketingEventAnnouncement marketingEventAnnouncement :
				marketingEventAnnouncements) {

			sendNotification(marketingEventAnnouncement);

			_marketingEventAnnouncementLocalService.updateStatus(
				marketingEventAnnouncement.getUserId(),
				marketingEventAnnouncement.getMarketingEventAnnouncementId(),
				WorkflowConstants.STATUS_APPROVED, new ServiceContext());
		}
	}

	protected void sendNotification(
			MarketingEventAnnouncement marketingEventAnnouncement)
		throws Exception {

		Notification.Builder builder = new Notification.Builder();

		builder.body(marketingEventAnnouncement.getSummary());
		builder.title(marketingEventAnnouncement.getTitle());

		Notification notification = builder.build();

		long marketingEventId =
			marketingEventAnnouncement.getMarketingEventId();

		Topic topic = new Topic(String.valueOf(marketingEventId));

		Map<String, String> data = new HashMap<>();

		data.put(
			"image_url", marketingEventAnnouncement.getImageFileEntryURL());
		data.put("link_label", marketingEventAnnouncement.getLinkLabel());
		data.put("link_url", marketingEventAnnouncement.getLinkURL());
		data.put("marketingEventId", String.valueOf(marketingEventId));
		data.put("message", marketingEventAnnouncement.getMessage());

		Status status = _sendMessage(topic, data, notification);

		if (!status.isSuccessful()) {
			_log.error(
				"Unable to send notification: " + status.httpStatusCode());

			return;
		}

		Map<String, String> messageData = new HashMap<>();

		messageData.put("marketingEventId", String.valueOf(marketingEventId));
		messageData.put("type", "newsfeed");

		status = _sendMessage(topic, messageData, null);

		if (!status.isSuccessful()) {
			_log.error("Unable to send message: " + status.httpStatusCode());
		}
	}

	@Reference(unbind = "-")
	protected void setMarketingEventAnnouncementLocalService(
		MarketingEventAnnouncementLocalService
			marketingEventAnnouncementLocalService) {

		_marketingEventAnnouncementLocalService =
			marketingEventAnnouncementLocalService;
	}

	@Reference(unbind = "-")
	protected void setMarketingEventLocalService(
		MarketingEventLocalService marketingEventLocalService) {

		_marketingEventLocalService = marketingEventLocalService;
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(
		ModuleServiceLifecycle moduleServiceLifecycle) {
	}

	@Reference(unbind = "-")
	protected void setSchedulerEngineHelper(
		SchedulerEngineHelper schedulerEngineHelper) {

		_schedulerEngineHelper = schedulerEngineHelper;
	}

	private Status _sendMessage(
			Topic topic, Map<String, String> data, Notification notification)
		throws Exception {

		com.liferay.mobile.fcm.Message.Builder builder =
			new com.liferay.mobile.fcm.Message.Builder();

		builder.data(data);
		builder.priority(com.liferay.mobile.fcm.Message.Priority.HIGH);

		if (notification != null) {
			builder.notification(notification);
			builder.to(topic);
		}
		else {
			Condition condition = new Condition(topic);

			condition.and(new Topic("iOS"));

			builder.condition(condition);

			builder.contentAvailable(true);
		}

		com.liferay.mobile.fcm.Message fcmMessage = builder.build();

		Sender sender = new Sender(_configuration.firebaseServerKey());

		return sender.send(fcmMessage);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		SendMarketingEventAnnouncementListener.class);

	private volatile MarketingEventsConfiguration _configuration;
	private MarketingEventAnnouncementLocalService
		_marketingEventAnnouncementLocalService;
	private MarketingEventLocalService _marketingEventLocalService;
	private SchedulerEngineHelper _schedulerEngineHelper;

	@Reference
	private TriggerFactory _triggerFactory;

}