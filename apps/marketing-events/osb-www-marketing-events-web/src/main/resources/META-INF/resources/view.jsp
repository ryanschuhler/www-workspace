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

<%@ include file="/init.jsp"%>

<%
	HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(request);

	int[] defaultTypes = ParamUtil.getIntegerValues(originalRequest, "types");
	int[] defaultGlobalRegions = ParamUtil.getIntegerValues(originalRequest, "globalRegions");
	long[] defaultCountryIds = ParamUtil.getLongValues(originalRequest, "countryIds");
	boolean defaultPastEvents = ParamUtil.getBoolean(originalRequest, "pastEvents");

	int[] types = ParamUtil.getIntegerValues(request, "types", defaultTypes);
	int[] globalRegions = ParamUtil.getIntegerValues(request, "globalRegions", defaultGlobalRegions);
	long[] countryIds = ParamUtil.getLongValues(request, "countryIds", defaultCountryIds);
	boolean pastEvents = ParamUtil.getBoolean(request, "pastEvents", defaultPastEvents);

	if (Validator.isNotNull(defaultType) && (defaultTypes.length == 0)) {
		types = MarketingEventConstants.getTypes(GetterUtil.getInteger(defaultType));
	}
%>

<liferay-portlet:renderURL varImpl="searchURL" />

