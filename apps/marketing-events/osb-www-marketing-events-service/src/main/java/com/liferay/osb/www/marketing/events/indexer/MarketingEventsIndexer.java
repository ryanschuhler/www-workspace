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

package com.liferay.osb.www.marketing.events.indexer;

import com.liferay.osb.www.marketing.events.constants.OSBWWWMarketingEventsPortletKeys;
import com.liferay.osb.www.marketing.events.model.MarketingEvent;
import com.liferay.osb.www.marketing.events.service.MarketingEventLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.util.FastDateFormatFactory;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.Format;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Peter Shin
 */
@Component(immediate = true, service = Indexer.class)
public class MarketingEventsIndexer extends BaseIndexer<MarketingEvent> {

	public static final String CLASS_NAME = MarketingEvent.class.getName();

	public static final String PORTLET_ID =
		OSBWWWMarketingEventsPortletKeys.MARKETING_EVENTS_ADMIN;

	public MarketingEventsIndexer() {
		setCommitImmediately(true);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	public String getPortletId() {
		return PORTLET_ID;
	}

	public void postProcessSearchQuery(
			BooleanQuery searchQuery, SearchContext searchContext)
		throws Exception {

		addSearchLocalizedTerm(searchQuery, searchContext, Field.TITLE, true);

		int[] globalRegions = (int[])searchContext.getAttribute("globalRegion");
		addSearchArrayQuery(
			searchQuery, searchContext, "globalRegion", globalRegions);

		addSearchLocalizedTerm(searchQuery, searchContext, "summary", false);

		int[] types = (int[])searchContext.getAttribute("type");
		addSearchArrayQuery(searchQuery, searchContext, "type", types);

		Date startDateGT = (Date)searchContext.getAttribute("startDateGT");
		Date startDateLT = (Date)searchContext.getAttribute("startDateLT");

		addSearchDateQuery(
			searchQuery, searchContext, "startDate", startDateGT, startDateLT);
	}

	@Activate
	protected void activate() {
		_dateFormat = _fastDateFormatFactory.getSimpleDateFormat(
			PropsUtil.get(PropsKeys.INDEX_DATE_FORMAT_PATTERN));
	}

	protected void addLocalizedText(
		Document document, String field, String xml) {

		String defaultLanguageId = LocalizationUtil.getDefaultLanguageId(xml);

		Map<Locale, String> valueMap = LocalizationUtil.getLocalizationMap(xml);

		for (Map.Entry<Locale, String> valueEntry : valueMap.entrySet()) {
			Locale locale = valueEntry.getKey();
			String value = valueEntry.getValue();

			if (Validator.isNull(value)) {
				continue;
			}

			String languageId = LocaleUtil.toLanguageId(locale);

			if (languageId.equals(defaultLanguageId)) {
				document.addText(field, value);
			}

			document.addText(
				DocumentImpl.getLocalizedName(locale, field), value);
		}
	}

	protected void addSearchArrayQuery(BooleanQuery searchQuery, SearchContext searchContext,
			String field, int[] fieldValues)
		throws ParseException {

		BooleanQueryImpl booleanQuery = new BooleanQueryImpl();

		if (fieldValues == null) {
			return;
		}

		for (int fieldValue : fieldValues) {
			booleanQuery.addTerm(field, fieldValue);
		}

		if (searchContext.isAndSearch()) {
			searchQuery.add(booleanQuery, BooleanClauseOccur.MUST);
		}
		else {
			searchQuery.add(booleanQuery, BooleanClauseOccur.SHOULD);
		}
	}

	protected void addSearchDateQuery(
			BooleanQuery searchQuery, SearchContext searchContext, String field,
			Date dateGT, Date dateLT)
		throws ParseException {

		if ((dateGT == null) && (dateLT == null)) {
			return;
		}

		String startValue = null;
		String endValue = null;

		if (dateGT != null) {
			startValue = _dateFormat.format(dateGT);
		}

		if (dateLT != null) {
			endValue = _dateFormat.format(dateLT);
		}

		BooleanQueryImpl booleanQuery = new BooleanQueryImpl();

		booleanQuery.addRangeTerm(field, startValue, endValue);

		if (searchContext.isAndSearch()) {
			searchQuery.add(booleanQuery, BooleanClauseOccur.MUST);
		}
		else {
			searchQuery.add(booleanQuery, BooleanClauseOccur.SHOULD);
		}
	}

	@Override
	protected void doDelete(MarketingEvent marketingEvent) throws Exception {
		deleteDocument(
			marketingEvent.getCompanyId(),
			marketingEvent.getMarketingEventId());
	}

	@Override
	protected Document doGetDocument(MarketingEvent marketingEvent)
		throws Exception {

		Document document = getBaseModelDocument(PORTLET_ID, marketingEvent);

		document.addKeyword(
			Field.CLASS_PK, marketingEvent.getMarketingEventId());
		document.addKeyword(Field.COMPANY_ID, marketingEvent.getCompanyId());
		document.addDate(Field.CREATE_DATE, marketingEvent.getCreateDate());
		document.addDate(Field.MODIFIED_DATE, marketingEvent.getModifiedDate());
		document.addNumberSortable(Field.TYPE, marketingEvent.getType());
		document.addKeyword(Field.USER_ID, marketingEvent.getUserId());
		document.addNumberSortable(
			"globalRegion", marketingEvent.getGlobalRegion());
		document.addDate("startDate", marketingEvent.getStartDate());

		addLocalizedText(
			document, Field.TITLE,
			HtmlUtil.extractText(marketingEvent.getTitle()));
		addLocalizedText(
			document, "summary",
			HtmlUtil.extractText(marketingEvent.getSummary()));

		return document;
	}

	@Override
	protected String doGetSortField(String orderByCol) {
		if (orderByCol.equals("global-region")) {
			return "globalRegion_Number_sortable";
		}
		else if (orderByCol.equals("start-date")) {
			return "startDate_sortable";
		}
		else if (orderByCol.equals("type")) {
			return "type_Number_sortable";
		}
		else {
			return orderByCol;
		}
	}

	@Override
	protected Summary doGetSummary(
		Document document, Locale locale, String snippet,
		PortletRequest portletRequest, PortletResponse portletResponse)
			{

		String title = document.get(Field.TITLE);

		String content = snippet;

		if (Validator.isNull(snippet)) {
			content = StringUtil.shorten(
				HtmlUtil.extractText(document.get("summary")), 200);
		}

		String classPK = document.get(Field.ENTRY_CLASS_PK);

		return new Summary(title, content);
	}

	protected void doReindex(MarketingEvent marketingEvent)
		throws SearchException {

		Document document = getDocument(marketingEvent);

		SearchEngineUtil.updateDocument(
			getSearchEngineId(), marketingEvent.getCompanyId(), document,
			isCommitImmediately());
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		MarketingEvent marketingEvent =
			MarketingEventLocalServiceUtil.getMarketingEvent(classPK);

		doReindex(marketingEvent);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			MarketingEventLocalServiceUtil.getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setCompanyId(companyId);

		indexableActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<MarketingEvent>() {

				@Override
				public void performAction(MarketingEvent marketingEvent)
					throws PortalException {

					indexableActionableDynamicQuery.addDocuments(
						getDocument(marketingEvent));
				}

			});

		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());

		indexableActionableDynamicQuery.performActions();
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return PORTLET_ID;
	}

	private Format _dateFormat;

	@Reference
	private FastDateFormatFactory _fastDateFormatFactory;

}