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

package com.liferay.osb.www.wcm.deployment.api;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Allen R. Ziegenfus
 */
public class Structure {

	public Structure(String groupKey, String structureKey, String content) {
		_groupKey = groupKey;
		_structureKey = structureKey;
		_content = content;

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

	private final String _content;
	private final String _groupKey;
	private final String _structureKey;
	private final List<Template> _templates;

}