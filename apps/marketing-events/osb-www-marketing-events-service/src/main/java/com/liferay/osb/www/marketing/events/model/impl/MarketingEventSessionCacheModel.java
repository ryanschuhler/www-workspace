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

import com.liferay.osb.www.marketing.events.model.MarketingEventSession;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MarketingEventSession in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSession
 * @generated
 */
@ProviderType
public class MarketingEventSessionCacheModel implements CacheModel<MarketingEventSession>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarketingEventSessionCacheModel)) {
			return false;
		}

		MarketingEventSessionCacheModel marketingEventSessionCacheModel = (MarketingEventSessionCacheModel)obj;

		if (marketingEventSessionId == marketingEventSessionCacheModel.marketingEventSessionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, marketingEventSessionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", marketingEventSessionId=");
		sb.append(marketingEventSessionId);
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
		sb.append(", marketingEventId=");
		sb.append(marketingEventId);
		sb.append(", marketingEventSessionRoomId=");
		sb.append(marketingEventSessionRoomId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", keywords=");
		sb.append(keywords);
		sb.append(", slidesFileEntryId=");
		sb.append(slidesFileEntryId);
		sb.append(", videoURL=");
		sb.append(videoURL);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MarketingEventSession toEntityModel() {
		MarketingEventSessionImpl marketingEventSessionImpl = new MarketingEventSessionImpl();

		if (uuid == null) {
			marketingEventSessionImpl.setUuid("");
		}
		else {
			marketingEventSessionImpl.setUuid(uuid);
		}

		marketingEventSessionImpl.setMarketingEventSessionId(marketingEventSessionId);
		marketingEventSessionImpl.setCompanyId(companyId);
		marketingEventSessionImpl.setUserId(userId);

		if (userName == null) {
			marketingEventSessionImpl.setUserName("");
		}
		else {
			marketingEventSessionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			marketingEventSessionImpl.setCreateDate(null);
		}
		else {
			marketingEventSessionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			marketingEventSessionImpl.setModifiedDate(null);
		}
		else {
			marketingEventSessionImpl.setModifiedDate(new Date(modifiedDate));
		}

		marketingEventSessionImpl.setMarketingEventId(marketingEventId);
		marketingEventSessionImpl.setMarketingEventSessionRoomId(marketingEventSessionRoomId);

		if (title == null) {
			marketingEventSessionImpl.setTitle("");
		}
		else {
			marketingEventSessionImpl.setTitle(title);
		}

		if (description == null) {
			marketingEventSessionImpl.setDescription("");
		}
		else {
			marketingEventSessionImpl.setDescription(description);
		}

		if (keywords == null) {
			marketingEventSessionImpl.setKeywords("");
		}
		else {
			marketingEventSessionImpl.setKeywords(keywords);
		}

		marketingEventSessionImpl.setSlidesFileEntryId(slidesFileEntryId);

		if (videoURL == null) {
			marketingEventSessionImpl.setVideoURL("");
		}
		else {
			marketingEventSessionImpl.setVideoURL(videoURL);
		}

		if (startDate == Long.MIN_VALUE) {
			marketingEventSessionImpl.setStartDate(null);
		}
		else {
			marketingEventSessionImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			marketingEventSessionImpl.setEndDate(null);
		}
		else {
			marketingEventSessionImpl.setEndDate(new Date(endDate));
		}

		marketingEventSessionImpl.setStatus(status);
		marketingEventSessionImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			marketingEventSessionImpl.setStatusByUserName("");
		}
		else {
			marketingEventSessionImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			marketingEventSessionImpl.setStatusDate(null);
		}
		else {
			marketingEventSessionImpl.setStatusDate(new Date(statusDate));
		}

		marketingEventSessionImpl.resetOriginalValues();

		return marketingEventSessionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		marketingEventSessionId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		marketingEventId = objectInput.readLong();

		marketingEventSessionRoomId = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		keywords = objectInput.readUTF();

		slidesFileEntryId = objectInput.readLong();
		videoURL = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(marketingEventSessionId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(marketingEventId);

		objectOutput.writeLong(marketingEventSessionRoomId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (keywords == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(keywords);
		}

		objectOutput.writeLong(slidesFileEntryId);

		if (videoURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(videoURL);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long marketingEventSessionId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long marketingEventId;
	public long marketingEventSessionRoomId;
	public String title;
	public String description;
	public String keywords;
	public long slidesFileEntryId;
	public String videoURL;
	public long startDate;
	public long endDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
}