/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liferay.osb.www.gdpr;

import com.liferay.ip.geocoder.IPInfo;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.util.CookieKeys;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Ryan Schuhler
 */
@Component(
	immediate = true, property = {"key=servlet.service.events.pre"},
	service = LifecycleAction.class
)
public class ServicePreAction implements LifecycleAction {

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent)
		throws ActionException {

		System.out.println("GDPR Pre Action");

		String country = getCountry(lifecycleEvent.getRequest());

		lifecycleEvent.getRequest().setAttribute("OSB_WWW_COUNTRY", country);

		lifecycleEvent.getRequest().setAttribute(
			"OSB_WWW_GDPR_COUNTRY", isGDPRCountry(country));
		
		lifecycleEvent.getRequest().setAttribute(
			"OSB_WWW_GDPR_ACCEPTED", 
			Validator.isNotNull(CookieKeys.getCookie(lifecycleEvent.getRequest(), "OSB_WWW_GDPR_ACCEPTED")));
		
	}

	protected String getCountry(HttpServletRequest request) {

		IPInfo ipInfo = (IPInfo)request.getAttribute(IPInfo.class.getName());
		if ((ipInfo != null) && Validator.isNotNull(ipInfo.getCountryCode())) {
			return ipInfo.getCountryCode();
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		Locale locale = themeDisplay.getLocale();

		return locale.getCountry();
	}

	protected boolean isGDPRCountry(String country) {
		return ArrayUtil.contains(_OSB_WWW_GDPR_COUNTRIES, country);
	}

	private static final String[] _OSB_WWW_GDPR_COUNTRIES =
		{"US", "DE"};

}