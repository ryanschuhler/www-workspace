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

<%@ include file="/init.jsp" %>

<%
long marketingEventId = ParamUtil.getLong(request, "marketingEventId");

if (marketingEventId <= 0) {
	HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(request);

	marketingEventId = ParamUtil.getLong(originalRequest, "marketingEventId");
}

MarketingEvent marketingEvent = MarketingEventLocalServiceUtil.getMarketingEvent(marketingEventId);
%>

<div class="jsp-view-marketing-event text-center" typeof="Event" vocab="http://schema.org/">
	<div class="marketing-event-header">

		<%
		FileEntry imageFileEntry = marketingEvent.getImageFileEntry();
		%>

		<c:choose>
			<c:when test="<%= marketingEvent.hasVideo() %>">
				<div id="<portlet:namespace />video">
					<div class="video-content">
						<video class="video-node" controls poster='<%= marketingEvent.getVideoURL(".jpg") %>'>
							 <source src='<%= marketingEvent.getVideoURL(".mp4") %>' type="video/mp4">
						</video>
					</div>
				</div>
			</c:when>
			<c:when test="<%= imageFileEntry != null %>">
				<img class="marketing-event-image" src="<%= themeDisplay.getPathContext() + "/documents/" + imageFileEntry.getRepositoryId() + "/" + imageFileEntry.getFolderId() + "/" + HttpUtil.encodeURL(imageFileEntry.getTitle()) + "/" + imageFileEntry.getUuid() %>" />
			</c:when>
			<c:otherwise>
				<img class="marketing-event-image" src="<%= PortalUtil.getPathContext(request) + "/images/" + TextFormatter.format(MarketingEventConstants.getTypeLabel(marketingEvent.getType()) + ".svg", TextFormatter.N) %>" />
			</c:otherwise>
		</c:choose>
	</div>

	<div class="marketing-event-content">
		<div class="title" property="name">
			<h3>
				<c:choose>
					<c:when test="<%= Validator.isNotNull(marketingEvent.getTitleURL()) %>">
						<a href="<%= marketingEvent.getTitleURL() %>" target="_blank"><%= GetterUtil.getString(marketingEvent.getTitle(locale), marketingEvent.getTitle(marketingEvent.getDefaultLanguageId())) %></a>
					</c:when>
					<c:otherwise>
						<%= GetterUtil.getString(marketingEvent.getTitle(locale), marketingEvent.getTitle(marketingEvent.getDefaultLanguageId())) %>
					</c:otherwise>
				</c:choose>
			</h3>
		</div>

		<div class="date">
			<c:choose>
				<c:when test="<%= !marketingEvent.isDateTBA() %>">

					<%
					TimeZone marketingEventTimeZone = TimeZoneUtil.getTimeZone(marketingEvent.getTimeZoneId());

					Format marketingEventISO8601Format = FastDateFormatFactoryUtil.getSimpleDateFormat("yyyy-MM-dd'T'HH:mm", locale, marketingEventTimeZone);
					Format marketingEventLongDateFormatDate = FastDateFormatFactoryUtil.getSimpleDateFormat("MMM dd, yyyy", locale, marketingEventTimeZone);
					Format marketingEventLongDateFormatTime = FastDateFormatFactoryUtil.getSimpleDateFormat("h:mm a z", locale, marketingEventTimeZone);
					Format marketingEventShortDateFormatDate = FastDateFormatFactoryUtil.getSimpleDateFormat("MMM dd", locale, marketingEventTimeZone);

					Format userDateFormatDate = FastDateFormatFactoryUtil.getSimpleDateFormat("MMM dd, yyyy", locale, user.getTimeZone());
					Format userDateFormatTime = FastDateFormatFactoryUtil.getSimpleDateFormat("h:mm a z", locale, user.getTimeZone());
					Format userDateISO8601Format = FastDateFormatFactoryUtil.getSimpleDateFormat("yyyy-MM-dd'T'HH:mm", locale, user.getTimeZone());
					%>

					<c:choose>
						<c:when test="<%= !themeDisplay.isSignedIn() || !marketingEvent.isTypeWebinar() %>">
							<c:choose>
								<c:when test="<%= !Validator.equals(marketingEventLongDateFormatDate.format(marketingEvent.getStartDate()), marketingEventLongDateFormatDate.format(marketingEvent.getEndDate())) %>">
									<span content="<%= marketingEventISO8601Format.format(marketingEvent.getStartDate()) %>" property="startDate">
										<%= marketingEventShortDateFormatDate.format(marketingEvent.getStartDate()) %>
									</span> -

									<span content="<%= marketingEventISO8601Format.format(marketingEvent.getEndDate()) %>" property="endDate">
										<%= marketingEventLongDateFormatDate.format(marketingEvent.getEndDate()) %>
									</span>
								</c:when>
								<c:otherwise>
									<span content="<%= marketingEventISO8601Format.format(marketingEvent.getStartDate()) %>" property="startDate">
										<%= marketingEventLongDateFormatDate.format(marketingEvent.getStartDate()) %>
									</span>
								</c:otherwise>
							</c:choose>

							<br />

							<%= marketingEventLongDateFormatTime.format(marketingEvent.getStartDate()) %>
						</c:when>
						<c:when test="<%= Validator.equals(marketingEventLongDateFormatDate.format(marketingEvent.getStartDate()), userDateFormatDate.format(marketingEvent.getStartDate())) %>">
							<span content="<%= marketingEventISO8601Format.format(marketingEvent.getStartDate()) %>" property="startDate">
								<%= marketingEventLongDateFormatDate.format(marketingEvent.getStartDate()) %><br />
								<%= marketingEventLongDateFormatTime.format(marketingEvent.getStartDate()) %>
							</span>

							<c:if test="<%= !marketingEventTimeZone.hasSameRules(user.getTimeZone()) %>">
								| <%= userDateFormatTime.format(marketingEvent.getStartDate()) %>
							</c:if>
						</c:when>
						<c:otherwise>
							<span content="<%= marketingEventISO8601Format.format(marketingEvent.getStartDate()) %>" property="startDate">
								<%= marketingEventLongDateFormatDate.format(marketingEvent.getStartDate()) %> <%= marketingEventLongDateFormatTime.format(marketingEvent.getStartDate()) %>
							</span><br />

							<span content="<%= userDateISO8601Format.format(marketingEvent.getStartDate()) %>" property="startDate">
								<%= userDateFormatDate.format(marketingEvent.getStartDate()) %> <%= userDateFormatTime.format(marketingEvent.getStartDate()) %>
							</span>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<liferay-ui:message key="to-be-announced" />
				</c:otherwise>
			</c:choose>
		</div>

		<%
		Address address = marketingEvent.getAddress();
		%>

		<c:choose>
			<c:when test="<%= address != null %>">
				<div class="location" property="location" typeof="Place">
					<c:if test="<%= Validator.isNotNull(address.getStreet1()) %>">
						<%= HtmlUtil.escape(address.getStreet1()) %><br />
					</c:if>

					<c:if test="<%= Validator.isNotNull(address.getStreet2()) %>">
						<%= HtmlUtil.escape(address.getStreet2()) %><br />
					</c:if>

					<c:if test="<%= Validator.isNotNull(address.getStreet3()) %>">
						<%= HtmlUtil.escape(address.getStreet3()) %><br />
					</c:if>

					<c:if test="<%= Validator.isNotNull(address.getCity()) %>">

						<%
						StringBundler sb = new StringBundler(5);

						sb.append(HtmlUtil.escape(address.getCity()));

						if (address.getRegionId() > 0) {
							Region region = address.getRegion();

							sb.append(StringPool.COMMA_AND_SPACE);
							sb.append(HtmlUtil.escape(region.getName()));
						}

						String zip = address.getZip();

						if (Validator.isNotNull(zip) && !zip.equals(MarketingEventConstants.ADDRESS_ZIP_NOT_AVAILABLE)) {
							sb.append(StringPool.SPACE);
							sb.append(HtmlUtil.escape(address.getZip()));
						}
						%>

						<%= sb.toString() %><br />
					</c:if>

					<c:if test="<%= address.getCountry() != null %>">
						<%= LanguageUtil.format(locale, "country." + address.getCountry().getName(), "") %>
					</c:if>
				</div>
			</c:when>
			<c:when test="<%= marketingEvent.isOnline() %>">
				<div class="location">
					<liferay-ui:message key="online" />
				</div>
			</c:when>
		</c:choose>

		<c:if test="<%= Validator.isNotNull(marketingEvent.getHostedBy()) %>">
			<div class="host" property="Organizer">
				<c:choose>
					<c:when test="<%= Validator.isNotNull(marketingEvent.getHostedByURL()) %>">
						<%= LanguageUtil.format(request, "hosted-by-x", new Object[] {"<a href=\"" + HtmlUtil.escapeHREF(marketingEvent.getHostedByURL()) + "\" target=\"_blank\">" + HtmlUtil.escape(marketingEvent.getHostedBy()) + "</a>"}) %>
					</c:when>
					<c:otherwise>
						<%= LanguageUtil.format(request, "hosted-by-x", new Object[] {HtmlUtil.escape(marketingEvent.getHostedBy())}) %>
					</c:otherwise>
				</c:choose>
			</div>
		</c:if>

		<div class="summary text-left" property="description">
			<%= GetterUtil.getString(marketingEvent.getSummary(locale), marketingEvent.getSummary(marketingEvent.getDefaultLanguageId())) %>
		</div>
	</div>

	<div class="marketing-event-footer">

		<%
		FileEntry slidesFileEntry = marketingEvent.getSlidesFileEntry();
		%>

		<c:if test="<%= marketingEvent.hasVideo() || (slidesFileEntry != null) %>">
			<div class="downloads">
				<liferay-ui:message key="download" />:

				<c:if test="<%= marketingEvent.hasVideo() %>">
					<aui:a href='<%= marketingEvent.getVideoURL(".mp4") %>' label="video" target="blank" />
				</c:if>

				<c:if test="<%= slidesFileEntry != null %>">
					<c:if test="<%= marketingEvent.hasVideo() %>">
						|
					</c:if>

					<aui:a href='<%= themeDisplay.getPathMain() + "/document_library/get_file?groupId=" + slidesFileEntry.getRepositoryId() + "&folderId=" + slidesFileEntry.getFolderId() + "&title=" + HttpUtil.encodeURL(slidesFileEntry.getTitle()) + "&uuid=" + slidesFileEntry.getUuid() %>' label="slides" target="blank" />
				</c:if>

				<span class="share-icon small-padding-horizontal">
					<img src="<%= PortalUtil.getPathContext(request) %>/images/share.svg" />
				</span>

				<div class="hide share-link small-padding-vertical">
					<input onClick="this.select();" type="text" value="<%= PortalUtil.getPortalURL(request) %>/events?marketingEventId=<%= marketingEventId %>">
				</div>
			</div>
		</c:if>

		<%
		Date startDate = marketingEvent.getStartDate();
		%>

		<c:if test="<%= Validator.isNotNull(marketingEvent.getRegistrationURL()) && startDate.after(DateUtil.newDate()) %>">
			<a class="btn btn-primary" href="<%= marketingEvent.getRegistrationURL() %>" label="<%= StringUtil.toUpperCase(LanguageUtil.get(request, MarketingEventConstants.getRegistrationTypeButtonLabel(marketingEvent.getRegistrationType()))) %>" target="_blank"><%= StringUtil.toUpperCase(LanguageUtil.get(request, MarketingEventConstants.getRegistrationTypeButtonLabel(marketingEvent.getRegistrationType()))) %></a>
		</c:if>
	</div>
</div>

<c:if test="<%= marketingEvent.hasVideo() || (slidesFileEntry != null) %>">
	<aui:script use="aui-base">
		var shareIcon = A.one('.share-icon');
		var shareLink = A.one('.share-link');

		if (shareIcon && shareLink) {
			shareIcon.on(
				'click',
				function(event) {
					shareLink.toggleClass('hide');
				}
			);
		}
	</aui:script>
</c:if>