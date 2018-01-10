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

package com.liferay.osb.www.liferay.analytics.servlet;

import com.liferay.osb.www.liferay.analytics.configuration.LiferayAnalyticsConfiguration;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.servlet.taglib.BaseDynamicInclude;
import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Ryan Schuhler
 */
@Component(
	configurationPid = "com.liferay.osb.www.liferay.analytics.configuration.LiferayAnalyticsConfiguration",
	immediate = true, service = DynamicInclude.class
)
public class LiferayAnalyticsTopHeadDynamicInclude extends BaseDynamicInclude {

	@Override
	public void include(
			HttpServletRequest request, HttpServletResponse response,
			String key)
		throws IOException {

		PrintWriter printWriter = response.getWriter();

		StringBundler sb = new StringBundler(3);

		sb.append(
			"<script>(function(u, c, a, m, o,l){o='script',l=document,a=l.createElement(o),m=l.getElementsByTagName(o)[0],a.async=1,a.src=u,a.onload=c,m.parentNode.insertBefore(a,m)})('https://s3-eu-west-1.amazonaws.com/com-liferay-analytics/analytics-all-min.js', function() {Analytics.create({ analyticsKey: '");
		sb.append(_liferayAnalyticsConfiguration.analyticsKey());
		sb.append("' });Analytics.send('view', 'Layout');}</script>");

		printWriter.println(sb.toString());
	}

	@Override
	public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
		dynamicIncludeRegistry.register(
			"/html/common/themes/top_head.jsp#post");
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_liferayAnalyticsConfiguration = ConfigurableUtil.createConfigurable(
			LiferayAnalyticsConfiguration.class, properties);
	}

	private LiferayAnalyticsConfiguration _liferayAnalyticsConfiguration;

}