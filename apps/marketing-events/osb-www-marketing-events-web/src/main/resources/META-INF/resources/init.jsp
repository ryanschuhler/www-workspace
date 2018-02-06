<%--
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
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.document.library.kernel.model.DLFolder" %><%@
page import="com.liferay.document.library.kernel.model.DLFolderConstants" %><%@
page import="com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil" %><%@
page import="com.liferay.osb.www.marketing.events.admin.search.MarketingEventDisplayTerms" %><%@
page import="com.liferay.osb.www.marketing.events.admin.search.MarketingEventSearch" %><%@
page import="com.liferay.osb.www.marketing.events.admin.search.MarketingEventSearchTerms" %><%@
page import="com.liferay.osb.www.marketing.events.configuration.MarketingEventsConfiguration" %><%@
page import="com.liferay.osb.www.marketing.events.constants.OSBWWWMarketingEventsConstants" %><%@
page import="com.liferay.osb.www.marketing.events.constants.OSBWWWMarketingEventsWebKeys" %><%@
page import="com.liferay.osb.www.marketing.events.exception.DuplicateSiteGroupException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.DuplicateSocialLinkTypeException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementDisplayDateException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementLinkLabelException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementLinkURLException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementMessageException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventAnnouncementTitleException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventEndDateException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventHostedByException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventHostedByURLException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventRegistrationURLException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventSessionRoomNameException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventSessionStartDateException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventSessionTitleException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventSessionVideoURLException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventSponsorLevelNameException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventSponsorNameException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventStartDateException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventTitleException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventTitleURLException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventUserCompanyException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventUserFirstNameException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventUserLastNameException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.MarketingEventVideoTitleException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.RequiredMarketingEventSessionRoomException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.RequiredMarketingEventSponsorLevelException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.RequiredMarketingEventUserException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.RequiredSocialLinkTypeException" %><%@
page import="com.liferay.osb.www.marketing.events.exception.SocialLinkURLException" %><%@
page import="com.liferay.osb.www.marketing.events.model.MarketingEvent" %><%@
page import="com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement" %><%@
page import="com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncementConstants" %><%@
page import="com.liferay.osb.www.marketing.events.model.MarketingEventConstants" %><%@
page import="com.liferay.osb.www.marketing.events.model.MarketingEventSession" %><%@
page import="com.liferay.osb.www.marketing.events.model.MarketingEventSessionConstants" %><%@
page import="com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom" %><%@
page import="com.liferay.osb.www.marketing.events.model.MarketingEventSponsor" %><%@
page import="com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel" %><%@
page import="com.liferay.osb.www.marketing.events.model.MarketingEventUser" %><%@
page import="com.liferay.osb.www.marketing.events.model.MarketingEventUserConstants" %><%@
page import="com.liferay.osb.www.marketing.events.model.SocialLink" %><%@
page import="com.liferay.osb.www.marketing.events.model.SocialLinkType" %><%@
page import="com.liferay.osb.www.marketing.events.service.MarketingEventAnnouncementLocalServiceUtil" %><%@
page import="com.liferay.osb.www.marketing.events.service.MarketingEventLocalServiceUtil" %><%@
page import="com.liferay.osb.www.marketing.events.service.MarketingEventSessionLocalServiceUtil" %><%@
page import="com.liferay.osb.www.marketing.events.service.MarketingEventSessionRoomLocalServiceUtil" %><%@
page import="com.liferay.osb.www.marketing.events.service.MarketingEventSponsorLevelLocalServiceUtil" %><%@
page import="com.liferay.osb.www.marketing.events.service.MarketingEventSponsorLocalServiceUtil" %><%@
page import="com.liferay.osb.www.marketing.events.service.MarketingEventUserLocalServiceUtil" %><%@
page import="com.liferay.osb.www.marketing.events.service.SocialLinkLocalServiceUtil" %><%@
page import="com.liferay.osb.www.marketing.events.service.SocialLinkTypeLocalServiceUtil" %><%@
page import="com.liferay.osb.www.marketing.events.util.MarketingEventsUtil" %><%@
page import="com.liferay.petra.content.ContentUtil" %><%@
page import="com.liferay.portal.kernel.bean.BeanParamUtil" %><%@
page import="com.liferay.portal.kernel.bean.BeanPropertiesUtil" %><%@
page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %><%@
page import="com.liferay.portal.kernel.dao.search.ResultRow" %><%@
page import="com.liferay.portal.kernel.exception.AddressCityException" %><%@
page import="com.liferay.portal.kernel.exception.AddressStreetException" %><%@
page import="com.liferay.portal.kernel.exception.AddressZipException" %><%@
page import="com.liferay.portal.kernel.exception.NoSuchCountryException" %><%@
page import="com.liferay.portal.kernel.exception.NoSuchRegionException" %><%@
page import="com.liferay.portal.kernel.json.JSONObject" %><%@
page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.model.Address" %><%@
page import="com.liferay.portal.kernel.model.Country" %><%@
page import="com.liferay.portal.kernel.model.Group" %><%@
page import="com.liferay.portal.kernel.model.Region" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %><%@
page import="com.liferay.portal.kernel.portlet.PortletURLUtil" %><%@
page import="com.liferay.portal.kernel.repository.model.FileEntry" %><%@
page import="com.liferay.portal.kernel.search.Hits" %><%@
page import="com.liferay.portal.kernel.search.Sort" %><%@
page import="com.liferay.portal.kernel.search.SortFactoryUtil" %><%@
page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil" %><%@
page import="com.liferay.portal.kernel.util.ArrayUtil" %><%@
page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.DateUtil" %><%@
page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.HttpUtil" %><%@
page import="com.liferay.portal.kernel.util.KeyValuePair" %><%@
page import="com.liferay.portal.kernel.util.LocaleUtil" %><%@
page import="com.liferay.portal.kernel.util.OrderByComparator" %><%@
page import="com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.PortalUtil" %><%@
page import="com.liferay.portal.kernel.util.PortletKeys" %><%@
page import="com.liferay.portal.kernel.util.PrefsParamUtil" %><%@
page import="com.liferay.portal.kernel.util.StringBundler" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.kernel.util.StringUtil" %><%@
page import="com.liferay.portal.kernel.util.TextFormatter" %><%@
page import="com.liferay.portal.kernel.util.TimeZoneUtil" %><%@
page import="com.liferay.portal.kernel.util.Tuple" %><%@
page import="com.liferay.portal.kernel.util.UnicodeFormatter" %><%@
page import="com.liferay.portal.kernel.util.Validator" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>

