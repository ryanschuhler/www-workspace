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

package com.liferay.hubspot.model.impl;

import com.liferay.hubspot.model.HSFormFieldDisplay;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;

/**
 * @author Allen Ziegenfus
 */
public class HSFormFieldDisplayImpl implements HSFormFieldDisplay {

	public HSFormFieldDisplayImpl(JSONObject field) {
		_fieldType = field.getString("fieldType");
		_name = field.getString("name");
		_required = GetterUtil.getBoolean(field.getString("required")); 
	}
	
	@Override
	public String getFieldType() {
		return _fieldType;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public boolean isRequired() {
		return _required;
	}

	private String _fieldType;
	private String _name;
	private boolean _required;

}
