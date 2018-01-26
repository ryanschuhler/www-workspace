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

package com.liferay.osb.www.marketing.events.admin.portlet;

import com.liferay.asset.kernel.exception.AssetCategoryException;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.journal.util.JournalContent;
import com.liferay.osb.www.marketing.events.configuration.MarketingEventsConfiguration;
import com.liferay.osb.www.marketing.events.constants.OSBWWWMarketingEventsPortletKeys;
import com.liferay.osb.www.marketing.events.exception.DuplicateSiteGroupException;
import com.liferay.osb.www.marketing.events.exception.DuplicateSocialLinkTypeException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementDisplayDateException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementLinkLabelException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementLinkURLException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementMessageException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementTitleException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventEndDateException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventHostedByException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventHostedByURLException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventRegistrationURLException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventSessionRoomNameException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventSessionStartDateException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventSessionTitleException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventSessionVideoURLException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventSponsorLevelNameException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventSponsorNameException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventStartDateException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventTitleException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventTitleURLException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventUserCompanyException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventUserFirstNameException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventUserLastNameException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventUserPhoneNumberException;
import com.liferay.osb.www.marketing.events.exception.MarketingEventVideoTitleException;
import com.liferay.osb.www.marketing.events.exception.RequiredMarketingEventSessionRoomException;
import com.liferay.osb.www.marketing.events.exception.RequiredMarketingEventSponsorLevelException;
import com.liferay.osb.www.marketing.events.exception.RequiredMarketingEventUserException;
import com.liferay.osb.www.marketing.events.exception.RequiredSocialLinkTypeException;
import com.liferay.osb.www.marketing.events.exception.SocialLinkURLException;
import com.liferay.osb.www.marketing.events.model.MarketingEvent;
import com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement;
import com.liferay.osb.www.marketing.events.model.MarketingEventSession;
import com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom;
import com.liferay.osb.www.marketing.events.model.MarketingEventSponsor;
import com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel;
import com.liferay.osb.www.marketing.events.model.MarketingEventUser;
import com.liferay.osb.www.marketing.events.service.MarketingEventAnnouncementLocalServiceUtil;
import com.liferay.osb.www.marketing.events.service.MarketingEventLocalServiceUtil;
import com.liferay.osb.www.marketing.events.service.MarketingEventSessionLocalServiceUtil;
import com.liferay.osb.www.marketing.events.service.MarketingEventSessionRoomLocalServiceUtil;
import com.liferay.osb.www.marketing.events.service.MarketingEventSponsorLevelLocalServiceUtil;
import com.liferay.osb.www.marketing.events.service.MarketingEventSponsorLocalServiceUtil;
import com.liferay.osb.www.marketing.events.service.MarketingEventUserLocalServiceUtil;
import com.liferay.osb.www.marketing.events.service.SocialLinkLocalServiceUtil;
import com.liferay.osb.www.marketing.events.service.SocialLinkTypeLocalServiceUtil;
import com.liferay.osb.www.marketing.events.util.MarketingEventCacheUtil;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.AddressCityException;
import com.liferay.portal.kernel.exception.AddressStreetException;
import com.liferay.portal.kernel.exception.AddressZipException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 * @author Amos Fong
 * @author Haote Chou
 * @author Ryan Schuhler
 * @author Phillip Chan
 * @author Allen Ziegenfus
 */