<aui:form action="<%=searchURL%>" cssClass="jsp-view" method="get"
	name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<aui:input cssClass="event-filter" name="types" type="hidden"
		value="<%=StringUtil.merge(types)%>" />
	<aui:input cssClass="event-filter" name="globalRegions" type="hidden"
		value="<%=StringUtil.merge(globalRegions)%>" />
	<aui:input cssClass="event-filter" name="countryIds" type="hidden"
		value="<%=StringUtil.merge(countryIds)%>" />
	<aui:input cssClass="event-filter" name="pastEvents" type="hidden"
		value="<%=pastEvents%>" />

	<liferay-ui:header localizeTitle="<%=false%>"
		title="<%=headerTitle%>" />

	<div class="header">
		<c:if test="<%=Validator.isNotNull(headerContent)%>">
			<div class="header-content">
				<%=headerContent%>
			</div>
		</c:if>

		<div class="align-center dropdown-group no-padding">
			<c:if test="<%=Validator.isNull(defaultType)%>">

				<%
					String taglibTypesOnClick = renderResponse.getNamespace() + "filter('types', this.value, false);";
				%>

				<aui:select ignoreRequestValue="<%=true%>"
					inlineField="<%=true%>" label="" name="filterByTypes"
					onChange="<%= taglibTypesOnClick %>">
					<aui:option
						label='<%=(types.length > 0)
								? LanguageUtil.format(request, "x-selected-x", new Object[]{types.length, "type"})
								: LanguageUtil.format(request, "all-selected-x", "type")%>' />
					<aui:option label="clear-options" value="-1" />

					<%
						for (JSONObject typeJSONObject : MarketingEventsUtil.getTypeJSONObjects(globalRegions,
											countryIds, null, pastEvents, themeDisplay.getLanguageId())) {
					%>

					<aui:option
						cssClass='<%=ArrayUtil.contains(types, typeJSONObject.getInt("type"))
									? "highlighted-option"
									: StringPool.BLANK%>'
						disabled='<%=typeJSONObject.getInt("count") == 0%>'
						label='<%=LanguageUtil.format(request, typeJSONObject.getString("label"),
									typeJSONObject.getInt("count"))%>'
						value='<%=typeJSONObject.getInt("type")%>' />

					<%
						}
					%>

				</aui:select>
			</c:if>

			<%
				String taglibGlobalRegionsOnClick = renderResponse.getNamespace()
							+ "filter('globalRegions', this.value, false);";
			%>

			<aui:select ignoreRequestValue="<%=true%>"
				inlineField="<%=true%>" label="" name="filterByGlobalRegions"
				onChange="<%= taglibGlobalRegionsOnClick %>">
				<aui:option
					label='<%=(globalRegions.length > 0)
							? LanguageUtil.format(request, "x-selected-x",
									new Object[]{globalRegions.length, "global-region"})
							: LanguageUtil.format(request, "all-selected-x", "global-region")%>' />
				<aui:option label="clear-options" value="-1" />

				<%
					for (JSONObject globalRegionJSONObject : MarketingEventsUtil.getGlobalRegionJSONObjects(types,
									countryIds, null, pastEvents, themeDisplay.getLanguageId())) {
				%>

				<aui:option
					cssClass='<%=ArrayUtil.contains(globalRegions, globalRegionJSONObject.getInt("globalRegion"))
								? "highlighted-option"
								: StringPool.BLANK%>'
					disabled='<%=globalRegionJSONObject.getInt("count") == 0%>'
					label='<%=LanguageUtil.format(request, globalRegionJSONObject.getString("label"),
								globalRegionJSONObject.getInt("count"))%>'
					value='<%=globalRegionJSONObject.getInt("globalRegion")%>' />

				<%
					}
				%>

			</aui:select>

			<%
				String taglibCountryIdsOnClick = renderResponse.getNamespace()
							+ "filter('countryIds', this.value, false);";
			%>

			<aui:select ignoreRequestValue="<%=true%>"
				inlineField="<%=true%>" label="" name="filterByCountryIds"
				onChange="<%= taglibCountryIdsOnClick %>">
				<aui:option
					label='<%=(countryIds.length > 0)
							? LanguageUtil.format(request, "x-selected-x", new Object[]{countryIds.length, "country"})
							: LanguageUtil.format(request, "all-selected-x", "country")%>' />
				<aui:option label="clear-options" value="-1" />

				<%
					for (Country country : MarketingEventsUtil.getCountries(types, globalRegions, null, pastEvents)) {
								String countryName = "country." + country.getName();
				%>

				<aui:option
					cssClass='<%=ArrayUtil.contains(countryIds, country.getCountryId())
								? "highlighted-option"
								: StringPool.BLANK%>'
					label='<%=LanguageUtil.format(request, countryName, "")%>'
					value="<%=country.getCountryId()%>" />

				<%
					}
				%>

			</aui:select>

			<%
				String taglibPastEventsOnClick = renderResponse.getNamespace()
							+ "filter('pastEvents', String(this.checked), false);";
			%>

			<aui:input ignoreRequestValue="<%=true%>" inlineField="<%=true%>"
				label="past-events" name="pastEvents"
				onClick="<%= taglibPastEventsOnClick %>" type="checkbox"
				value="<%=pastEvents%>" />

			<c:if test="<%=showSearch%>">
				<aui:input cssClass="search-box" ignoreRequestValue="<%=true%>"
					label="" name="searchBox"
					onKeyPress="if (event.keyCode == 13) { return false; }"
					placeholder='<%=LanguageUtil.format(request, "Search", "")%>' />
			</c:if>
		</div>
	</div>

	<%
		List<Country> countries = MarketingEventsUtil.getCountries(countryIds);
	%>

	<c:if
		test="<%=!countries.isEmpty() || (globalRegions.length > 0) || (types.length > 0)%>">
		<div class="block-container navigation">
			<c:if
				test="<%=Validator.isNull(defaultType) && (types.length > 0)%>">
				<div
					class="align-center block-container no-padding small-padding-horizontal">
					<span class="title"><liferay-ui:message key="type" /></span>

					<%
						for (int curType : types) {
					%>

					<span class="block-container filter-label no-padding"> <%
 	String taglibRemoveOnClick = renderResponse.getNamespace() + "filter('types', '" + curType
 							+ "', false);";
 					String taglibTextOnClick = renderResponse.getNamespace() + "filter('types', '" + curType
 							+ "', true);";
 %> <aui:a cssClass="small-padding-horizontal text"
							href="javascript:;" onClick="<%= taglibTextOnClick %>"
							title='<%=LanguageUtil.format(request, "search-only-in-x",
										MarketingEventConstants.getTypeLabel(curType))%>'><%=LanguageUtil.get(request, MarketingEventConstants.getTypeLabel(curType))%></aui:a>

						<aui:a cssClass="remove" href="javascript:;"
							onClick="<%= taglibRemoveOnClick %>"
							title='<%=LanguageUtil.format(request, "remove-x",
										MarketingEventConstants.getTypeLabel(curType))%>'>
							<svg height="10" stroke="currentColor" stroke-miterlimit="10"
								stroke-width="1.5" viewBox="0 0 10 10" width="20">
								<line x1="0" x2="10" y1="0" y2="10"></line>
								<line x1="0" x2="10" y1="10" y2="0"></line></svg>
						</aui:a>
					</span>

					<%
						}
					%>

				</div>
			</c:if>

			<c:if test="<%=globalRegions.length > 0%>">
				<div
					class="align-center block-container no-padding small-padding-horizontal">
					<span class="title"><liferay-ui:message key="global-region" /></span>

					<%
						for (int curGlobalRegion : globalRegions) {
					%>

					<span class="block-container filter-label no-padding"> <%
 	String taglibRemoveOnClick = renderResponse.getNamespace() + "filter('globalRegions', '"
 							+ curGlobalRegion + "', false);";
 					String taglibTextOnClick = renderResponse.getNamespace() + "filter('globalRegions', '"
 							+ curGlobalRegion + "', true);";
 %> <aui:a cssClass="small-padding-horizontal text"
							href="javascript:;" onClick="<%= taglibTextOnClick %>"
							title='<%=LanguageUtil.format(request, "search-only-in-x",
										MarketingEventConstants.getGlobalRegionLabel(curGlobalRegion))%>'>
							<liferay-ui:message
								key="<%=MarketingEventConstants.getGlobalRegionLabel(curGlobalRegion)%>" />

						</aui:a>
						<aui:a cssClass="remove" href="javascript:;"
							onClick="<%= taglibRemoveOnClick %>"
							title='<%=LanguageUtil.format(request, "remove-x",
										MarketingEventConstants.getGlobalRegionLabel(curGlobalRegion))%>'>
							<svg height="10" stroke="currentColor" stroke-miterlimit="10"
								stroke-width="1.5" viewBox="0 0 10 10" width="20"> <line
									x1="0" x2="10" y1="0" y2="10"></line> <line x1="0" x2="10"
									y1="10" y2="0"></line></svg>
						</aui:a>
					</span>

					<%
						}
					%>

				</div>
			</c:if>

			<c:if test="<%=!countries.isEmpty()%>">
				<div
					class="align-center block-container no-padding small-padding-horizontal">
					<span class="title"><liferay-ui:message key="country" /></span>

					<%
						for (Country country : countries) {
					%>

					<span class="block-container filter-label no-padding"> <%
 	String taglibRemoveOnClick = renderResponse.getNamespace() + "filter('countryIds', '"
 							+ country.getCountryId() + "', false);";
 					String taglibTextOnClick = renderResponse.getNamespace() + "filter('countryIds', '"
 							+ country.getCountryId() + "', true);";
 %> <aui:a cssClass="small-padding-horizontal text"
							href="javascript:;" onClick="<%= taglibTextOnClick %>"
							title='<%=LanguageUtil.format(request, "search-only-in-x",
										"country." + country.getName())%>'>
							<%=LanguageUtil.format(locale, "country." + country.getName(), "")%>
						</aui:a> <aui:a cssClass="remove" href="javascript:;"
							onClick="<%= taglibRemoveOnClick %>"
							title='<%=LanguageUtil.format(request, "remove-x", "country." + country.getName())%>'>
							<svg height="10" stroke="currentColor" stroke-miterlimit="10"
								stroke-width="1.5" viewBox="0 0 10 10" width="20"> <line
									x1="0" x2="10" y1="0" y2="10"></line> <line x1="0" x2="10"
									y1="10" y2="0"></line></svg>
						</aui:a>
					</span>

					<%
						}
					%>

				</div>
			</c:if>
		</div>
	</c:if>

	<div class="block-container content small-padding"
		id="<portlet:namespace />marketingEventsContainer">

		<%
			String orderByType = MarketingEventConstants.ORDER_BY_TYPE_ASC;

				if (pastEvents) {
					orderByType = MarketingEventConstants.ORDER_BY_TYPE_DESC;
				}

				List<MarketingEvent> marketingEvents = MarketingEventLocalServiceUtil.getMarketingEvents(types,
						globalRegions, countryIds, null, pastEvents, themeDisplay.getLanguageId(), null, orderByType);

				for (MarketingEvent marketingEvent : marketingEvents) {
		%>

		<div
			class="align-center block justify-center marketing-event preview-block text-center"
			data-marketing-event-id="<%=marketingEvent.getMarketingEventId()%>">
			<a class="element-border font-color no-padding w100"
				href="javascript:;">
				<div class="link-tile-wrapper">
					<div class="marketing-event-header">

						<%
							FileEntry imageFileEntry = marketingEvent.getImageFileEntry();
						%>

						<c:choose>
							<c:when test="<%=imageFileEntry != null%>">
								<img class="small-padding-vertical"
									src="<%=themeDisplay.getPathContext() + "/documents/" + imageFileEntry.getRepositoryId()
									+ "/" + imageFileEntry.getFolderId() + "/"
									+ HttpUtil.encodeURL(imageFileEntry.getTitle()) + "/" + imageFileEntry.getUuid()%>" />
							</c:when>
							<c:otherwise>
								<img class="small-padding-vertical"
									src="<%=PortalUtil.getPathContext(request) + "/images/"
									+ TextFormatter.format(
											MarketingEventConstants.getTypeLabel(marketingEvent.getType()) + ".svg",
											TextFormatter.N)%>" />
							</c:otherwise>
						</c:choose>
					</div>

					<h4 class="title" property="name">

						<%
							String title = GetterUtil.getString(marketingEvent.getTitle(locale),
											marketingEvent.getTitle(marketingEvent.getDefaultLanguageId()));
						%>

						<%=StringUtil.shorten(title, 50)%>
					</h4>

					<div class="date">
						<c:choose>
							<c:when test="<%=!marketingEvent.isDateTBA()%>">

								<%
									TimeZone marketingEventTimeZone = TimeZoneUtil.getTimeZone(marketingEvent.getTimeZoneId());

													Format marketingEventISO8601Format = FastDateFormatFactoryUtil
															.getSimpleDateFormat("yyyy-MM-dd'T'HH:mm", locale, marketingEventTimeZone);
													Format marketingEventLongDateFormatDate = FastDateFormatFactoryUtil
															.getSimpleDateFormat("MMM dd, yyyy", locale, marketingEventTimeZone);
													Format marketingEventLongDateFormatTime = FastDateFormatFactoryUtil
															.getSimpleDateFormat("h:mm a z", locale, marketingEventTimeZone);
													Format marketingEventShortDateFormatDate = FastDateFormatFactoryUtil
															.getSimpleDateFormat("MMM dd", locale, marketingEventTimeZone);

													Format userDateFormatDate = FastDateFormatFactoryUtil.getSimpleDateFormat("MMM dd, yyyy",
															locale, user.getTimeZone());
													Format userDateFormatTime = FastDateFormatFactoryUtil.getSimpleDateFormat("h:mm a z",
															locale, user.getTimeZone());
													Format userDateISO8601Format = FastDateFormatFactoryUtil
															.getSimpleDateFormat("yyyy-MM-dd'T'HH:mm", locale, user.getTimeZone());
								%>

								<c:choose>
									<c:when
										test="<%=!themeDisplay.isSignedIn() || !marketingEvent.isTypeWebinar()%>">
										<c:choose>
											<c:when
												test="<%=!Validator.equals(
													marketingEventLongDateFormatDate
															.format(marketingEvent.getStartDate()),
													marketingEventLongDateFormatDate
															.format(marketingEvent.getEndDate()))%>">
												<span
													content="<%=marketingEventISO8601Format.format(marketingEvent.getStartDate())%>"
													property="startDate"> <%=marketingEventShortDateFormatDate
													.format(marketingEvent.getStartDate())%>
												</span> -

													<span
													content="<%=marketingEventISO8601Format.format(marketingEvent.getEndDate())%>"
													property="endDate"> <%=marketingEventLongDateFormatDate
													.format(marketingEvent.getEndDate())%>
												</span>
											</c:when>
											<c:otherwise>
												<span
													content="<%=marketingEventISO8601Format.format(marketingEvent.getStartDate())%>"
													property="startDate"> <%=marketingEventLongDateFormatDate
													.format(marketingEvent.getStartDate())%>
												</span>
											</c:otherwise>
										</c:choose>

										<br />

										<%=marketingEventLongDateFormatTime.format(marketingEvent.getStartDate())%>
									</c:when>
									<c:when
										test="<%=Validator.equals(
											marketingEventLongDateFormatDate.format(marketingEvent.getStartDate()),
											userDateFormatDate.format(marketingEvent.getStartDate()))%>">
										<span
											content="<%=marketingEventISO8601Format.format(marketingEvent.getStartDate())%>"
											property="startDate"> <%=marketingEventLongDateFormatDate.format(marketingEvent.getStartDate())%><br />
											<%=marketingEventLongDateFormatTime.format(marketingEvent.getStartDate())%>
										</span>

										<c:if
											test="<%=!marketingEventTimeZone.hasSameRules(user.getTimeZone())%>">
												| <%=userDateFormatTime.format(marketingEvent.getStartDate())%>
										</c:if>
									</c:when>
									<c:otherwise>
										<span
											content="<%=marketingEventISO8601Format.format(marketingEvent.getStartDate())%>"
											property="startDate"> <%=marketingEventLongDateFormatDate.format(marketingEvent.getStartDate())%>
											<%=marketingEventLongDateFormatTime.format(marketingEvent.getStartDate())%>
										</span>
										<br />

										<span
											content="<%=userDateISO8601Format.format(marketingEvent.getStartDate())%>"
											property="startDate"> <%=userDateFormatDate.format(marketingEvent.getStartDate())%>
											<%=userDateFormatTime.format(marketingEvent.getStartDate())%>
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
						<c:when test="<%=address != null%>">
							<div class="location" property="location" typeof="Place">
								<c:if test="<%=Validator.isNotNull(address.getCity())%>">
									<%=HtmlUtil.escape(address.getCity())%><%=(address.getRegionId() > 0)
										? (StringPool.COMMA_AND_SPACE + HtmlUtil.escape(address.getRegion().getName()))
										: StringPool.BLANK%>
								</c:if>

								<c:if test="<%=address.getCountry() != null%>">
									<br />
									<%=LanguageUtil.format(locale, "country." + address.getCountry().getName(), "")%>
								</c:if>
							</div>
						</c:when>
						<c:when test="<%=marketingEvent.isOnline()%>">
							<div class="location">
								<liferay-ui:message key="online" />
							</div>
						</c:when>
					</c:choose>
				</div>
			</a>
		</div>

		<%
			}
		%>

		<c:if test="<%=marketingEvents.isEmpty()%>">
			<div class="row-no-results">
				<liferay-ui:message
					key="thanks-for-stopping-by-we-are-working-on-new-events-that-will-be-posted-shortly" />
			</div>
		</c:if>
	</div>
