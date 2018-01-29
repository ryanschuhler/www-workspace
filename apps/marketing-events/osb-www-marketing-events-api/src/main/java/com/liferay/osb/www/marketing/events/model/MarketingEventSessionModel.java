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

package com.liferay.osb.www.marketing.events.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the MarketingEventSession service. Represents a row in the &quot;OSB_MarketingEventSession&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventSessionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventSessionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSession
 * @see com.liferay.osb.www.marketing.events.model.impl.MarketingEventSessionImpl
 * @see com.liferay.osb.www.marketing.events.model.impl.MarketingEventSessionModelImpl
 * @generated
 */
@ProviderType
public interface MarketingEventSessionModel extends BaseModel<MarketingEventSession>,
	LocalizedModel, ShardedModel, StagedAuditedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a marketing event session model instance should use the {@link MarketingEventSession} interface instead.
	 */

	/**
	 * Returns the primary key of this marketing event session.
	 *
	 * @return the primary key of this marketing event session
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this marketing event session.
	 *
	 * @param primaryKey the primary key of this marketing event session
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this marketing event session.
	 *
	 * @return the uuid of this marketing event session
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this marketing event session.
	 *
	 * @param uuid the uuid of this marketing event session
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the marketing event session ID of this marketing event session.
	 *
	 * @return the marketing event session ID of this marketing event session
	 */
	public long getMarketingEventSessionId();

	/**
	 * Sets the marketing event session ID of this marketing event session.
	 *
	 * @param marketingEventSessionId the marketing event session ID of this marketing event session
	 */
	public void setMarketingEventSessionId(long marketingEventSessionId);

	/**
	 * Returns the company ID of this marketing event session.
	 *
	 * @return the company ID of this marketing event session
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this marketing event session.
	 *
	 * @param companyId the company ID of this marketing event session
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this marketing event session.
	 *
	 * @return the user ID of this marketing event session
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this marketing event session.
	 *
	 * @param userId the user ID of this marketing event session
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this marketing event session.
	 *
	 * @return the user uuid of this marketing event session
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this marketing event session.
	 *
	 * @param userUuid the user uuid of this marketing event session
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this marketing event session.
	 *
	 * @return the user name of this marketing event session
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this marketing event session.
	 *
	 * @param userName the user name of this marketing event session
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this marketing event session.
	 *
	 * @return the create date of this marketing event session
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this marketing event session.
	 *
	 * @param createDate the create date of this marketing event session
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this marketing event session.
	 *
	 * @return the modified date of this marketing event session
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this marketing event session.
	 *
	 * @param modifiedDate the modified date of this marketing event session
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the marketing event ID of this marketing event session.
	 *
	 * @return the marketing event ID of this marketing event session
	 */
	public long getMarketingEventId();

	/**
	 * Sets the marketing event ID of this marketing event session.
	 *
	 * @param marketingEventId the marketing event ID of this marketing event session
	 */
	public void setMarketingEventId(long marketingEventId);

	/**
	 * Returns the marketing event session room ID of this marketing event session.
	 *
	 * @return the marketing event session room ID of this marketing event session
	 */
	public long getMarketingEventSessionRoomId();

	/**
	 * Sets the marketing event session room ID of this marketing event session.
	 *
	 * @param marketingEventSessionRoomId the marketing event session room ID of this marketing event session
	 */
	public void setMarketingEventSessionRoomId(long marketingEventSessionRoomId);

	/**
	 * Returns the title of this marketing event session.
	 *
	 * @return the title of this marketing event session
	 */
	public String getTitle();

	/**
	 * Returns the localized title of this marketing event session in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this marketing event session
	 */
	@AutoEscape
	public String getTitle(Locale locale);

	/**
	 * Returns the localized title of this marketing event session in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this marketing event session. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title of this marketing event session in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this marketing event session
	 */
	@AutoEscape
	public String getTitle(String languageId);

	/**
	 * Returns the localized title of this marketing event session in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this marketing event session
	 */
	@AutoEscape
	public String getTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleCurrentLanguageId();

	@AutoEscape
	public String getTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized titles of this marketing event session.
	 *
	 * @return the locales and localized titles of this marketing event session
	 */
	public Map<Locale, String> getTitleMap();

	/**
	 * Sets the title of this marketing event session.
	 *
	 * @param title the title of this marketing event session
	 */
	public void setTitle(String title);

	/**
	 * Sets the localized title of this marketing event session in the language.
	 *
	 * @param title the localized title of this marketing event session
	 * @param locale the locale of the language
	 */
	public void setTitle(String title, Locale locale);

	/**
	 * Sets the localized title of this marketing event session in the language, and sets the default locale.
	 *
	 * @param title the localized title of this marketing event session
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitle(String title, Locale locale, Locale defaultLocale);

	public void setTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titles of this marketing event session from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this marketing event session
	 */
	public void setTitleMap(Map<Locale, String> titleMap);

	/**
	 * Sets the localized titles of this marketing event session from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this marketing event session
	 * @param defaultLocale the default locale
	 */
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale);

	/**
	 * Returns the description of this marketing event session.
	 *
	 * @return the description of this marketing event session
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this marketing event session in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this marketing event session
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this marketing event session in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this marketing event session. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this marketing event session in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this marketing event session
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this marketing event session in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this marketing event session
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this marketing event session.
	 *
	 * @return the locales and localized descriptions of this marketing event session
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this marketing event session.
	 *
	 * @param description the description of this marketing event session
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this marketing event session in the language.
	 *
	 * @param description the localized description of this marketing event session
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this marketing event session in the language, and sets the default locale.
	 *
	 * @param description the localized description of this marketing event session
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(String description, Locale locale,
		Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this marketing event session from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this marketing event session
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this marketing event session from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this marketing event session
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale);

	/**
	 * Returns the keywords of this marketing event session.
	 *
	 * @return the keywords of this marketing event session
	 */
	public String getKeywords();

	/**
	 * Returns the localized keywords of this marketing event session in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized keywords of this marketing event session
	 */
	@AutoEscape
	public String getKeywords(Locale locale);

	/**
	 * Returns the localized keywords of this marketing event session in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized keywords of this marketing event session. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getKeywords(Locale locale, boolean useDefault);

	/**
	 * Returns the localized keywords of this marketing event session in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized keywords of this marketing event session
	 */
	@AutoEscape
	public String getKeywords(String languageId);

	/**
	 * Returns the localized keywords of this marketing event session in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized keywords of this marketing event session
	 */
	@AutoEscape
	public String getKeywords(String languageId, boolean useDefault);

	@AutoEscape
	public String getKeywordsCurrentLanguageId();

	@AutoEscape
	public String getKeywordsCurrentValue();

	/**
	 * Returns a map of the locales and localized keywordses of this marketing event session.
	 *
	 * @return the locales and localized keywordses of this marketing event session
	 */
	public Map<Locale, String> getKeywordsMap();

	/**
	 * Sets the keywords of this marketing event session.
	 *
	 * @param keywords the keywords of this marketing event session
	 */
	public void setKeywords(String keywords);

	/**
	 * Sets the localized keywords of this marketing event session in the language.
	 *
	 * @param keywords the localized keywords of this marketing event session
	 * @param locale the locale of the language
	 */
	public void setKeywords(String keywords, Locale locale);

	/**
	 * Sets the localized keywords of this marketing event session in the language, and sets the default locale.
	 *
	 * @param keywords the localized keywords of this marketing event session
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setKeywords(String keywords, Locale locale, Locale defaultLocale);

	public void setKeywordsCurrentLanguageId(String languageId);

	/**
	 * Sets the localized keywordses of this marketing event session from the map of locales and localized keywordses.
	 *
	 * @param keywordsMap the locales and localized keywordses of this marketing event session
	 */
	public void setKeywordsMap(Map<Locale, String> keywordsMap);

	/**
	 * Sets the localized keywordses of this marketing event session from the map of locales and localized keywordses, and sets the default locale.
	 *
	 * @param keywordsMap the locales and localized keywordses of this marketing event session
	 * @param defaultLocale the default locale
	 */
	public void setKeywordsMap(Map<Locale, String> keywordsMap,
		Locale defaultLocale);

	/**
	 * Returns the slides file entry ID of this marketing event session.
	 *
	 * @return the slides file entry ID of this marketing event session
	 */
	public long getSlidesFileEntryId();

	/**
	 * Sets the slides file entry ID of this marketing event session.
	 *
	 * @param slidesFileEntryId the slides file entry ID of this marketing event session
	 */
	public void setSlidesFileEntryId(long slidesFileEntryId);

	/**
	 * Returns the video url of this marketing event session.
	 *
	 * @return the video url of this marketing event session
	 */
	@AutoEscape
	public String getVideoURL();

	/**
	 * Sets the video url of this marketing event session.
	 *
	 * @param videoURL the video url of this marketing event session
	 */
	public void setVideoURL(String videoURL);

	/**
	 * Returns the start date of this marketing event session.
	 *
	 * @return the start date of this marketing event session
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this marketing event session.
	 *
	 * @param startDate the start date of this marketing event session
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this marketing event session.
	 *
	 * @return the end date of this marketing event session
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this marketing event session.
	 *
	 * @param endDate the end date of this marketing event session
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the status of this marketing event session.
	 *
	 * @return the status of this marketing event session
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this marketing event session.
	 *
	 * @param status the status of this marketing event session
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this marketing event session.
	 *
	 * @return the status by user ID of this marketing event session
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this marketing event session.
	 *
	 * @param statusByUserId the status by user ID of this marketing event session
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this marketing event session.
	 *
	 * @return the status by user uuid of this marketing event session
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this marketing event session.
	 *
	 * @param statusByUserUuid the status by user uuid of this marketing event session
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this marketing event session.
	 *
	 * @return the status by user name of this marketing event session
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this marketing event session.
	 *
	 * @param statusByUserName the status by user name of this marketing event session
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this marketing event session.
	 *
	 * @return the status date of this marketing event session
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this marketing event session.
	 *
	 * @param statusDate the status date of this marketing event session
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns <code>true</code> if this marketing event session is approved.
	 *
	 * @return <code>true</code> if this marketing event session is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this marketing event session is denied.
	 *
	 * @return <code>true</code> if this marketing event session is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this marketing event session is a draft.
	 *
	 * @return <code>true</code> if this marketing event session is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this marketing event session is expired.
	 *
	 * @return <code>true</code> if this marketing event session is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this marketing event session is inactive.
	 *
	 * @return <code>true</code> if this marketing event session is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this marketing event session is incomplete.
	 *
	 * @return <code>true</code> if this marketing event session is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this marketing event session is pending.
	 *
	 * @return <code>true</code> if this marketing event session is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this marketing event session is scheduled.
	 *
	 * @return <code>true</code> if this marketing event session is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public Object clone();

	@Override
	public int compareTo(MarketingEventSession marketingEventSession);

	@Override
	public int hashCode();

	@Override
	public CacheModel<MarketingEventSession> toCacheModel();

	@Override
	public MarketingEventSession toEscapedModel();

	@Override
	public MarketingEventSession toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}