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

package com.liferay.osb.www.gtm.servlet;

import com.liferay.osb.www.gtm.configuration.GTMConfiguration;
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
	configurationPid = "com.liferay.osb.www.gtm.configuration.GTMConfiguration",
	immediate = true, service = DynamicInclude.class
)
public class GTMTopHeadDynamicInclude extends BaseDynamicInclude {

	@Override
	public void include(
			HttpServletRequest request, HttpServletResponse response,
			String key)
		throws IOException {

		PrintWriter printWriter = response.getWriter();

		StringBundler sb = new StringBundler(6);

		sb.append(
			"<noscript><iframe height='0' src='//www.googletagmanager.com/ns.html?id=GTM-");
		sb.append(_gtmConfiguration.containerId());
		sb.append(
			"' style='display:none;visibility:hidden' width='0'></iframe></noscript>");
		sb.append(
			"<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start': new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0], j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src= '//www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f); })(window,document,'script','dataLayer','GTM-");
		sb.append(_gtmConfiguration.containerId());
		sb.append("');</script>");

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
		_gtmConfiguration = ConfigurableUtil.createConfigurable(
			GTMConfiguration.class, properties);
	}

	private GTMConfiguration _gtmConfiguration;

}