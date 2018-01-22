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

import com.liferay.osb.www.marketing.events.model.MarketingEventUser;

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
 * The cache model class for representing MarketingEventUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventUser
 * @generated
 */
@ProviderType
public class MarketingEventUserCacheModel implements CacheModel<MarketingEventUser>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarketingEventUserCacheModel)) {
			return false;
		}

		MarketingEventUserCacheModel marketingEventUserCacheModel = (MarketingEventUserCacheModel)obj;

		if (marketingEventUserId == marketingEventUserCacheModel.marketingEventUserId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, marketingEventUserId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", marketingEventUserId=");
		sb.append(marketingEventUserId);
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
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", companyName=");
		sb.append(companyName);
		sb.append(", companyLogoFileEntryId=");
		sb.append(companyLogoFileEntryId);
		sb.append(", jobTitle=");
		sb.append(jobTitle);
		sb.append(", description=");
		sb.append(description);
		sb.append(", imageFileEntryId=");
		sb.append(imageFileEntryId);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
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
	public MarketingEventUser toEntityModel() {
		MarketingEventUserImpl marketingEventUserImpl = new MarketingEventUserImpl();

		if (uuid == null) {
			marketingEventUserImpl.setUuid(StringPool.BLANK);
		}
		else {
			marketingEventUserImpl.setUuid(uuid);
		}

		marketingEventUserImpl.setMarketingEventUserId(marketingEventUserId);
		marketingEventUserImpl.setCompanyId(companyId);
		marketingEventUserImpl.setUserId(userId);

		if (userName == null) {
			marketingEventUserImpl.setUserName(StringPool.BLANK);
		}
		else {
			marketingEventUserImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			marketingEventUserImpl.setCreateDate(null);
		}
		else {
			marketingEventUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			marketingEventUserImpl.setModifiedDate(null);
		}
		else {
			marketingEventUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		marketingEventUserImpl.setMarketingEventId(marketingEventId);

		if (firstName == null) {
			marketingEventUserImpl.setFirstName(StringPool.BLANK);
		}
		else {
			marketingEventUserImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			marketingEventUserImpl.setLastName(StringPool.BLANK);
		}
		else {
			marketingEventUserImpl.setLastName(lastName);
		}

		if (companyName == null) {
			marketingEventUserImpl.setCompanyName(StringPool.BLANK);
		}
		else {
			marketingEventUserImpl.setCompanyName(companyName);
		}

		marketingEventUserImpl.setCompanyLogoFileEntryId(companyLogoFileEntryId);

		if (jobTitle == null) {
			marketingEventUserImpl.setJobTitle(StringPool.BLANK);
		}
		else {
			marketingEventUserImpl.setJobTitle(jobTitle);
		}

		if (description == null) {
			marketingEventUserImpl.setDescription(StringPool.BLANK);
		}
		else {
			marketingEventUserImpl.setDescription(description);
		}

		marketingEventUserImpl.setImageFileEntryId(imageFileEntryId);

		if (phoneNumber == null) {
			marketingEventUserImpl.setPhoneNumber(StringPool.BLANK);
		}
		else {
			marketingEventUserImpl.setPhoneNumber(phoneNumber);
		}

		marketingEventUserImpl.setStatus(status);
		marketingEventUserImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			marketingEventUserImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			marketingEventUserImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			marketingEventUserImpl.setStatusDate(null);
		}
		else {
			marketingEventUserImpl.setStatusDate(new Date(statusDate));
		}

		marketingEventUserImpl.resetOriginalValues();

		return marketingEventUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		marketingEventUserId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		marketingEventId = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		companyName = objectInput.readUTF();

		companyLogoFileEntryId = objectInput.readLong();
		jobTitle = objectInput.readUTF();
		description = objectInput.readUTF();

		imageFileEntryId = objectInput.readLong();
		phoneNumber = objectInput.readUTF();

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

		objectOutput.writeLong(marketingEventUserId);

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

		objectOutput.writeLong(marketingEventId);

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (companyName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companyName);
		}

		objectOutput.writeLong(companyLogoFileEntryId);

		if (jobTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobTitle);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(imageFileEntryId);

		if (phoneNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phoneNumber);
		}

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
	public long marketingEventUserId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long marketingEventId;
	public String firstName;
	public String lastName;
	public String companyName;
	public long companyLogoFileEntryId;
	public String jobTitle;
	public String description;
	public long imageFileEntryId;
	public String phoneNumber;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
}