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

package com.liferay.taglib.osb.util;

import com.liferay.portal.kernel.util.CharPool;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * @author Allen Ziegenfus
 */
public class JSPOutputCacheTag extends BodyTagSupport {

	@Override
	public int doEndTag() throws JspException {
		try {
			JspWriter jspWriter = pageContext.getOut();

			if (_jspOutput == null) {
				_jspOutput = getBodyContent().getString();

				JSPOutputCachePool.setJSPOutput(getCompleteKey(), _jspOutput);
			}

			jspWriter.write(_jspOutput);
		}
		catch (IOException ioe) {
			throw new JspException(ioe);
		}

		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		String key = getCompleteKey();

		_jspOutput = JSPOutputCachePool.getJSPOutput(key);

		if (_jspOutput != null) {
			return SKIP_BODY;
		}

		return EVAL_BODY_BUFFERED;
	}

	public String getCompleteKey() {
		String key;

		Object page = pageContext.getPage();

		Class<?> clazz = page.getClass();

		key = clazz.getName();

		if (_key != null) {
			Object keyObj = pageContext.getAttribute(key);

			if (keyObj != null) {
				key += CharPool.POUND + keyObj.toString();
			}
		}

		return key;
	}

	public void setKey(String key) {
		_key = key;
	}

	private String _jspOutput;
	private String _key;

}