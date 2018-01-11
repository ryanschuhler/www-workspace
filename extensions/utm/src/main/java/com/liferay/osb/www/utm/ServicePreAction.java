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

package com.liferay.osb.www.utm;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.util.Validator;

import javax.servlet.http.Cookie;

import org.osgi.service.component.annotations.Component;

/**
 * @author Ryan Schuhler
 */
@Component(
	immediate = true,
	property = {"key=" + PropsKeys.SERVLET_SERVICE_EVENTS_POST},
	service = LifecycleAction.class
)
public class ServicePreAction implements LifecycleAction {

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent)
		throws ActionException {

		System.out.println("UTM Pre Action");

		String[] osbUTMValueArray = StringUtil.split(
			CookieKeys.getCookie(lifecycleEvent.getRequest(), "OSB_UTM"),
			StringPool.PIPE);

		StringBundler sb = new StringBundler(_UTM_PARAM_NAMES.length * 2);

		for (int i = 0; i < _UTM_PARAM_NAMES.length; i++) {
			String utmValue = ParamUtil.getString(
				lifecycleEvent.getRequest(), _UTM_PARAM_NAMES[i],
				(String)ArrayUtil.getValue(osbUTMValueArray, i));

			if (Validator.isNotNull(utmValue)) {
				sb.append(utmValue);

				lifecycleEvent.getRequest().setAttribute(_UTM_PARAM_NAMES[i], utmValue);
			}

			sb.append(StringPool.PIPE);
		}

		String cookieValue = sb.toString();

		if (cookieValue.length() > _UTM_PARAM_NAMES.length) {
			Cookie cookie = new Cookie("OSB_UTM", cookieValue);

			cookie.setMaxAge((int)(Time.WEEK / 1000));
			cookie.setPath(StringPool.SLASH);

			CookieKeys.addCookie(
				lifecycleEvent.getRequest(), lifecycleEvent.getResponse(),
				cookie);
		}
	}

	private static final String[] _UTM_PARAM_NAMES =
		{"utm_campaign", "utm_content", "utm_medium", "utm_source", "utm_term"};

}