@Component(
	configurationPid = "com.liferay.osb.www.marketing.events.configuration.MarketingEventsConfiguration",
	immediate = true,
	property = {

		// asset renderer factory?
		// todo hook for portlet properties?

		"com.liferay.portlet.preferences-company-wide=true",
		"com.liferay.portlet.preferences-unique-per-layout=false",
		"com.liferay.portlet.control-panel-entry-weight=9.0",
		"com.liferay.portlet.css-class-wrapper=osb-www-marketing-events-portlet-admin",
		"com.liferay.portlet.header-portlet-css=/admin/css/main.css",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.system=true",
		"javax.portlet.display-name=OSB Marketing Events Admin",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.ddm-resource=com.liferay.osb.www.marketing.events.admin",
		"javax.portlet.init-param.template-path=/admin/",
		"javax.portlet.init-param.view-template=/admin/view.jsp",
		"javax.portlet.name=" + OSBWWWMarketingEventsPortletKeys.MARKETING_EVENTS_ADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class MarketingEventsAdminPortlet extends MVCPortlet {

	public void deleteMarketingEvent(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long marketingEventId = ParamUtil.getLong(
			actionRequest, "marketingEventId");

		MarketingEventLocalServiceUtil.deleteMarketingEvent(marketingEventId);
	}

	public void deleteMarketingEventAnnouncement(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long marketingEventAnnouncementId = ParamUtil.getLong(
			actionRequest, "marketingEventAnnouncementId");

		MarketingEventAnnouncementLocalServiceUtil.
			deleteMarketingEventAnnouncement(marketingEventAnnouncementId);
	}

	public void deleteMarketingEventSession(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long marketingEventSessionId = ParamUtil.getLong(
			actionRequest, "marketingEventSessionId");

		MarketingEventSessionLocalServiceUtil.deleteMarketingEventSession(
			marketingEventSessionId);
	}

	public void deleteMarketingEventSessionRoom(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long marketingEventSessionRoomId = ParamUtil.getLong(
			actionRequest, "marketingEventSessionRoomId");

		MarketingEventSessionRoomLocalServiceUtil.
			deleteMarketingEventSessionRoom(marketingEventSessionRoomId);
	}

	public void deleteMarketingEventSponsor(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long marketingEventSponsorId = ParamUtil.getLong(
			actionRequest, "marketingEventSponsorId");

		MarketingEventSponsorLocalServiceUtil.deleteMarketingEventSponsor(
			marketingEventSponsorId);
	}

	public void deleteMarketingEventSponsorLevel(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long marketingEventSponsorLevelId = ParamUtil.getLong(
			actionRequest, "marketingEventSponsorLevelId");

		MarketingEventSponsorLevelLocalServiceUtil.
			deleteMarketingEventSponsorLevel(marketingEventSponsorLevelId);
	}

	public void deleteMarketingEventUser(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long marketingEventUserId = ParamUtil.getLong(
			actionRequest, "marketingEventUserId");

		MarketingEventUserLocalServiceUtil.deleteMarketingEventUser(
			marketingEventUserId);
	}

	public void deleteSocialLink(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long socialLinkId = ParamUtil.getLong(actionRequest, "socialLinkId");

		SocialLinkLocalServiceUtil.deleteSocialLink(socialLinkId);
	}

	public void deleteSocialLinkType(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long socialLinkTypeId = ParamUtil.getLong(
			actionRequest, "socialLinkTypeId");

		SocialLinkTypeLocalServiceUtil.deleteSocialLinkType(socialLinkTypeId);
	}

	@Override
	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		super.processAction(actionRequest, actionResponse);

		try {
			MarketingEventCacheUtil.clearCache();
		}
		catch (Exception e) {
			throw new PortletException(e);
		}
	}

	public void updateMarketingEvent(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long marketingEventId = ParamUtil.getLong(
			actionRequest, "marketingEventId");

		int type = ParamUtil.getInteger(actionRequest, "type");
		String defaultLanguageId = ParamUtil.getString(
			actionRequest, "defaultLanguageId");
		Map<Locale, String> titleMap = LocalizationUtil.getLocalizationMap(
			actionRequest, "title");
		String titleURL = ParamUtil.getString(actionRequest, "titleURL");
		String hostedBy = ParamUtil.getString(actionRequest, "hostedBy");
		String hostedByURL = ParamUtil.getString(actionRequest, "hostedByURL");
		Map<Locale, String> summaryMap = LocalizationUtil.getLocalizationMap(
			actionRequest, "summary");
		long siteGroupId = ParamUtil.getLong(actionRequest, "siteGroupId");
		long imageFileEntryId = ParamUtil.getLong(
			actionRequest, "imageFileEntryId");
		long slidesFileEntryId = ParamUtil.getLong(
			actionRequest, "slidesFileEntryId");
		String videoTitle = ParamUtil.getString(actionRequest, "videoTitle");
		String timeZoneId = ParamUtil.getString(actionRequest, "timeZoneId");
		boolean dateTBA = ParamUtil.getBoolean(actionRequest, "dateTBA");
		double latitude = ParamUtil.getDouble(actionRequest, "latitude");
		double longitude = ParamUtil.getDouble(actionRequest, "longitude");
		int globalRegion = ParamUtil.getInteger(actionRequest, "globalRegion");
		boolean online = ParamUtil.getBoolean(actionRequest, "online");
		int registrationType = ParamUtil.getInteger(
			actionRequest, "registrationType");
		String registrationURL = ParamUtil.getString(
			actionRequest, "registrationURL");
		String extraSettings = ParamUtil.getString(
			actionRequest, "extraSettings");

		int startDateMonth = ParamUtil.getInteger(
			actionRequest, "startDateMonth");
		int startDateDay = ParamUtil.getInteger(actionRequest, "startDateDay");
		int startDateYear = ParamUtil.getInteger(
			actionRequest, "startDateYear");
		int startDateHour = ParamUtil.getInteger(
			actionRequest, "startDateHour");
		int startDateMinute = ParamUtil.getInteger(
			actionRequest, "startDateMinute");
		int startDateAmPm = ParamUtil.getInteger(
			actionRequest, "startDateAmPm");

		if (startDateAmPm == Calendar.PM) {
			startDateHour += 12;
		}

		int endDateMonth = ParamUtil.getInteger(actionRequest, "endDateMonth");
		int endDateDay = ParamUtil.getInteger(actionRequest, "endDateDay");
		int endDateYear = ParamUtil.getInteger(actionRequest, "endDateYear");
		int endDateHour = ParamUtil.getInteger(actionRequest, "endDateHour");
		int endDateMinute = ParamUtil.getInteger(
			actionRequest, "endDateMinute");
		int endDateAmPm = ParamUtil.getInteger(actionRequest, "endDateAmPm");

		if (endDateAmPm == Calendar.PM) {
			endDateHour += 12;
		}

		String addressStreet1 = ParamUtil.getString(
			actionRequest, "addressStreet1");
		String addressStreet2 = ParamUtil.getString(
			actionRequest, "addressStreet2");
		String addressStreet3 = ParamUtil.getString(
			actionRequest, "addressStreet3");
		String addressCity = ParamUtil.getString(actionRequest, "addressCity");
		String addressZip = ParamUtil.getString(actionRequest, "addressZip");
		long addressRegionId = ParamUtil.getLong(
			actionRequest, "addressRegionId");
		long addressCountryId = ParamUtil.getLong(
			actionRequest, "addressCountryId");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			MarketingEvent.class.getName(), actionRequest);

		if (marketingEventId <= 0) {
			MarketingEventLocalServiceUtil.addMarketingEvent(
				themeDisplay.getUserId(), type, defaultLanguageId, titleMap,
				titleURL, hostedBy, hostedByURL, summaryMap, siteGroupId,
				imageFileEntryId, slidesFileEntryId, videoTitle, timeZoneId,
				startDateMonth, startDateDay, startDateYear, startDateHour,
				startDateMinute, endDateMonth, endDateDay, endDateYear,
				endDateHour, endDateMinute, dateTBA, addressStreet1,
				addressStreet2, addressStreet3, addressCity, addressZip,
				addressRegionId, addressCountryId, latitude, longitude,
				globalRegion, online, registrationType, registrationURL,
				extraSettings, serviceContext);
		}
		else {
			MarketingEventLocalServiceUtil.updateMarketingEvent(
				marketingEventId, type, defaultLanguageId, titleMap, titleURL,
				hostedBy, hostedByURL, summaryMap, siteGroupId,
				imageFileEntryId, slidesFileEntryId, videoTitle, timeZoneId,
				startDateMonth, startDateDay, startDateYear, startDateHour,
				startDateMinute, endDateMonth, endDateDay, endDateYear,
				endDateHour, endDateMinute, dateTBA, addressStreet1,
				addressStreet2, addressStreet3, addressCity, addressZip,
				addressRegionId, addressCountryId, latitude, longitude,
				globalRegion, online, registrationType, registrationURL,
				extraSettings, serviceContext);
		}
	}

	public void updateMarketingEventAnnouncement(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long marketingEventAnnouncementId = ParamUtil.getLong(
			actionRequest, "marketingEventAnnouncementId");

		long marketingEventId = ParamUtil.getLong(
			actionRequest, "marketingEventId");
		String title = ParamUtil.getString(actionRequest, "title");
		String message = ParamUtil.getString(actionRequest, "message");
		String summary = ParamUtil.getString(actionRequest, "summary");
		long imageFileEntryId = ParamUtil.getLong(
			actionRequest, "imageFileEntryId");
		String linkURL = ParamUtil.getString(actionRequest, "linkURL");
		String linkLabel = ParamUtil.getString(actionRequest, "linkLabel");
		int displayDateMonth = ParamUtil.getInteger(
			actionRequest, "displayDateMonth");
		int displayDateDay = ParamUtil.getInteger(
			actionRequest, "displayDateDay");
		int displayDateYear = ParamUtil.getInteger(
			actionRequest, "displayDateYear");
		int displayDateHour = ParamUtil.getInteger(
			actionRequest, "displayDateHour");
		int displayDateMinute = ParamUtil.getInteger(
			actionRequest, "displayDateMinute");

		int displayDateAmPm = ParamUtil.getInteger(
			actionRequest, "displayDateAmPm");

		if (displayDateAmPm == Calendar.PM) {
			displayDateHour += 12;
		}

		int status = ParamUtil.getInteger(actionRequest, "status");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			MarketingEventAnnouncement.class.getName(), actionRequest);

		if (marketingEventAnnouncementId <= 0) {
			MarketingEventAnnouncementLocalServiceUtil.
				addMarketingEventAnnouncement(
					themeDisplay.getUserId(), marketingEventId, title, message,
					summary, imageFileEntryId, linkURL, linkLabel,
					displayDateMonth, displayDateDay, displayDateYear,
					displayDateHour, displayDateMinute, status, serviceContext);
		}
		else {
			MarketingEventAnnouncementLocalServiceUtil.
				updateMarketingEventAnnouncement(
					marketingEventAnnouncementId, title, message, summary,
					imageFileEntryId, linkURL, linkLabel, displayDateMonth,
					displayDateDay, displayDateYear, displayDateHour,
					displayDateMinute, status, serviceContext);
		}
	}

	public void updateMarketingEventSession(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long marketingEventSessionId = ParamUtil.getLong(
			actionRequest, "marketingEventSessionId");

		long marketingEventId = ParamUtil.getLong(
			actionRequest, "marketingEventId");
		long marketingEventSessionRoomId = ParamUtil.getLong(
			actionRequest, "marketingEventSessionRoomId");
		Map<Locale, String> titleMap = LocalizationUtil.getLocalizationMap(
			actionRequest, "title");
		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(actionRequest, "description");
		Map<Locale, String> keywordsMap = LocalizationUtil.getLocalizationMap(
			actionRequest, "keywords");
		long slidesFileEntryId = ParamUtil.getLong(
			actionRequest, "slidesFileEntryId");
		String videoURL = ParamUtil.getString(actionRequest, "videoURL");
		int startDateMonth = ParamUtil.getInteger(
			actionRequest, "startDateMonth");
		int startDateDay = ParamUtil.getInteger(actionRequest, "startDateDay");
		int startDateYear = ParamUtil.getInteger(
			actionRequest, "startDateYear");
		int startDateHour = ParamUtil.getInteger(
			actionRequest, "startDateHour");
		int startDateMinute = ParamUtil.getInteger(
			actionRequest, "startDateMinute");

		int startDateAmPm = ParamUtil.getInteger(
			actionRequest, "startDateAmPm");

		if (startDateAmPm == Calendar.PM) {
			startDateHour += 12;
		}

		int endDateMonth = ParamUtil.getInteger(actionRequest, "endDateMonth");
		int endDateDay = ParamUtil.getInteger(actionRequest, "endDateDay");
		int endDateYear = ParamUtil.getInteger(actionRequest, "endDateYear");
		int endDateHour = ParamUtil.getInteger(actionRequest, "endDateHour");
		int endDateMinute = ParamUtil.getInteger(
			actionRequest, "endDateMinute");

		int endDateAmPm = ParamUtil.getInteger(actionRequest, "endDateAmPm");

		if (endDateAmPm == Calendar.PM) {
			endDateHour += 12;
		}

		int status = ParamUtil.getInteger(actionRequest, "status");
		long[] marketingEventUserIds = ParamUtil.getLongValues(
			actionRequest, "marketingEventUserIds");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			MarketingEventSession.class.getName(), actionRequest);

		if (marketingEventSessionId <= 0) {
			MarketingEventSessionLocalServiceUtil.addMarketingEventSession(
				themeDisplay.getUserId(), marketingEventId,
				marketingEventSessionRoomId, titleMap, descriptionMap,
				keywordsMap, slidesFileEntryId, videoURL, startDateMonth,
				startDateDay, startDateYear, startDateHour, startDateMinute,
				endDateMonth, endDateDay, endDateYear, endDateHour,
				endDateMinute, status, marketingEventUserIds, serviceContext);
		}
		else {
			MarketingEventSessionLocalServiceUtil.updateMarketingEventSession(
				marketingEventSessionId, marketingEventSessionRoomId, titleMap,
				descriptionMap, keywordsMap, slidesFileEntryId, videoURL,
				startDateMonth, startDateDay, startDateYear, startDateHour,
				startDateMinute, endDateMonth, endDateDay, endDateYear,
				endDateHour, endDateMinute, status, marketingEventUserIds,
				serviceContext);
		}
	}

	public void updateMarketingEventSessionRoom(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long marketingEventSessionRoomId = ParamUtil.getLong(
			actionRequest, "marketingEventSessionRoomId");

		long marketingEventId = ParamUtil.getLong(
			actionRequest, "marketingEventId");
		String name = ParamUtil.getString(actionRequest, "name");
		long imageFileEntryId = ParamUtil.getLong(
			actionRequest, "imageFileEntryId");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			MarketingEventSessionRoom.class.getName(), actionRequest);

		if (marketingEventSessionRoomId <= 0) {
			MarketingEventSessionRoomLocalServiceUtil.
				addMarketingEventSessionRoom(
					marketingEventId, name, imageFileEntryId, serviceContext);
		}
		else {
			MarketingEventSessionRoomLocalServiceUtil.
				updateMarketingEventSessionRoom(
					marketingEventSessionRoomId, name, imageFileEntryId,
					serviceContext);
		}
	}

	public void updateMarketingEventSponsor(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long marketingEventSponsorId = ParamUtil.getLong(
			actionRequest, "marketingEventSponsorId");

		long marketingEventId = ParamUtil.getLong(
			actionRequest, "marketingEventId");
		long marketingEventSponsorLevelId = ParamUtil.getLong(
			actionRequest, "marketingEventSponsorLevelId");
		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(actionRequest, "description");
		String name = ParamUtil.getString(actionRequest, "name");
		String url = ParamUtil.getString(actionRequest, "url");
		long imageFileEntryId = ParamUtil.getLong(
			actionRequest, "imageFileEntryId");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			MarketingEventSponsor.class.getName(), actionRequest);

		if (marketingEventSponsorId <= 0) {
			MarketingEventSponsorLocalServiceUtil.addMarketingEventSponsor(
				themeDisplay.getUserId(), marketingEventId,
				marketingEventSponsorLevelId, name, descriptionMap,
				imageFileEntryId, url, serviceContext);
		}
		else {
			MarketingEventSponsorLocalServiceUtil.updateMarketingEventSponsor(
				marketingEventSponsorId, marketingEventSponsorLevelId, name,
				descriptionMap, imageFileEntryId, url, serviceContext);
		}
	}

	public void updateMarketingEventSponsorLevel(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long marketingEventSponsorLevelId = ParamUtil.getLong(
			actionRequest, "marketingEventSponsorLevelId");

		long marketingEventId = ParamUtil.getLong(
			actionRequest, "marketingEventId");
		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(
			actionRequest, "name");
		int priority = ParamUtil.getInteger(actionRequest, "priority");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			MarketingEventSponsorLevel.class.getName(), actionRequest);

		if (marketingEventSponsorLevelId <= 0) {
			MarketingEventSponsorLevelLocalServiceUtil.
				addMarketingEventSponsorLevel(
					themeDisplay.getUserId(), marketingEventId, nameMap,
					priority, serviceContext);
		}
		else {
			MarketingEventSponsorLevelLocalServiceUtil.
				updateMarketingEventSponsorLevel(
					marketingEventSponsorLevelId, nameMap, priority,
					serviceContext);
		}
	}

	public void updateMarketingEventUser(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long marketingEventUserId = ParamUtil.getLong(
			actionRequest, "marketingEventUserId");

		long marketingEventId = ParamUtil.getLong(
			actionRequest, "marketingEventId");
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String companyName = ParamUtil.getString(actionRequest, "companyName");
		long companyLogoFileEntryId = ParamUtil.getLong(
			actionRequest, "companyLogoFileEntryId");
		Map<Locale, String> jobTitleMap = LocalizationUtil.getLocalizationMap(
			actionRequest, "jobTitle");
		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(actionRequest, "description");
		long imageFileEntryId = ParamUtil.getLong(
			actionRequest, "imageFileEntryId");
		String phoneNumber = ParamUtil.getString(actionRequest, "phoneNumber");
		int status = ParamUtil.getInteger(actionRequest, "status");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			MarketingEventUser.class.getName(), actionRequest);

		if (marketingEventUserId <= 0) {
			MarketingEventUserLocalServiceUtil.addMarketingEventUser(
				themeDisplay.getUserId(), marketingEventId, firstName, lastName,
				companyName, companyLogoFileEntryId, jobTitleMap,
				descriptionMap, imageFileEntryId, phoneNumber, status,
				serviceContext);
		}
		else {
			MarketingEventUserLocalServiceUtil.updateMarketingEventUser(
				themeDisplay.getUserId(), marketingEventUserId, firstName,
				lastName, companyName, companyLogoFileEntryId, jobTitleMap,
				descriptionMap, imageFileEntryId, phoneNumber, status,
				serviceContext);
		}
	}

	public void updateMarketingEventUserVisibilty(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			MarketingEventUser.class.getName(), actionRequest);

		long[] availableMarketingEventUserIds = ParamUtil.getLongValues(
			actionRequest, "availableMarketingEventUserIds");
		long[] visibleMarketingEventUserIds = ParamUtil.getLongValues(
			actionRequest, "visibleMarketingEventUserIds");

		for (int i = 0; i < availableMarketingEventUserIds.length; i++) {
			MarketingEventUserLocalServiceUtil.updateStatus(
				themeDisplay.getUserId(), availableMarketingEventUserIds[i],
				WorkflowConstants.STATUS_DRAFT, 0, serviceContext);
		}

		for (int i = 0; i < visibleMarketingEventUserIds.length; i++) {
			MarketingEventUserLocalServiceUtil.updateStatus(
				themeDisplay.getUserId(), visibleMarketingEventUserIds[i],
				WorkflowConstants.STATUS_APPROVED, i, serviceContext);
		}
	}

	public void updateSocialLink(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long socialLinkId = ParamUtil.getLong(actionRequest, "socialLinkId");

		long marketingEventUserId = ParamUtil.getLong(
			actionRequest, "marketingEventUserId");
		long socialLinkTypeId = ParamUtil.getLong(
			actionRequest, "socialLinkTypeId");
		String url = ParamUtil.getString(actionRequest, "url");

		if (socialLinkId <= 0) {
			SocialLinkLocalServiceUtil.addSocialLink(
				themeDisplay.getUserId(), marketingEventUserId,
				socialLinkTypeId, url);
		}
		else {
			SocialLinkLocalServiceUtil.updateSocialLink(
				socialLinkId, socialLinkTypeId, url);
		}
	}

	public void updateSocialLinkType(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long socialLinkTypeId = ParamUtil.getLong(
			actionRequest, "socialLinkTypeId");

		String name = ParamUtil.getString(actionRequest, "name");
		long imageFileEntryId = ParamUtil.getLong(
			actionRequest, "imageFileEntryId");

		if (socialLinkTypeId <= 0) {
			SocialLinkTypeLocalServiceUtil.addSocialLinkType(
				themeDisplay.getUserId(), name, imageFileEntryId);
		}
		else {
			SocialLinkTypeLocalServiceUtil.updateSocialLinkType(
				socialLinkTypeId, name, imageFileEntryId);
		}
	}

	@Override
	protected boolean isSessionErrorException(Throwable cause) {
		if (cause instanceof AddressCityException ||
			cause instanceof AddressStreetException ||
			cause instanceof AddressZipException ||
			cause instanceof AssetCategoryException ||
			cause instanceof DuplicateSiteGroupException ||
			cause instanceof DuplicateSocialLinkTypeException ||
			cause instanceof MarketingEventAnnouncementDisplayDateException ||
			cause instanceof MarketingEventAnnouncementLinkLabelException ||
			cause instanceof MarketingEventAnnouncementLinkURLException ||
			cause instanceof MarketingEventAnnouncementMessageException ||
			cause instanceof MarketingEventAnnouncementTitleException ||
			cause instanceof MarketingEventEndDateException ||
			cause instanceof MarketingEventHostedByException ||
			cause instanceof MarketingEventHostedByURLException ||
			cause instanceof MarketingEventRegistrationURLException ||
			cause instanceof MarketingEventSessionRoomNameException ||
			cause instanceof MarketingEventSessionStartDateException ||
			cause instanceof MarketingEventSessionTitleException ||
			cause instanceof MarketingEventSessionVideoURLException ||
			cause instanceof MarketingEventSponsorLevelNameException ||
			cause instanceof MarketingEventSponsorNameException ||
			cause instanceof MarketingEventStartDateException ||
			cause instanceof MarketingEventTitleException ||
			cause instanceof MarketingEventTitleURLException ||
			cause instanceof MarketingEventUserCompanyException ||
			cause instanceof MarketingEventUserFirstNameException ||
			cause instanceof MarketingEventUserLastNameException ||
			cause instanceof MarketingEventUserPhoneNumberException ||
			cause instanceof MarketingEventVideoTitleException ||
			cause instanceof MarketingEventVideoTitleException ||
			cause instanceof PrincipalException ||
			cause instanceof RequiredMarketingEventSessionRoomException ||
			cause instanceof RequiredMarketingEventSponsorLevelException ||
			cause instanceof RequiredMarketingEventUserException ||
			cause instanceof RequiredSocialLinkTypeException ||
			cause instanceof SocialLinkURLException) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

			renderRequest.setAttribute(
				MarketingEventsConfiguration.class.getName(), _configuration);

			super.render(renderRequest, renderResponse);
	}

	private static Log _log = LogFactoryUtil.getLog(
		MarketingEventsAdminPortlet.class);

	@Reference(unbind = "-")
	protected void setJournalArticleLocalService(
		JournalArticleLocalService journalArticleLocalService) {

		_journalArticleLocalService = journalArticleLocalService;
	}

	@Reference(unbind = "-")
	protected void setJournalContent(JournalContent journalContent) {
		_journalContent = journalContent;
	}

	private JournalContent _journalContent;

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(
			MarketingEventsConfiguration.class, properties);
	}

	private JournalArticleLocalService _journalArticleLocalService;
	private volatile MarketingEventsConfiguration _configuration;

}