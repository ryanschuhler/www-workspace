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

import com.liferay.osb.www.marketing.events.model.SocialLink;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SocialLink in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SocialLink
 * @generated
 */
@ProviderType
public class SocialLinkCacheModel implements CacheModel<SocialLink>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SocialLinkCacheModel)) {
			return false;
		}

		SocialLinkCacheModel socialLinkCacheModel = (SocialLinkCacheModel)obj;

		if (socialLinkId == socialLinkCacheModel.socialLinkId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, socialLinkId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{socialLinkId=");
		sb.append(socialLinkId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", marketingEventUserId=");
		sb.append(marketingEventUserId);
		sb.append(", socialLinkTypeId=");
		sb.append(socialLinkTypeId);
		sb.append(", url=");
		sb.append(url);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SocialLink toEntityModel() {
		SocialLinkImpl socialLinkImpl = new SocialLinkImpl();

		socialLinkImpl.setSocialLinkId(socialLinkId);
		socialLinkImpl.setUserId(userId);

		if (userName == null) {
			socialLinkImpl.setUserName("");
		}
		else {
			socialLinkImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			socialLinkImpl.setCreateDate(null);
		}
		else {
			socialLinkImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			socialLinkImpl.setModifiedDate(null);
		}
		else {
			socialLinkImpl.setModifiedDate(new Date(modifiedDate));
		}

		socialLinkImpl.setMarketingEventUserId(marketingEventUserId);
		socialLinkImpl.setSocialLinkTypeId(socialLinkTypeId);

		if (url == null) {
			socialLinkImpl.setUrl("");
		}
		else {
			socialLinkImpl.setUrl(url);
		}

		socialLinkImpl.resetOriginalValues();

		return socialLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		socialLinkId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		marketingEventUserId = objectInput.readLong();

		socialLinkTypeId = objectInput.readLong();
		url = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(socialLinkId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(marketingEventUserId);

		objectOutput.writeLong(socialLinkTypeId);

		if (url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(url);
		}
	}

	public long socialLinkId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long marketingEventUserId;
	public long socialLinkTypeId;
	public String url;
}