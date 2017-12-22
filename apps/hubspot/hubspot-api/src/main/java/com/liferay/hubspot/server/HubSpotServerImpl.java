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

package com.liferay.hubspot.server;

import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.hubspot.exception.HubSpotServerException;
import com.liferay.hubspot.util.PortletPropsValues;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.Http.Body;
import com.liferay.portal.kernel.util.Http.Method;
import com.liferay.portal.kernel.util.StringPool;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

/**
 * @author Peter Shin
 * @author Weston Hancock
 */
public class HubSpotServerImpl implements HubSpotServer {

	public void afterPropertiesSet() {
		startup();
	}

	public void destroy() {
		shutdown();
	}

	@Override
	public Message executeDelete(String uri, Map<String, String> headers)
		throws HubSpotServerException {

		return executeDelete(uri, headers, null);
	}

	@Override
	public Message executeDelete(
			String uri, Map<String, String> headers,
			Map<String, String> parameters)
		throws HubSpotServerException {

		HttpMethod httpMethod = getHttpMethod(
			uri, Method.DELETE, headers, null, parameters);

		return execute(httpMethod);
	}

	@Override
	public Message executeGet(String uri, Map<String, String> headers)
		throws HubSpotServerException {

		return executeGet(uri, headers, null);
	}

	@Override
	public Message executeGet(
			String uri, Map<String, String> headers,
			Map<String, String> parameters)
		throws HubSpotServerException {

		HttpMethod httpMethod = getHttpMethod(
			uri, Method.GET, headers, null, parameters);

		return execute(httpMethod);
	}

	@Override
	public Message executePost(
			String uri, Map<String, String> headers, Body body)
		throws HubSpotServerException {

		return executePost(uri, headers, body, null);
	}

	@Override
	public Message executePost(
			String uri, Map<String, String> headers, Body body,
			Map<String, String> parameters)
		throws HubSpotServerException {

		HttpMethod httpMethod = getHttpMethod(
			uri, Method.POST, headers, body, parameters);

		return execute(httpMethod);
	}

	@Override
	public void shutdown() {
		HttpConnectionManager httpConnectionManager =
			_httpClient.getHttpConnectionManager();

		MultiThreadedHttpConnectionManager multiThreadedHttpConnectionManager =
			(MultiThreadedHttpConnectionManager)httpConnectionManager;

		while (true) {
			int connections =
				multiThreadedHttpConnectionManager.getConnectionsInPool();

			if (connections == 0) {
				break;
			}

			if (_log.isDebugEnabled()) {
				_log.debug("Waiting on " + connections + " connections");
			}

			multiThreadedHttpConnectionManager.closeIdleConnections(200);

			try {
				Thread.sleep(200);
			}
			catch (InterruptedException ie) {
			}
		}

		multiThreadedHttpConnectionManager.shutdown();

		MultiThreadedHttpConnectionManager.shutdownAll();

		if (_log.isDebugEnabled()) {
			_log.debug("Shutdown HttpConnectionManager");
		}
	}

	@Override
	public void startup() {
		MultiThreadedHttpConnectionManager httpConnectionManager =
			new MultiThreadedHttpConnectionManager();

		HttpConnectionManagerParams httpConnectionManagerParams =
			httpConnectionManager.getParams();

		httpConnectionManagerParams.setConnectionTimeout(
			PortletPropsValues.HTTP_CLIENT_TIMEOUT);
		httpConnectionManagerParams.setDefaultMaxConnectionsPerHost(
			PortletPropsValues.HTTP_CLIENT_MAX_CONNECTIONS_PER_HOST);
		httpConnectionManagerParams.setMaxTotalConnections(
			PortletPropsValues.HTTP_CLIENT_MAX_TOTAL_CONNECTIONS);
		httpConnectionManagerParams.setSoTimeout(
			PortletPropsValues.HTTP_CLIENT_TIMEOUT);

		_httpClient.setHttpConnectionManager(httpConnectionManager);
	}

