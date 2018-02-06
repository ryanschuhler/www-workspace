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

package com.liferay.osb.www.marketing.events.admin.portlet.test;

import com.liferay.arquillian.portal.annotation.PortalURL;
import com.liferay.osb.www.marketing.events.constants.OSBWWWMarketingEventsPortletKeys;

import java.io.File;

import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Allen Ziegenfus
 */
@RunAsClient
@RunWith(Arquillian.class)
public class MarketingEventsAdminPortletTest {

	@Deployment
	public static JavaArchive create() throws Exception {
		final File jarFile = new File(System.getProperty("jarFile"));

		return ShrinkWrap.createFromZipFile(JavaArchive.class, jarFile);
	}

	@Test
	public void testAddPortlet() throws Exception {
		_webDriver.get(_portletURL.toExternalForm());

		Assert.assertTrue(_tasksPortlet.isDisplayed());

		Assert.assertTrue(
			_message.getText(),
			_message.getText().contentEquals(
				"Hello from osb-www-marketing-events-web JSP!"));
	}

	@FindBy(xpath = "//div[@class='portlet-body']/p[1]")
	private WebElement _message;

	@PortalURL(OSBWWWMarketingEventsPortletKeys.MARKETING_EVENTS_ADMIN)
	private URL _portletURL;

	@FindBy(
		xpath = "//div[contains(@id,'" + OSBWWWMarketingEventsPortletKeys.MARKETING_EVENTS_ADMIN + "')]"
	)
	private WebElement _tasksPortlet;

	@Drone
	private WebDriver _webDriver;

}