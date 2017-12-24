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

import com.liferay.hubspot.model.HSContact;
import com.liferay.hubspot.model.HSFormFieldDisplay;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;

/**
 * @author Allen Ziegenfus
 */
public class HSFormFieldDisplayImpl implements HSFormFieldDisplay {
	
	public HSFormFieldDisplayImpl(JSONObject field, HSContact hsContact) {
		_defaultValue = field.getString("defaultValue");
		_dependentFieldFilters = field.getJSONArray("dependentFieldFilters");
		_description = field.getString("description");
		_fieldType = field.getString("fieldType");
		_hidden = GetterUtil.getBoolean(field.getString("hidden"));
		_label = field.getString("label"); 
		_name = field.getString("name");
		_required = GetterUtil.getBoolean(field.getString("required"));
		_selectedOptions = field.getJSONArray("selectedOptions");
		_smartField = GetterUtil.getBoolean(field.getString("isSmartField"));
		_unselectedLabel = field.getString("unselectedLabel");
		
		setValue(hsContact);
	}
	
	@Override
	public String getDefaultValue() {
		return _defaultValue;
	}
	
	@Override
	public String getDescription() {
		return _description;
	}
	
	@Override
	public JSONArray getDependentFieldFilters() {
		return _dependentFieldFilters;
	}
	
	@Override
	public String getFieldType() {
		return _fieldType;
	}

	@Override 
	public String getLabel() {
		return _label;
	}
	
	@Override
	public String getName() {
		return _name;
	}

	@Override
	public boolean isHidden() {
		return _hidden;
	}
	
	@Override
	public boolean isRequired() {
		return _required;
	}

	@Override
	public boolean isSmartField() {
		return _smartField;
	}
	
	@Override
	public JSONArray getSelectedOptions() {
		return _selectedOptions;
	}
	
	@Override
	public String getUnselectedLabel() {
		return _unselectedLabel;
	}
	
	@Override
	public String getValue() {
		return _value;
	}
	
	protected void setValue(HSContact hsContact) {
		_value = _defaultValue;
		
		if (_selectedOptions != null && _selectedOptions.length() > 0) {
			_value = _selectedOptions.getString(0);
		}
		
		if (!_hidden && hsContact != null) {
			JSONObject hsContactObject = hsContact.getHSContactJSONObject();
			JSONObject hsContactProperties = hsContactObject.getJSONObject("properties");
			
			if (hsContactProperties.has(_name)) {
				JSONObject hsContactProperty = hsContactProperties.getJSONObject(_name);
				_value = hsContactProperty.getString("value");	
			}
		}
	}
	
	private String _defaultValue;
	private JSONArray _dependentFieldFilters;
	private String _description;
	private String _fieldType;
	private boolean _hidden;
	private boolean _smartField;
	private String _name;
	private String _label;
	private boolean _required;
	private JSONArray _selectedOptions;
	private String _unselectedLabel;
	private String _value;
	
}
