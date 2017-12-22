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

import com.liferay.hubspot.model.HSForm;
import com.liferay.hubspot.model.HSFormDisplay;
import com.liferay.hubspot.model.HSFormFieldDisplay;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Allen Ziegenfus
 */
public class HSFormDisplayImpl implements HSFormDisplay {

	public HSFormDisplayImpl() {
		_formFieldDisplays = new ArrayList<>();
	}
	
	public HSFormDisplayImpl(HSForm hsForm) {
		_hsForm = hsForm;
				
		_formFieldDisplays = new ArrayList<>();

		if (hsForm != null) {
			JSONObject jsonObject = hsForm.getHSFormJSONObject();
	
			JSONArray fields = jsonObject.getJSONArray("fields"); 
	
			for (int i = 0; i < fields.length(); i++) {
				JSONObject field = fields.getJSONObject(i);
				
				HSFormFieldDisplay hsFormFieldDisplay = new HSFormFieldDisplayImpl(field);
				
				_formFieldDisplays.add(hsFormFieldDisplay);
			}
		}
		
	}
	
	@Override
	public List<HSFormFieldDisplay> getFormFieldDisplays() {
		return _formFieldDisplays;
	}

	private List<HSFormFieldDisplay> _formFieldDisplays;
	private HSForm _hsForm;
	
}
