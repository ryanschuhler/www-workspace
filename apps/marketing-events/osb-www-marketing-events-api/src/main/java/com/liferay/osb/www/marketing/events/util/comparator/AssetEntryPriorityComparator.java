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

package com.liferay.osb.www.marketing.events.util.comparator;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.model.ClassedModel;

import java.util.Comparator;

/**
 * @author Allen Ziegenfus
 */
public class AssetEntryPriorityComparator implements Comparator<ClassedModel> {

	public AssetEntryPriorityComparator() {
		this(true);
	}

	public AssetEntryPriorityComparator(boolean asc) {
		_ascending = asc;
	}

	@Override
	public int compare(ClassedModel classedModel1, ClassedModel classedModel2) {
		Double priority1 = getPriority(classedModel1);
		Double priority2 = getPriority(classedModel2);

		int value = priority1.compareTo(priority2);

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	protected double getPriority(ClassedModel classedModel) {
		try {
			long classPK = (Long)classedModel.getPrimaryKeyObj();

			AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
				classedModel.getModelClassName(), classPK);

			return assetEntry.getPriority();
		}
		catch (Exception e) {
			return 0;
		}
	}

	private boolean _ascending;

}