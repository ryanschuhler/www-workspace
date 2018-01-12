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

package com.liferay.osb.www.laguage.cookie;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

import javax.servlet.http.Cookie;

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

		System.out.println("Language Cookie Pre Action");

//		String languageStrutsAction = "/language/view";
//		String strutsAction = PortalUtil.getStrutsAction(request);
//
//		if (StringUtil.equalsIgnoreCase(languageStrutsAction, strutsAction)) {
//			return;
//		}

		ThemeDisplay themeDisplay =
			(ThemeDisplay)lifecycleEvent.getRequest().getAttribute(
				WebKeys.THEME_DISPLAY);

		String osbLanguageId = CookieKeys.getCookie(
			lifecycleEvent.getRequest(), "OSB_LANGUAGE_ID");

		if (Validator.isNull(osbLanguageId)) {
			osbLanguageId = themeDisplay.getLanguageId();
		}

		if (!LanguageUtil.isAvailableLocale(osbLanguageId)) {
			return;
		}

		String guestLanguageId = CookieKeys.getCookie(
			lifecycleEvent.getRequest(), CookieKeys.GUEST_LANGUAGE_ID);

		if (!StringUtil.equalsIgnoreCase(
				guestLanguageId, themeDisplay.getLanguageId())) {

			Cookie cookie = new Cookie(
				"OSB_LANGUAGE_ID", themeDisplay.getLanguageId());

			cookie.setMaxAge((int)(Time.WEEK / 1000));
			cookie.setPath(StringPool.SLASH);

			CookieKeys.addCookie(
				lifecycleEvent.getRequest(), lifecycleEvent.getResponse(),
				cookie);

			return;
		}

		if (StringUtil.equalsIgnoreCase(
				osbLanguageId, themeDisplay.getLanguageId())) {

			return;
		}

//		String loginPortletId = PortletProviderUtil.getPortletId(
//			com.liferay.login.web.internal.portlet.LoginPortlet.class.getName(),
//			PortletProvider.Action.VIEW);
//
//		PortletURL portletURL = PortletURLFactoryUtil.create(
//			lifecycleEvent.getRequest(), loginPortletId, themeDisplay.getPlid(),
//			PortletRequest.ACTION_PHASE);
//
//		portletURL.setParameter("redirect", themeDisplay.getURLCurrent());
//		portletURL.setParameter("languageId", osbLanguageId);
//		portletURL.setWindowState(WindowState.NORMAL);
//		portletURL.setPortletMode(PortletMode.VIEW);
//
//		lifecycleEvent.getResponse().sendRedirect(portletURL.toString());
	}

}