</aui:form>

<aui:script>
	function <portlet:namespace />updateCurrentURL(response, url) {
		window.history.pushState(response, '', url);
	}

	Liferay.provide(
		window,
		'<portlet:namespace />filter',
		function(param, value, remove) {
			if (value == '') {
				return;
			}

			var inputEl = document.getElementById('<portlet:namespace />' + param);

			if (value == '-1') {
				inputEl.value = '';
			}
			else if ((value == 'true') || (value == 'false') || (inputEl.value == '') || remove) {
				inputEl.value = value;
			}
			else {
				var values = inputEl.value;

				if (values.indexOf(value) != -1) {
					var newValues = values.split(',');

					newValues.splice(newValues.indexOf(value), 1);

					inputEl.value = newValues.join();
				}
				else {
					inputEl.value = values + ',' + value;
				}
			}

			<portlet:namespace />refreshPortlet();
		}
	);

	Liferay.provide(
		window,
		'<portlet:namespace />openPopup',
		function(marketingEventId) {
			var A = AUI();

			var dialog = Liferay.Util.Window.getWindow(
				{
					dialog: {
						centered: false,
						constrain2view: true,
						cssClass: 'osb-www-marketing-events-portlet-popup',
						destroyOnHide: true,
						modal: true,
						resizable: false,
						toolbars: {
							header: [
								{
									cssClass: "close",
									on: {
										click: function(event) {
											dialog.hide();
										}
									},
									srcNode: A.Node.create('<button><svg height=20 width=20><use xlink:href="#closeIcon"></use></svg></button>')
								}
							]
						}
					},
					id: '<portlet:namespace/>dialog'
				}
			);

			dialog.plug(
				A.Plugin.IO,
				{
					data: {
						marketingEventId: marketingEventId
					},
					uri: '<liferay-portlet:renderURL secure="<%= request.isSecure() %>" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>"><portlet:param name="mvcPath" value="/view_marketing_event.jsp" /></liferay-portlet:renderURL>'
				}
			);
		},
		['aui-base', 'aui-io-plugin-deprecated', 'aui-io', 'liferay-util-window']
	);

	Liferay.provide(
		window,
		'<portlet:namespace/>closePopup',
		function(dialogId) {
			var dialog = Liferay.Util.Window.getById(dialogId);

			dialog.destroy();
		},
		['liferay-util-window']
	);

	Liferay.provide(
		window,
		'<portlet:namespace />refreshPortlet',
		function() {
			var A = AUI();

			var refreshURL = '<%= HtmlUtil.escapeJS(PortletURLUtil.getRefreshURL(request, themeDisplay)) %>';

			var filters = {};

			A.all('#<portlet:namespace />fm .event-filter').each(
				function(item, index, collection) {
					var name = item.attr('name');
					var value = item.attr('value');

					if (value != '') {
						name = name.replace('<portlet:namespace />', '');

						filters[name] = value;
					}
				}
			);

			var data = {};

			A.all('#<portlet:namespace />fm input[type=hidden]').each(
				function(item, index, collection) {
					data[item.attr('name')] = item.attr('value');
				}
			);

			var params = {};

			if (refreshURL.split('?').length > 1) {
				var refreshURLPieces = refreshURL.split('?');

				params = A.QueryString.parse(refreshURLPieces[1]);

				refreshURL = refreshURLPieces[0];
			}

			var marketingEventsContainer = A.one('#<portlet:namespace />marketingEventsContainer');

			marketingEventsContainer.hide();
			marketingEventsContainer.placeAfter(A.Node.create('<div class="loading-animation" />'));

			marketingEventsContainer.remove();

			Liferay.Portlet.addHTML(
				{
					data: A.mix(params, data, true),
					onComplete: function(portlet, portletId) {
						portlet.refreshURL = refreshURL;

						Liferay.fire(
							portlet.portletId + ':portletRefreshed',
							{
								portlet: portlet,
								portletId: portletId
							}
						);
					},
					placeHolder: A.one('#p_p_id<portlet:namespace />'),
					url: refreshURL
				}
			);

			var url = Liferay.ThemeDisplay.getLayoutURL();

			var filtersString = A.QueryString.stringify(filters);

			if (filtersString != '') {
				url = Liferay.Util.addParams(filtersString, url);
			}

			<portlet:namespace />updateCurrentURL(data, url);
		},
		['aui-base', 'querystring']
	);

	AUI().ready(
		'aui-base',
		function() {

			<%
			String marketingEventId = ParamUtil.getString(originalRequest, "marketingEventId");
			%>

			var marketingEventId = '<%= HtmlUtil.escapeJS(marketingEventId) %>';

			if ((marketingEventId != '') && (marketingEventId != 'null')) {
				<portlet:namespace />openPopup(marketingEventId);
			}
		}
	);
</aui:script>
	


<aui:script
	use='<%=showSearch ? "aui-base,aui-live-search-deprecated" : "aui-base"%>'>
	<c:if test="<%= showSearch %>">
		new A.LiveSearch(
			{
				input: '#<portlet:namespace />searchBox',
				nodes: '.osb-www-marketing-events-portlet .marketing-event'
			}
		);
	</c:if>

	A.one('#<portlet:namespace />marketingEventsContainer').delegate(
		'click',
		function(event) {
			var marketingEventId = event.currentTarget.getAttribute('data-marketing-event-id');

			<portlet:namespace />openPopup(marketingEventId);
		},
		'.marketing-event'
	);
</aui:script>