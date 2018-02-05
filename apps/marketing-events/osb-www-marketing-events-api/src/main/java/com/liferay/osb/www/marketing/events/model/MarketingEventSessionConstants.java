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

package com.liferay.osb.www.marketing.events.model;

import com.liferay.portal.kernel.workflow.WorkflowConstants;

/**
 * @author Joan H. Kim
 * @author Allen R. Ziegenfus
 */
public class MarketingEventSessionConstants {

	public static final String MIME_TYPE_IMAGE_GIF = "image/gif";

	public static final String MIME_TYPE_IMAGE_JPEG = "image/jpeg";

	public static final String MIME_TYPE_IMAGE_PNG = "image/png";

	public static final String MIME_TYPE_IMAGE_SVG_XML = "image/svg+xml";

	public static final String[] MIME_TYPES_IMAGES = {
		MIME_TYPE_IMAGE_GIF, MIME_TYPE_IMAGE_JPEG, MIME_TYPE_IMAGE_PNG,
		MIME_TYPE_IMAGE_SVG_XML
	};

	public static final int[] STATUSES =
		{WorkflowConstants.STATUS_APPROVED, WorkflowConstants.STATUS_DRAFT};

	public static final String TIME_FORMAT_DEFAULT_PATTERN = "H:mm";

}