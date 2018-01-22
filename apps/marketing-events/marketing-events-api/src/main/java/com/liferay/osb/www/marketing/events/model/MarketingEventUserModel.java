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
 * The base model interface for the MarketingEventUser service. Represents a row in the &quot;OSB_MarketingEventUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventUserModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.osb.www.marketing.events.model.impl.MarketingEventUserImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventUser
 * @see com.liferay.osb.www.marketing.events.model.impl.MarketingEventUserImpl
 * @see com.liferay.osb.www.marketing.events.model.impl.MarketingEventUserModelImpl
 * @generated
 */
@ProviderType
public interface MarketingEventUserModel extends BaseModel<MarketingEventUser>,
	LocalizedModel, ShardedModel, StagedAuditedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a marketing event user model instance should use the {@link MarketingEventUser} interface instead.
	 */

	/**
	 * Returns the primary key of this marketing event user.
	 *
	 * @return the primary key of this marketing event user
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this marketing event user.
	 *
	 * @param primaryKey the primary key of this marketing event user
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this marketing event user.
	 *
	 * @return the uuid of this marketing event user
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this marketing event user.
	 *
	 * @param uuid the uuid of this marketing event user
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the marketing event user ID of this marketing event user.
	 *
	 * @return the marketing event user ID of this marketing event user
	 */
	public long getMarketingEventUserId();

	/**
	 * Sets the marketing event user ID of this marketing event user.
	 *
	 * @param marketingEventUserId the marketing event user ID of this marketing event user
	 */
	public void setMarketingEventUserId(long marketingEventUserId);

	/**
	 * Returns the marketing event user uuid of this marketing event user.
	 *
	 * @return the marketing event user uuid of this marketing event user
	 */
	public String getMarketingEventUserUuid();

	/**
	 * Sets the marketing event user uuid of this marketing event user.
	 *
	 * @param marketingEventUserUuid the marketing event user uuid of this marketing event user
	 */
	public void setMarketingEventUserUuid(String marketingEventUserUuid);

	/**
	 * Returns the company ID of this marketing event user.
	 *
	 * @return the company ID of this marketing event user
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this marketing event user.
	 *
	 * @param companyId the company ID of this marketing event user
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this marketing event user.
	 *
	 * @return the user ID of this marketing event user
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this marketing event user.
	 *
	 * @param userId the user ID of this marketing event user
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this marketing event user.
	 *
	 * @return the user uuid of this marketing event user
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this marketing event user.
	 *
	 * @param userUuid the user uuid of this marketing event user
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this marketing event user.
	 *
	 * @return the user name of this marketing event user
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this marketing event user.
	 *
	 * @param userName the user name of this marketing event user
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this marketing event user.
	 *
	 * @return the create date of this marketing event user
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this marketing event user.
	 *
	 * @param createDate the create date of this marketing event user
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this marketing event user.
	 *
	 * @return the modified date of this marketing event user
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this marketing event user.
	 *
	 * @param modifiedDate the modified date of this marketing event user
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the marketing event ID of this marketing event user.
	 *
	 * @return the marketing event ID of this marketing event user
	 */
	public long getMarketingEventId();

	/**
	 * Sets the marketing event ID of this marketing event user.
	 *
	 * @param marketingEventId the marketing event ID of this marketing event user
	 */
	public void setMarketingEventId(long marketingEventId);

	/**
	 * Returns the first name of this marketing event user.
	 *
	 * @return the first name of this marketing event user
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this marketing event user.
	 *
	 * @param firstName the first name of this marketing event user
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the last name of this marketing event user.
	 *
	 * @return the last name of this marketing event user
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this marketing event user.
	 *
	 * @param lastName the last name of this marketing event user
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the company name of this marketing event user.
	 *
	 * @return the company name of this marketing event user
	 */
	@AutoEscape
	public String getCompanyName();

	/**
	 * Sets the company name of this marketing event user.
	 *
	 * @param companyName the company name of this marketing event user
	 */
	public void setCompanyName(String companyName);

	/**
	 * Returns the company logo file entry ID of this marketing event user.
	 *
	 * @return the company logo file entry ID of this marketing event user
	 */
	public long getCompanyLogoFileEntryId();

	/**
	 * Sets the company logo file entry ID of this marketing event user.
	 *
	 * @param companyLogoFileEntryId the company logo file entry ID of this marketing event user
	 */
	public void setCompanyLogoFileEntryId(long companyLogoFileEntryId);

	/**
	 * Returns the job title of this marketing event user.
	 *
	 * @return the job title of this marketing event user
	 */
	public String getJobTitle();

	/**
	 * Returns the localized job title of this marketing event user in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized job title of this marketing event user
	 */
	@AutoEscape
	public String getJobTitle(Locale locale);

	/**
	 * Returns the localized job title of this marketing event user in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized job title of this marketing event user. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getJobTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized job title of this marketing event user in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized job title of this marketing event user
	 */
	@AutoEscape
	public String getJobTitle(String languageId);

	/**
	 * Returns the localized job title of this marketing event user in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized job title of this marketing event user
	 */
	@AutoEscape
	public String getJobTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getJobTitleCurrentLanguageId();

	@AutoEscape
	public String getJobTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized job titles of this marketing event user.
	 *
	 * @return the locales and localized job titles of this marketing event user
	 */
	public Map<Locale, String> getJobTitleMap();

	/**
	 * Sets the job title of this marketing event user.
	 *
	 * @param jobTitle the job title of this marketing event user
	 */
	public void setJobTitle(String jobTitle);

	/**
	 * Sets the localized job title of this marketing event user in the language.
	 *
	 * @param jobTitle the localized job title of this marketing event user
	 * @param locale the locale of the language
	 */
	public void setJobTitle(String jobTitle, Locale locale);

	/**
	 * Sets the localized job title of this marketing event user in the language, and sets the default locale.
	 *
	 * @param jobTitle the localized job title of this marketing event user
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setJobTitle(String jobTitle, Locale locale, Locale defaultLocale);

	public void setJobTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized job titles of this marketing event user from the map of locales and localized job titles.
	 *
	 * @param jobTitleMap the locales and localized job titles of this marketing event user
	 */
	public void setJobTitleMap(Map<Locale, String> jobTitleMap);

	/**
	 * Sets the localized job titles of this marketing event user from the map of locales and localized job titles, and sets the default locale.
	 *
	 * @param jobTitleMap the locales and localized job titles of this marketing event user
	 * @param defaultLocale the default locale
	 */
	public void setJobTitleMap(Map<Locale, String> jobTitleMap,
		Locale defaultLocale);

	/**
	 * Returns the description of this marketing event user.
	 *
	 * @return the description of this marketing event user
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this marketing event user in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this marketing event user
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this marketing event user in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this marketing event user. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this marketing event user in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this marketing event user
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this marketing event user in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this marketing event user
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this marketing event user.
	 *
	 * @return the locales and localized descriptions of this marketing event user
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this marketing event user.
	 *
	 * @param description the description of this marketing event user
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this marketing event user in the language.
	 *
	 * @param description the localized description of this marketing event user
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this marketing event user in the language, and sets the default locale.
	 *
	 * @param description the localized description of this marketing event user
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(String description, Locale locale,
		Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this marketing event user from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this marketing event user
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this marketing event user from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this marketing event user
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale);

	/**
	 * Returns the image file entry ID of this marketing event user.
	 *
	 * @return the image file entry ID of this marketing event user
	 */
	public long getImageFileEntryId();

	/**
	 * Sets the image file entry ID of this marketing event user.
	 *
	 * @param imageFileEntryId the image file entry ID of this marketing event user
	 */
	public void setImageFileEntryId(long imageFileEntryId);

	/**
	 * Returns the phone number of this marketing event user.
	 *
	 * @return the phone number of this marketing event user
	 */
	@AutoEscape
	public String getPhoneNumber();

	/**
	 * Sets the phone number of this marketing event user.
	 *
	 * @param phoneNumber the phone number of this marketing event user
	 */
	public void setPhoneNumber(String phoneNumber);

	/**
	 * Returns the status of this marketing event user.
	 *
	 * @return the status of this marketing event user
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this marketing event user.
	 *
	 * @param status the status of this marketing event user
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this marketing event user.
	 *
	 * @return the status by user ID of this marketing event user
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this marketing event user.
	 *
	 * @param statusByUserId the status by user ID of this marketing event user
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this marketing event user.
	 *
	 * @return the status by user uuid of this marketing event user
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this marketing event user.
	 *
	 * @param statusByUserUuid the status by user uuid of this marketing event user
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this marketing event user.
	 *
	 * @return the status by user name of this marketing event user
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this marketing event user.
	 *
	 * @param statusByUserName the status by user name of this marketing event user
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this marketing event user.
	 *
	 * @return the status date of this marketing event user
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this marketing event user.
	 *
	 * @param statusDate the status date of this marketing event user
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns <code>true</code> if this marketing event user is approved.
	 *
	 * @return <code>true</code> if this marketing event user is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this marketing event user is denied.
	 *
	 * @return <code>true</code> if this marketing event user is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this marketing event user is a draft.
	 *
	 * @return <code>true</code> if this marketing event user is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this marketing event user is expired.
	 *
	 * @return <code>true</code> if this marketing event user is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this marketing event user is inactive.
	 *
	 * @return <code>true</code> if this marketing event user is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this marketing event user is incomplete.
	 *
	 * @return <code>true</code> if this marketing event user is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this marketing event user is pending.
	 *
	 * @return <code>true</code> if this marketing event user is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this marketing event user is scheduled.
	 *
	 * @return <code>true</code> if this marketing event user is scheduled; <code>false</code> otherwise
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
	public int compareTo(MarketingEventUser marketingEventUser);

	@Override
	public int hashCode();

	@Override
	public CacheModel<MarketingEventUser> toCacheModel();

	@Override
	public MarketingEventUser toEscapedModel();

	@Override
	public MarketingEventUser toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}