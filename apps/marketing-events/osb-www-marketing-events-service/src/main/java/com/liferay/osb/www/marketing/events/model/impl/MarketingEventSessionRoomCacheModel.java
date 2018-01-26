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

import com.liferay.osb.www.marketing.events.model.MarketingEventSessionRoom;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MarketingEventSessionRoom in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see MarketingEventSessionRoom
 * @generated
 */
@ProviderType
public class MarketingEventSessionRoomCacheModel implements CacheModel<MarketingEventSessionRoom>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarketingEventSessionRoomCacheModel)) {
			return false;
		}

		MarketingEventSessionRoomCacheModel marketingEventSessionRoomCacheModel = (MarketingEventSessionRoomCacheModel)obj;

		if (marketingEventSessionRoomId == marketingEventSessionRoomCacheModel.marketingEventSessionRoomId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, marketingEventSessionRoomId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{marketingEventSessionRoomId=");
		sb.append(marketingEventSessionRoomId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", marketingEventId=");
		sb.append(marketingEventId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", imageFileEntryId=");
		sb.append(imageFileEntryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MarketingEventSessionRoom toEntityModel() {
		MarketingEventSessionRoomImpl marketingEventSessionRoomImpl = new MarketingEventSessionRoomImpl();

		marketingEventSessionRoomImpl.setMarketingEventSessionRoomId(marketingEventSessionRoomId);

		if (createDate == Long.MIN_VALUE) {
			marketingEventSessionRoomImpl.setCreateDate(null);
		}
		else {
			marketingEventSessionRoomImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			marketingEventSessionRoomImpl.setModifiedDate(null);
		}
		else {
			marketingEventSessionRoomImpl.setModifiedDate(new Date(modifiedDate));
		}

		marketingEventSessionRoomImpl.setMarketingEventId(marketingEventId);

		if (name == null) {
			marketingEventSessionRoomImpl.setName("");
		}
		else {
			marketingEventSessionRoomImpl.setName(name);
		}

		marketingEventSessionRoomImpl.setImageFileEntryId(imageFileEntryId);

		marketingEventSessionRoomImpl.resetOriginalValues();

		return marketingEventSessionRoomImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		marketingEventSessionRoomId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		marketingEventId = objectInput.readLong();
		name = objectInput.readUTF();

		imageFileEntryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(marketingEventSessionRoomId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(marketingEventId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(imageFileEntryId);
	}

	public long marketingEventSessionRoomId;
	public long createDate;
	public long modifiedDate;
	public long marketingEventId;
	public String name;
	public long imageFileEntryId;
}