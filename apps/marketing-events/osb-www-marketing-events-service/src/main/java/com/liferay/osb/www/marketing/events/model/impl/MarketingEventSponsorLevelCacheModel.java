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

import com.liferay.osb.www.marketing.events.model.MarketingEventSponsorLevel;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MarketingEventSponsorLevel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSponsorLevel
 * @generated
 */
@ProviderType
public class MarketingEventSponsorLevelCacheModel implements CacheModel<MarketingEventSponsorLevel>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarketingEventSponsorLevelCacheModel)) {
			return false;
		}

		MarketingEventSponsorLevelCacheModel marketingEventSponsorLevelCacheModel =
			(MarketingEventSponsorLevelCacheModel)obj;

		if (marketingEventSponsorLevelId == marketingEventSponsorLevelCacheModel.marketingEventSponsorLevelId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, marketingEventSponsorLevelId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{marketingEventSponsorLevelId=");
		sb.append(marketingEventSponsorLevelId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", priority=");
		sb.append(priority);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MarketingEventSponsorLevel toEntityModel() {
		MarketingEventSponsorLevelImpl marketingEventSponsorLevelImpl = new MarketingEventSponsorLevelImpl();

		marketingEventSponsorLevelImpl.setMarketingEventSponsorLevelId(marketingEventSponsorLevelId);
		marketingEventSponsorLevelImpl.setUserId(userId);

		if (userName == null) {
			marketingEventSponsorLevelImpl.setUserName("");
		}
		else {
			marketingEventSponsorLevelImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			marketingEventSponsorLevelImpl.setCreateDate(null);
		}
		else {
			marketingEventSponsorLevelImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			marketingEventSponsorLevelImpl.setModifiedDate(null);
		}
		else {
			marketingEventSponsorLevelImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		marketingEventSponsorLevelImpl.setMarketingEventId(marketingEventId);

		if (name == null) {
			marketingEventSponsorLevelImpl.setName("");
		}
		else {
			marketingEventSponsorLevelImpl.setName(name);
		}

		marketingEventSponsorLevelImpl.setPriority(priority);

		marketingEventSponsorLevelImpl.resetOriginalValues();

		return marketingEventSponsorLevelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		marketingEventSponsorLevelId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		marketingEventId = objectInput.readLong();
		name = objectInput.readUTF();

		priority = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(marketingEventSponsorLevelId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(priority);
	}

	public long marketingEventSponsorLevelId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long marketingEventId;
	public String name;
	public int priority;
}