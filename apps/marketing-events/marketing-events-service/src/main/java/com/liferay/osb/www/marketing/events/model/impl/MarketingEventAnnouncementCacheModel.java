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

import com.liferay.osb.www.marketing.events.model.MarketingEventAnnouncement;

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
 * The cache model class for representing MarketingEventAnnouncement in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventAnnouncement
 * @generated
 */
@ProviderType
public class MarketingEventAnnouncementCacheModel implements CacheModel<MarketingEventAnnouncement>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarketingEventAnnouncementCacheModel)) {
			return false;
		}

		MarketingEventAnnouncementCacheModel marketingEventAnnouncementCacheModel =
			(MarketingEventAnnouncementCacheModel)obj;

		if (marketingEventAnnouncementId == marketingEventAnnouncementCacheModel.marketingEventAnnouncementId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, marketingEventAnnouncementId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", marketingEventAnnouncementId=");
		sb.append(marketingEventAnnouncementId);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", message=");
		sb.append(message);
		sb.append(", summary=");
		sb.append(summary);
		sb.append(", imageFileEntryId=");
		sb.append(imageFileEntryId);
		sb.append(", linkURL=");
		sb.append(linkURL);
		sb.append(", linkLabel=");
		sb.append(linkLabel);
		sb.append(", displayDate=");
		sb.append(displayDate);
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
	public MarketingEventAnnouncement toEntityModel() {
		MarketingEventAnnouncementImpl marketingEventAnnouncementImpl = new MarketingEventAnnouncementImpl();

		if (uuid == null) {
			marketingEventAnnouncementImpl.setUuid(StringPool.BLANK);
		}
		else {
			marketingEventAnnouncementImpl.setUuid(uuid);
		}

		marketingEventAnnouncementImpl.setMarketingEventAnnouncementId(marketingEventAnnouncementId);
		marketingEventAnnouncementImpl.setUserId(userId);

		if (userName == null) {
			marketingEventAnnouncementImpl.setUserName(StringPool.BLANK);
		}
		else {
			marketingEventAnnouncementImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			marketingEventAnnouncementImpl.setCreateDate(null);
		}
		else {
			marketingEventAnnouncementImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			marketingEventAnnouncementImpl.setModifiedDate(null);
		}
		else {
			marketingEventAnnouncementImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		marketingEventAnnouncementImpl.setMarketingEventId(marketingEventId);

		if (title == null) {
			marketingEventAnnouncementImpl.setTitle(StringPool.BLANK);
		}
		else {
			marketingEventAnnouncementImpl.setTitle(title);
		}

		if (message == null) {
			marketingEventAnnouncementImpl.setMessage(StringPool.BLANK);
		}
		else {
			marketingEventAnnouncementImpl.setMessage(message);
		}

		if (summary == null) {
			marketingEventAnnouncementImpl.setSummary(StringPool.BLANK);
		}
		else {
			marketingEventAnnouncementImpl.setSummary(summary);
		}

		marketingEventAnnouncementImpl.setImageFileEntryId(imageFileEntryId);

		if (linkURL == null) {
			marketingEventAnnouncementImpl.setLinkURL(StringPool.BLANK);
		}
		else {
			marketingEventAnnouncementImpl.setLinkURL(linkURL);
		}

		if (linkLabel == null) {
			marketingEventAnnouncementImpl.setLinkLabel(StringPool.BLANK);
		}
		else {
			marketingEventAnnouncementImpl.setLinkLabel(linkLabel);
		}

		if (displayDate == Long.MIN_VALUE) {
			marketingEventAnnouncementImpl.setDisplayDate(null);
		}
		else {
			marketingEventAnnouncementImpl.setDisplayDate(new Date(displayDate));
		}

		marketingEventAnnouncementImpl.setStatus(status);
		marketingEventAnnouncementImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			marketingEventAnnouncementImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			marketingEventAnnouncementImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			marketingEventAnnouncementImpl.setStatusDate(null);
		}
		else {
			marketingEventAnnouncementImpl.setStatusDate(new Date(statusDate));
		}

		marketingEventAnnouncementImpl.resetOriginalValues();

		return marketingEventAnnouncementImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		marketingEventAnnouncementId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		marketingEventId = objectInput.readLong();
		title = objectInput.readUTF();
		message = objectInput.readUTF();
		summary = objectInput.readUTF();

		imageFileEntryId = objectInput.readLong();
		linkURL = objectInput.readUTF();
		linkLabel = objectInput.readUTF();
		displayDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(marketingEventAnnouncementId);

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

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (message == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(message);
		}

		if (summary == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(summary);
		}

		objectOutput.writeLong(imageFileEntryId);

		if (linkURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(linkURL);
		}

		if (linkLabel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(linkLabel);
		}

		objectOutput.writeLong(displayDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long marketingEventAnnouncementId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long marketingEventId;
	public String title;
	public String message;
	public String summary;
	public long imageFileEntryId;
	public String linkURL;
	public String linkLabel;
	public long displayDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
}