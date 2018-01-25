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

package com.liferay.osb.www.marketing.events.util;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetCategoryProperty;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetCategoryPropertyLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.osb.www.marketing.events.exception.NoSuchMarketingEventException;
import com.liferay.osb.www.marketing.events.model.MarketingEvent;
import com.liferay.osb.www.marketing.events.model.MarketingEventConstants;
import com.liferay.osb.www.marketing.events.model.MarketingEventSession;
import com.liferay.osb.www.marketing.events.model.MarketingEventUser;
import com.liferay.osb.www.marketing.events.service.MarketingEventLocalServiceUtil;
import com.liferay.osb.www.marketing.events.service.MarketingEventSessionLocalServiceUtil;
import com.liferay.osb.www.marketing.events.service.MarketingEventUserLocalServiceUtil;
import com.liferay.osb.www.marketing.events.util.comparator.MarketingEventUserFirstNameComparator;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.service.CountryServiceUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Tuple;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Rachael Koestartyo
 * @author Allen Ziegenfus
 * @author Ryan Schuhler
 * @author Joan H. Kim
 */
public class MarketingEventsUtil {

	public static AssetCategory fetchAssetCategory(
			String name, long assetVocabularyId)
		throws PortalException {

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AssetCategory.class);

		Property nameProperty = PropertyFactoryUtil.forName("name");

		dynamicQuery.add(nameProperty.eq(name));

		Property vocabularyIdProperty = PropertyFactoryUtil.forName(
			"vocabularyId");

		dynamicQuery.add(vocabularyIdProperty.eq(assetVocabularyId));

		List<AssetCategory> assetCategories =
			AssetCategoryLocalServiceUtil.dynamicQuery(dynamicQuery, 0, 1);

		if (!assetCategories.isEmpty()) {
			return assetCategories.get(0);
		}

