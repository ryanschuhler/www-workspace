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

package com.liferay.osb.www.marketing.events.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osb.www.marketing.events.model.MarketingEvent;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MarketingEvent in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEvent
 * @generated
 */
@ProviderType
public class MarketingEventCacheModel implements CacheModel<MarketingEvent>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarketingEventCacheModel)) {
			return false;
		}

		MarketingEventCacheModel marketingEventCacheModel = (MarketingEventCacheModel)obj;

		if (marketingEventId == marketingEventCacheModel.marketingEventId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, marketingEventId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{marketingEventId=");
		sb.append(marketingEventId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", type=");
		sb.append(type);
		sb.append(", title=");
		sb.append(title);
		sb.append(", titleURL=");
		sb.append(titleURL);
		sb.append(", hostedBy=");
		sb.append(hostedBy);
		sb.append(", hostedByURL=");
		sb.append(hostedByURL);
		sb.append(", summary=");
		sb.append(summary);
		sb.append(", siteGroupId=");
		sb.append(siteGroupId);
		sb.append(", imageFileEntryId=");
		sb.append(imageFileEntryId);
		sb.append(", slidesFileEntryId=");
		sb.append(slidesFileEntryId);
		sb.append(", videoTitle=");
		sb.append(videoTitle);
		sb.append(", timeZoneId=");
		sb.append(timeZoneId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", dateTBA=");
		sb.append(dateTBA);
		sb.append(", addressId=");
		sb.append(addressId);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", globalRegion=");
		sb.append(globalRegion);
		sb.append(", online=");
		sb.append(online);
		sb.append(", registrationType=");
		sb.append(registrationType);
		sb.append(", registrationURL=");
		sb.append(registrationURL);
		sb.append(", extraSettings=");
		sb.append(extraSettings);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MarketingEvent toEntityModel() {
		MarketingEventImpl marketingEventImpl = new MarketingEventImpl();

		marketingEventImpl.setMarketingEventId(marketingEventId);
		marketingEventImpl.setCompanyId(companyId);
		marketingEventImpl.setUserId(userId);

		if (userName == null) {
			marketingEventImpl.setUserName(StringPool.BLANK);
		}
		else {
			marketingEventImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			marketingEventImpl.setCreateDate(null);
		}
		else {
			marketingEventImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			marketingEventImpl.setModifiedDate(null);
		}
		else {
			marketingEventImpl.setModifiedDate(new Date(modifiedDate));
		}

		marketingEventImpl.setType(type);

		if (title == null) {
			marketingEventImpl.setTitle(StringPool.BLANK);
		}
		else {
			marketingEventImpl.setTitle(title);
		}

		if (titleURL == null) {
			marketingEventImpl.setTitleURL(StringPool.BLANK);
		}
		else {
			marketingEventImpl.setTitleURL(titleURL);
		}

		if (hostedBy == null) {
			marketingEventImpl.setHostedBy(StringPool.BLANK);
		}
		else {
			marketingEventImpl.setHostedBy(hostedBy);
		}

		if (hostedByURL == null) {
			marketingEventImpl.setHostedByURL(StringPool.BLANK);
		}
		else {
			marketingEventImpl.setHostedByURL(hostedByURL);
		}

		if (summary == null) {
			marketingEventImpl.setSummary(StringPool.BLANK);
		}
		else {
			marketingEventImpl.setSummary(summary);
		}

		marketingEventImpl.setSiteGroupId(siteGroupId);
		marketingEventImpl.setImageFileEntryId(imageFileEntryId);
		marketingEventImpl.setSlidesFileEntryId(slidesFileEntryId);

		if (videoTitle == null) {
			marketingEventImpl.setVideoTitle(StringPool.BLANK);
		}
		else {
			marketingEventImpl.setVideoTitle(videoTitle);
		}

		if (timeZoneId == null) {
			marketingEventImpl.setTimeZoneId(StringPool.BLANK);
		}
		else {
			marketingEventImpl.setTimeZoneId(timeZoneId);
		}

		if (startDate == Long.MIN_VALUE) {
			marketingEventImpl.setStartDate(null);
		}
		else {
			marketingEventImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			marketingEventImpl.setEndDate(null);
		}
		else {
			marketingEventImpl.setEndDate(new Date(endDate));
		}

		marketingEventImpl.setDateTBA(dateTBA);
		marketingEventImpl.setAddressId(addressId);
		marketingEventImpl.setLatitude(latitude);
		marketingEventImpl.setLongitude(longitude);
		marketingEventImpl.setGlobalRegion(globalRegion);
		marketingEventImpl.setOnline(online);
		marketingEventImpl.setRegistrationType(registrationType);

		if (registrationURL == null) {
			marketingEventImpl.setRegistrationURL(StringPool.BLANK);
		}
		else {
			marketingEventImpl.setRegistrationURL(registrationURL);
		}

		if (extraSettings == null) {
			marketingEventImpl.setExtraSettings(StringPool.BLANK);
		}
		else {
			marketingEventImpl.setExtraSettings(extraSettings);
		}

		marketingEventImpl.resetOriginalValues();

		return marketingEventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		marketingEventId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		type = objectInput.readInt();
		title = objectInput.readUTF();
		titleURL = objectInput.readUTF();
		hostedBy = objectInput.readUTF();
		hostedByURL = objectInput.readUTF();
		summary = objectInput.readUTF();

		siteGroupId = objectInput.readLong();

		imageFileEntryId = objectInput.readLong();

		slidesFileEntryId = objectInput.readLong();
		videoTitle = objectInput.readUTF();
		timeZoneId = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();

		dateTBA = objectInput.readBoolean();

		addressId = objectInput.readLong();

		latitude = objectInput.readDouble();

		longitude = objectInput.readDouble();

		globalRegion = objectInput.readInt();

		online = objectInput.readBoolean();

		registrationType = objectInput.readInt();
		registrationURL = objectInput.readUTF();
		extraSettings = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(marketingEventId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(type);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (titleURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(titleURL);
		}

		if (hostedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hostedBy);
		}

		if (hostedByURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hostedByURL);
		}

		if (summary == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(summary);
		}

		objectOutput.writeLong(siteGroupId);

		objectOutput.writeLong(imageFileEntryId);

		objectOutput.writeLong(slidesFileEntryId);

		if (videoTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(videoTitle);
		}

		if (timeZoneId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(timeZoneId);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		objectOutput.writeBoolean(dateTBA);

		objectOutput.writeLong(addressId);

		objectOutput.writeDouble(latitude);

		objectOutput.writeDouble(longitude);

		objectOutput.writeInt(globalRegion);

		objectOutput.writeBoolean(online);

		objectOutput.writeInt(registrationType);

		if (registrationURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(registrationURL);
		}

		if (extraSettings == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extraSettings);
		}
	}

	public long marketingEventId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int type;
	public String title;
	public String titleURL;
	public String hostedBy;
	public String hostedByURL;
	public String summary;
	public long siteGroupId;
	public long imageFileEntryId;
	public long slidesFileEntryId;
	public String videoTitle;
	public String timeZoneId;
	public long startDate;
	public long endDate;
	public boolean dateTBA;
	public long addressId;
	public double latitude;
	public double longitude;
	public int globalRegion;
	public boolean online;
	public int registrationType;
	public String registrationURL;
	public String extraSettings;
}