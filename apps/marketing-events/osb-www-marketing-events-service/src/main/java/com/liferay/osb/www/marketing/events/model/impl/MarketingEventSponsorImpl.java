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

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.StringPool;

/**
 * @author Ryan Schuhler
 * @author Allen Ziegenfus
 */
public class MarketingEventSponsorImpl extends MarketingEventSponsorBaseImpl {

	public MarketingEventSponsorImpl() {
	}

	public FileEntry getImageFileEntry() {
		if (getImageFileEntryId() <= 0) {
			return null;
		}

		try {
			if (_imageFileEntry == null) {
				_imageFileEntry = DLAppLocalServiceUtil.getFileEntry(
					getImageFileEntryId());
			}

			return _imageFileEntry;
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to get image for " + getImageFileEntryId(), e);
			}

			return null;
		}
	}

	@JSON
	public String getImageFileEntryURL() {
		FileEntry fileEntry = getImageFileEntry();

		if (fileEntry == null) {
			return StringPool.BLANK;
		}

		try {
			return DLUtil.getPreviewURL(
				fileEntry, fileEntry.getFileVersion(), null, StringPool.BLANK,
				false, true);
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to get file version for " +
						getImageFileEntryId(),
					e);
			}

			return StringPool.BLANK;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		MarketingEventSponsorImpl.class);

	private FileEntry _imageFileEntry;

}