<%@ page import="java.text.DateFormat" %><%@
page import="java.text.Format" %>

<%@ page import="java.util.ArrayList" %><%@
page import="java.util.Calendar" %><%@
page import="java.util.Date" %><%@
page import="java.util.List" %><%@
page import="java.util.Locale" %><%@
page import="java.util.Objects" %><%@
page import="java.util.Set" %><%@
page import="java.util.TimeZone" %>

<%@ page import="javax.portlet.PortletURL" %><%@
page import="javax.portlet.WindowState" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
Object configurationAttribute = renderRequest.getAttribute(MarketingEventsConfiguration.class.getName());
String headerContent = StringPool.BLANK;

if (configurationAttribute != null) {
	MarketingEventsConfiguration configuration = (MarketingEventsConfiguration)GetterUtil.getObject(configurationAttribute);

	headerContent = portletPreferences.getValue("headerContent_" + LanguageUtil.getLanguageId(request), ContentUtil.get(MarketingEventSearch.class.getClassLoader(), configuration.portletHeaderContent()));
}

String currentURL = PortalUtil.getCurrentURL(request);

String defaultType = portletPreferences.getValue("defaultType", null);
String headerTitle = portletPreferences.getValue("headerTitle_" + LanguageUtil.getLanguageId(request), "Marketing Events");
boolean showSearch = GetterUtil.getBoolean(portletPreferences.getValue("showSearch", null), true);

Format longDateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(DateFormat.LONG, DateFormat.LONG, locale, timeZone);
%>