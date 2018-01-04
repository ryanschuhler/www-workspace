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

package com.liferay.osb.www.wcm.deployment;

import java.util.ArrayList;
import java.util.List;

public class Structure {

	public Structure(String groupKey, String structureKey, String content) {
		_content = content;
		_groupKey = groupKey;
		_structureKey = structureKey;
		_templates = new ArrayList<>();
	}

	public void addTemplate(Template template) {
		_templates.add(template);
	}

	public String getContent() {
		return _content;
	}

	public String getGroupKey() {
		return _groupKey;
	}

	public String getStructureKey() {
		return _structureKey;
	}

	public List<Template> getTemplates() {
		return _templates;
	}

	private String _content;
	private String _groupKey;
	private String _structureKey;
	private List<Template> _templates;

}