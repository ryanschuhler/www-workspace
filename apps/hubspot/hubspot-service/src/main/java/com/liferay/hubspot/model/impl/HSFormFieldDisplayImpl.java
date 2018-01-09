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
import com.liferay.portal.kernel.util.KeyValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Allen Ziegenfus
 */
public class HSFormFieldDisplayImpl implements HSFormFieldDisplay {

	public HSFormFieldDisplayImpl(JSONObject field, HSContact hsContact) {
		//TODO: other way of doing deserialization...
		//TODO: do null checking?
		_defaultValue = field.getString("defaultValue");
		_dependentFieldFilters = field.getJSONArray("dependentFieldFilters");
		_description = field.getString("description");
		_fieldType = field.getString("fieldType");
		_hidden = GetterUtil.getBoolean(field.getString("hidden"));
		_label = field.getString("label");
		_name = field.getString("name");
		_options = new ArrayList<>();
		_required = GetterUtil.getBoolean(field.getString("required"));
		_selectedOptions = field.getJSONArray("selectedOptions");
		_smartField = GetterUtil.getBoolean(field.getString("isSmartField"));
		_unselectedLabel = field.getString("unselectedLabel");

		setOptions(field.getJSONArray("options"));
		setValue(hsContact);
	}

	@Override
	public String getDefaultValue() {
		return _defaultValue;
	}

	@Override
	public JSONArray getDependentFieldFilters() {
		return _dependentFieldFilters;
	}

	@Override
	public String getDescription() {
		return _description;
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
	public List<KeyValuePair> getOptions() {
		return _options;
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

	protected void setOptions(JSONArray options) {
		
		for (int i = 0; i < options.length(); i++) {
			JSONObject option = options.getJSONObject(i);
			
			KeyValuePair optionKVP = new KeyValuePair();
			optionKVP.setKey(option.getString("value"));
			optionKVP.setValue(option.getString("label"));
			_options.add(optionKVP);
		}
	}
	protected void setValue(HSContact hsContact) {
		_value = _defaultValue;

		if (_selectedOptions != null && _selectedOptions.length() > 0) {
			_value = _selectedOptions.getString(0);
		}

		if (!_hidden && hsContact != null) {
			JSONObject hsContactObject = hsContact.getHSContactJSONObject();

			JSONObject hsContactProperties = hsContactObject.getJSONObject(
				"properties");
			

			if (hsContactProperties.has(_name)) {
				JSONObject hsContactProperty =
					hsContactProperties.getJSONObject(_name);

				_value = hsContactProperty.getString("value");
			}
		}
	}

	private final String _defaultValue;
	private final JSONArray _dependentFieldFilters;
	private final String _description;
	private final String _fieldType;
	private final boolean _hidden;
	private final String _label;
	private final String _name;
	private final List<KeyValuePair> _options; 
	private final boolean _required;
	private final JSONArray _selectedOptions;
	private final boolean _smartField;
	private final String _unselectedLabel;
	private String _value;

}