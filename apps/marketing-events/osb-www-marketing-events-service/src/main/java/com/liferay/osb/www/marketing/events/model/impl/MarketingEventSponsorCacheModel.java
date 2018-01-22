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

import com.liferay.osb.www.marketing.events.model.MarketingEventSponsor;

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
 * The cache model class for representing MarketingEventSponsor in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSponsor
 * @generated
 */
@ProviderType
public class MarketingEventSponsorCacheModel implements CacheModel<MarketingEventSponsor>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarketingEventSponsorCacheModel)) {
			return false;
		}

		MarketingEventSponsorCacheModel marketingEventSponsorCacheModel = (MarketingEventSponsorCacheModel)obj;

		if (marketingEventSponsorId == marketingEventSponsorCacheModel.marketingEventSponsorId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, marketingEventSponsorId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{marketingEventSponsorId=");
		sb.append(marketingEventSponsorId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", marketingEventId=");
		sb.append(marketingEventId);
		sb.append(", marketingEventSponsorLevelId=");
		sb.append(marketingEventSponsorLevelId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", imageFileEntryId=");
		sb.append(imageFileEntryId);
		sb.append(", url=");
		sb.append(url);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MarketingEventSponsor toEntityModel() {
		MarketingEventSponsorImpl marketingEventSponsorImpl = new MarketingEventSponsorImpl();

		marketingEventSponsorImpl.setMarketingEventSponsorId(marketingEventSponsorId);
		marketingEventSponsorImpl.setUserId(userId);

		if (userName == null) {
			marketingEventSponsorImpl.setUserName(StringPool.BLANK);
		}
		else {
			marketingEventSponsorImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			marketingEventSponsorImpl.setCreateDate(null);
		}
		else {
			marketingEventSponsorImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			marketingEventSponsorImpl.setModifiedDate(null);
		}
		else {
			marketingEventSponsorImpl.setModifiedDate(new Date(modifiedDate));
		}

		marketingEventSponsorImpl.setMarketingEventId(marketingEventId);
		marketingEventSponsorImpl.setMarketingEventSponsorLevelId(marketingEventSponsorLevelId);

		if (name == null) {
			marketingEventSponsorImpl.setName(StringPool.BLANK);
		}
		else {
			marketingEventSponsorImpl.setName(name);
		}

		if (description == null) {
			marketingEventSponsorImpl.setDescription(StringPool.BLANK);
		}
		else {
			marketingEventSponsorImpl.setDescription(description);
		}

		marketingEventSponsorImpl.setImageFileEntryId(imageFileEntryId);

		if (url == null) {
			marketingEventSponsorImpl.setUrl(StringPool.BLANK);
		}
		else {
			marketingEventSponsorImpl.setUrl(url);
		}

		marketingEventSponsorImpl.resetOriginalValues();

		return marketingEventSponsorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		marketingEventSponsorId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		marketingEventId = objectInput.readLong();

		marketingEventSponsorLevelId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();

		imageFileEntryId = objectInput.readLong();
		url = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(marketingEventSponsorId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(marketingEventId);

		objectOutput.writeLong(marketingEventSponsorLevelId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(imageFileEntryId);

		if (url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(url);
		}
	}

	public long marketingEventSponsorId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long marketingEventId;
	public long marketingEventSponsorLevelId;
	public String name;
	public String description;
	public long imageFileEntryId;
	public String url;
}