		return null;
	}

	public static JSONArray getAssetCategoriesJSONArray(
			List<AssetCategory> assetCategories)
		throws PortalException {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (AssetCategory assetCategory : assetCategories) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			jsonObject.put("categoryId", assetCategory.getCategoryId());
			jsonObject.put("name", assetCategory.getName());
			jsonObject.put(
				"properties",
				getAssetCategoryPropertiesJSONObject(assetCategory));
			jsonObject.put("title", assetCategory.getTitle());
			jsonObject.put("vocabularyId", assetCategory.getVocabularyId());

			AssetVocabulary assetVocabulary =
				AssetVocabularyLocalServiceUtil.getAssetVocabulary(
					assetCategory.getVocabularyId());

			jsonObject.put("vocabularyName", assetVocabulary.getName());

			jsonArray.put(jsonObject);
		}

		return jsonArray;
	}

	public static JSONObject getAssetCategoryPropertiesJSONObject(
			AssetCategory assetCategory)
		throws PortalException {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		List<AssetCategoryProperty> assetCategoryProperties =
			AssetCategoryPropertyLocalServiceUtil.getCategoryProperties(
				assetCategory.getCategoryId());

		for (AssetCategoryProperty assetCategoryProperty :
				assetCategoryProperties) {

			jsonObject.put(
				assetCategoryProperty.getKey(),
				assetCategoryProperty.getValue());
		}

		return jsonObject;
	}

	public static List<Country> getCountries(
			int[] types, int[] globalRegions, int[] locationTypes,
			boolean pastEvents)
		throws Exception {

		List<MarketingEvent> marketingEvents =
			MarketingEventLocalServiceUtil.getMarketingEvents(
				types, globalRegions, null, locationTypes, pastEvents, null,
				null, null);

		if (marketingEvents.isEmpty()) {
			return Collections.emptyList();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Address.class, PortalClassLoaderUtil.getClassLoader());

		Property property = PropertyFactoryUtil.forName("addressId");

		long[] addressIds = StringUtil.split(
			ListUtil.toString(marketingEvents, "addressId"), 0L);

		List<Long> addressIdsList = new ArrayList<>(
			ListUtil.toList(addressIds));

		dynamicQuery.add(property.in(addressIdsList));

		ProjectionList projectionList = ProjectionFactoryUtil.projectionList();

		Projection projection = ProjectionFactoryUtil.property("countryId");

		projectionList.add(ProjectionFactoryUtil.distinct(projection));

		dynamicQuery.setProjection(projectionList);

		List<Long> countryIds = AddressLocalServiceUtil.dynamicQuery(
			dynamicQuery);

		List<Country> countries = getCountries(
			StringUtil.split(StringUtil.merge(countryIds), 0L));

		Comparator<Country> comparator = new Comparator<Country>() {

			@Override
			public int compare(Country country1, Country country2) {
				String name1 = country1.getName();
				String name2 = country2.getName();

				return name1.compareTo(name2);
			}

		};

		return ListUtil.sort(countries, comparator);
	}

	public static List<Country> getCountries(long[] countryIds)
		throws Exception {

		List<Country> countries = new ArrayList<>();

		for (long countryId : countryIds) {
			Country country = CountryServiceUtil.fetchCountry(countryId);

			if (country != null) {
				countries.add(country);
			}
		}

		return countries;
	}

	public static Country getCountry(long countryId) {
		if (_countries == null) {
			_countries = new HashMap<>();

			List<Country> countries = CountryServiceUtil.getCountries(true);

			for (Country country : countries) {
				_countries.put(country.getCountryId(), country);
			}
		}

		return _countries.get(countryId);
	}

	public static List<JSONObject> getGlobalRegionJSONObjects(
			int[] types, long[] countryIds, int[] locationTypes,
			boolean pastEvents, String userLanguageId)
		throws Exception {

		List<MarketingEvent> marketingEvents =
			MarketingEventLocalServiceUtil.getMarketingEvents(
				types, null, countryIds, locationTypes, pastEvents, null, null,
				null);

		Map<Integer, Integer> countToGlobalRegion = new HashMap<>();

		int[] globalRegions = ArrayUtil.remove(
			MarketingEventConstants.GLOBAL_REGIONS,
			MarketingEventConstants.GLOBAL_REGION_WORLDWIDE);

		for (MarketingEvent marketingEvent : marketingEvents) {
			int globalRegion = marketingEvent.getGlobalRegion();

			int[] globalRegionValues = {globalRegion};

			if (globalRegion ==
					MarketingEventConstants.GLOBAL_REGION_WORLDWIDE) {

				globalRegionValues = ArrayUtil.clone(globalRegions);
			}

			for (int globalRegionValue : globalRegionValues) {
				if (!countToGlobalRegion.containsKey(globalRegionValue)) {
					countToGlobalRegion.put(globalRegionValue, 1);
				}
				else {
					int count = countToGlobalRegion.get(globalRegionValue);

					countToGlobalRegion.put(globalRegionValue, count + 1);
				}
			}
		}

		Locale locale = LocaleUtil.fromLanguageId(userLanguageId, false);

		List<JSONObject> jsonObjects = new ArrayList<>();

		for (int globalRegion : globalRegions) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			int count = GetterUtil.getInteger(
				countToGlobalRegion.get(globalRegion));

			jsonObject.put("count", count);

			String label = MarketingEventConstants.getGlobalRegionLabel(
				globalRegion, true);

			jsonObject.put("label", LanguageUtil.format(locale, label, count));

			jsonObject.put("globalRegion", globalRegion);

			jsonObjects.add(jsonObject);
		}

		return ListUtil.sort(jsonObjects, new MarketingEventsUtilComparator());
	}

	public static List<JSONObject> getLocationTypeJSONObjects(
			int[] types, int[] globalRegions, long[] countryIds,
			boolean pastEvents, String userLanguageId)
		throws Exception {

		List<MarketingEvent> marketingEvents =
			MarketingEventLocalServiceUtil.getMarketingEvents(
				types, globalRegions, countryIds, null, pastEvents, null, null,
				null);

		Map<Integer, Integer> countToLocationType = new HashMap<>();

		for (MarketingEvent marketingEvent : marketingEvents) {
			int locationType = MarketingEventConstants.LOCATION_TYPE_IN_PERSON;

			if (marketingEvent.isOnline()) {
				locationType = MarketingEventConstants.LOCATION_TYPE_ONLINE;
			}

			if (!countToLocationType.containsKey(locationType)) {
				countToLocationType.put(locationType, 1);
			}
			else {
				countToLocationType.put(
					locationType, countToLocationType.get(locationType) + 1);
			}
		}

		Locale locale = LocaleUtil.fromLanguageId(userLanguageId, false);

		List<JSONObject> jsonObjects = new ArrayList<>();

		for (int locationType : MarketingEventConstants.LOCATION_TYPES) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			int count = GetterUtil.getInteger(
				countToLocationType.get(locationType));

			jsonObject.put("count", count);

			String label = MarketingEventConstants.getLocationTypeLabel(
				locationType, true);

			jsonObject.put("label", LanguageUtil.format(locale, label, count));

			jsonObject.put("locationType", locationType);

			jsonObjects.add(jsonObject);
		}

		return ListUtil.sort(jsonObjects, new MarketingEventsUtilComparator());
	}

	public static Tuple getMarketingEvents(Hits hits) throws PortalException {
		boolean corruptIndex = false;
		List<MarketingEvent> marketingEvents = new ArrayList<>();

		for (Document document : hits.toList()) {
			long marketingEventId = GetterUtil.getLong(
				document.get(Field.ENTRY_CLASS_PK));

			try {
				MarketingEvent marketingEvent =
					MarketingEventLocalServiceUtil.getMarketingEvent(
						marketingEventId);

				marketingEvents.add(marketingEvent);
			}
			catch (NoSuchMarketingEventException nsmee) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"Unable to find marketing event with document UID " +
							document.getUID());
				}

				corruptIndex = true;

				Indexer<MarketingEvent> indexer =
					IndexerRegistryUtil.getIndexer(MarketingEvent.class);

				long companyId = GetterUtil.getLong(
					document.get(Field.COMPANY_ID));

				indexer.delete(companyId, document.getUID());
			}
		}

		return new Tuple(marketingEvents, corruptIndex);
	}

	public static List<JSONObject> getTypeJSONObjects(
			int[] globalRegions, long[] countryIds, int[] locationTypes,
			boolean pastEvents, String userLanguageId)
		throws Exception {

		List<MarketingEvent> marketingEvents =
			MarketingEventLocalServiceUtil.getMarketingEvents(
				null, globalRegions, countryIds, locationTypes, pastEvents,
				null, null, null);

		Map<Integer, Integer> countToType = new HashMap<>();

		for (MarketingEvent marketingEvent : marketingEvents) {
			int type = marketingEvent.getType();

			if (!countToType.containsKey(type)) {
				countToType.put(type, 1);
			}
			else {
				countToType.put(type, countToType.get(type) + 1);
			}
		}

		Locale locale = LocaleUtil.fromLanguageId(userLanguageId, false);

		List<JSONObject> jsonObjects = new ArrayList<>();

		for (int type : MarketingEventConstants.TYPES) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			int count = GetterUtil.getInteger(countToType.get(type));

			jsonObject.put("count", count);

			String label = MarketingEventConstants.getTypeLabel(type, true);

			jsonObject.put("label", LanguageUtil.format(locale, label, count));

			jsonObject.put("type", type);

			jsonObjects.add(jsonObject);
		}

		return ListUtil.sort(jsonObjects, new MarketingEventsUtilComparator());
	}

	private static final Log _log = LogFactoryUtil.getLog(
		MarketingEventsUtil.class);

	private static Map<Long, Country> _countries;

	private static class MarketingEventsUtilComparator
		implements Comparator<JSONObject> {

		@Override
		public int compare(JSONObject jsonObject1, JSONObject jsonObject2) {
			String label1 = jsonObject1.getString("label");
			String label2 = jsonObject2.getString("label");

			int value = label1.compareTo(label2);

			if (value == 0) {
				int count1 = jsonObject1.getInt("count");
				int count2 = jsonObject2.getInt("count");

				value = count2 - count1;
			}

			return value;
		}

	}

}