	protected HttpMethod addRequestHeaders(
		Map<String, String> headers, HttpMethod httpMethod) {

		if (headers == null) {
			return httpMethod;
		}

		for (Map.Entry<String, String> header : headers.entrySet()) {
			httpMethod.addRequestHeader(header.getKey(), header.getValue());
		}

		return httpMethod;
	}

	protected Message execute(HttpMethod httpMethod)
		throws HubSpotServerException {

		try {
			URI uri = httpMethod.getURI();

			if (_log.isDebugEnabled() && !isSkipURI(uri.getURI())) {
				_log.debug("Execute " + uri.getURI());
			}

			int statusCode = _httpClient.executeMethod(httpMethod);

			if (_log.isDebugEnabled() && !isSkipURI(uri.getURI())) {
				String statusText = HttpStatus.getStatusText(statusCode);

				_log.debug("Status " + statusText + " (" + statusCode + ")");
			}

			String response = StringPool.BLANK;

			if (statusCode != HttpStatus.SC_NO_CONTENT) {
				response = new String(
					FileUtil.getBytes(httpMethod.getResponseBodyAsStream()));
			}

			Message message = new Message();

			message.put("response", response);
			message.put("statusCode", statusCode);
			message.put("uri", uri.getURI());

			return message;
		}
		catch (URIException urie) {
			throw new HubSpotServerException(urie.getMessage(), urie);
		}
		catch (HttpException he) {
			throw new HubSpotServerException(he.getMessage(), he);
		}
		catch (IOException ioe) {
			throw new HubSpotServerException(ioe.getMessage(), ioe);
		}
		finally {
			httpMethod.releaseConnection();
		}
	}

	protected HttpMethod getHttpMethod(
			String uri, Method method, Map<String, String> headers, Body body,
			Map<String, String> parameters)
		throws HubSpotServerException {

		HttpMethod httpMethod = null;

		if (method.equals(Method.POST)) {
			PostMethod postMethod = new PostMethod(uri);

			if (MapUtil.isNotEmpty(parameters)) {
				for (Map.Entry<String, String> entry : parameters.entrySet()) {
					String paramName = entry.getKey();
					String paramValue = entry.getValue();

					if (paramValue != null) {
						postMethod.addParameter(paramName, paramValue);
					}
				}
			}

			RequestEntity requestEntity = null;

			try {
				requestEntity = new StringRequestEntity(
					body.getContent(), body.getContentType(),
					body.getCharset());
			}
			catch (UnsupportedEncodingException uee) {
				throw new HubSpotServerException(uee.getMessage(), uee);
			}

			postMethod.setRequestEntity(requestEntity);

			httpMethod = postMethod;
		}
		else {
			if (MapUtil.isNotEmpty(parameters)) {
				for (Map.Entry<String, String> entry : parameters.entrySet()) {
					String paramName = entry.getKey();
					String paramValue = entry.getValue();

					if (paramValue != null) {
						uri = HttpUtil.addParameter(uri, paramName, paramValue);
					}
				}
			}

			if (method.equals(Method.DELETE)) {
				httpMethod = new DeleteMethod(uri);
			}
			else {
				httpMethod = new GetMethod(uri);
			}
		}

		httpMethod = addRequestHeaders(headers, httpMethod);

		return httpMethod;
	}

	protected boolean isSkipURI(String uri) {
		for (String skipURIParameter : _SKIP_URI_PARAMETERS) {
			if (StringUtil.contains(uri, skipURIParameter)) {
				return true;
			}
		}

		return false;
	}

	private static final String[] _SKIP_URI_PARAMETERS =
		{"$request.attributes.OSB_HUBSPOT_UTK"};

	private static Log _log = LogFactoryUtil.getLog(HubSpotServerImpl.class);

	private HttpClient _httpClient = new HttpClient();

}