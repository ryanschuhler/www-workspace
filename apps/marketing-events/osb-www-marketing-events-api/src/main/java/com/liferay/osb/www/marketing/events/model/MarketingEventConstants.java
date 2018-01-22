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

/**
 * @author Rachael Koestartyo
 */
public class MarketingEventConstants {

	public static final String ADDRESS_ZIP_NOT_AVAILABLE = "N/A";

	public static final int CONFIGURATION_TYPE_COMMUNITY = 0;

	public static final int CONFIGURATION_TYPE_CONFERENCE = 1;

	public static final int CONFIGURATION_TYPE_INDUSTRY = 2;

	public static final int CONFIGURATION_TYPE_PARTNER = 3;

	public static final int CONFIGURATION_TYPE_ROADSHOW = 4;

	public static final int CONFIGURATION_TYPE_WEBINAR = 5;

	public static final int[] CONFIGURATION_TYPES = {
		CONFIGURATION_TYPE_COMMUNITY, CONFIGURATION_TYPE_CONFERENCE,
		CONFIGURATION_TYPE_INDUSTRY, CONFIGURATION_TYPE_PARTNER,
		CONFIGURATION_TYPE_ROADSHOW, CONFIGURATION_TYPE_WEBINAR
	};

	public static final long DEFAULT_ADDRESS_ID = 0;

	public static final int GLOBAL_REGION_AMER = 1;

	public static final int GLOBAL_REGION_APAC = 2;

	public static final int GLOBAL_REGION_EMEA = 3;

	public static final int GLOBAL_REGION_WORLDWIDE = 0;

	public static final int[] GLOBAL_REGIONS = {
		GLOBAL_REGION_AMER, GLOBAL_REGION_APAC, GLOBAL_REGION_EMEA,
		GLOBAL_REGION_WORLDWIDE
	};

	public static final int LOCATION_TYPE_IN_PERSON = 0;

	public static final int LOCATION_TYPE_ONLINE = 1;

	public static final int[] LOCATION_TYPES =
		{LOCATION_TYPE_IN_PERSON, LOCATION_TYPE_ONLINE};

	public static final String ORDER_BY_TYPE_ASC = "asc";

	public static final String ORDER_BY_TYPE_DESC = "desc";

	public static final int REGISTRATION_TYPE_LEARN_MORE = 0;

	public static final int REGISTRATION_TYPE_REGISTER = 1;

	public static final int[] REGISTRATION_TYPES =
		{REGISTRATION_TYPE_LEARN_MORE, REGISTRATION_TYPE_REGISTER};

	public static final int TYPE_COMMUNITY = 0;

	public static final int TYPE_CONFERENCE = 1;

	public static final int TYPE_INDUSTRY = 2;

	public static final int TYPE_PARTNER = 3;

	public static final int TYPE_ROADSHOW = 4;

	public static final int TYPE_WEBINAR = 5;

	public static final int[] TYPES = {
		TYPE_COMMUNITY, TYPE_CONFERENCE, TYPE_INDUSTRY, TYPE_PARTNER,
		TYPE_ROADSHOW, TYPE_WEBINAR
	};

	public static final String VIDEOS_URL =
		"http://videos.liferay.com/webinars/";

	public static String getConfigurationTypeLabel(int configurationType) {
		if (configurationType == CONFIGURATION_TYPE_CONFERENCE) {
			return "conference";
		}
		else if (configurationType == CONFIGURATION_TYPE_INDUSTRY) {
			return "industry";
		}
		else if (configurationType == CONFIGURATION_TYPE_PARTNER) {
			return "partner";
		}
		else if (configurationType == CONFIGURATION_TYPE_ROADSHOW) {
			return "roadshow";
		}
		else if (configurationType == CONFIGURATION_TYPE_WEBINAR) {
			return "webinar";
		}
		else {
			return "community";
		}
	}

	public static String getGlobalRegionLabel(int globalRegion) {
		return getGlobalRegionLabel(globalRegion, false);
	}

	public static String getGlobalRegionLabel(int globalRegion, boolean count) {
		if (globalRegion == GLOBAL_REGION_AMER) {
			if (count) {
				return "americas-x";
			}
			else {
				return "americas";
			}
		}
		else if (globalRegion == GLOBAL_REGION_APAC) {
			if (count) {
				return "asia-pacific-x";
			}
			else {
				return "asia-pacific";
			}
		}
		else if (globalRegion == GLOBAL_REGION_EMEA) {
			if (count) {
				return "europe-middle-east-africa-x";
			}
			else {
				return "europe-middle-east-africa";
			}
		}
		else {
			if (count) {
				return "worldwide-x";
			}
			else {
				return "worldwide";
			}
		}
	}

	public static String getLocationTypeLabel(int locationType) {
		return getLocationTypeLabel(locationType, false);
	}

	public static String getLocationTypeLabel(int locationType, boolean count) {
		if (locationType == LOCATION_TYPE_IN_PERSON) {
			if (count) {
				return "in-person-x";
			}
			else {
				return "in-person";
			}
		}
		else {
			if (count) {
				return "online-x";
			}
			else {
				return "online";
			}
		}
	}

	public static String getRegistrationTypeButtonLabel(int registrationType) {
		if (registrationType == REGISTRATION_TYPE_LEARN_MORE) {
			return "learn-more";
		}
		else {
			return "register";
		}
	}

	public static String getRegistrationTypeLabel(int registrationType) {
		if (registrationType == REGISTRATION_TYPE_LEARN_MORE) {
			return "learn-more";
		}
		else {
			return "register";
		}
	}

	public static String getTypeLabel(int type) {
		return getTypeLabel(type, false);
	}

	public static String getTypeLabel(int type, boolean count) {
		if (type == TYPE_CONFERENCE) {
			if (count) {
				return "conference-x";
			}
			else {
				return "conference";
			}
		}
		else if (type == TYPE_INDUSTRY) {
			if (count) {
				return "industry-x";
			}
			else {
				return "industry";
			}
		}
		else if (type == TYPE_PARTNER) {
			if (count) {
				return "partner-x";
			}
			else {
				return "partner";
			}
		}
		else if (type == TYPE_ROADSHOW) {
			if (count) {
				return "roadshow-x";
			}
			else {
				return "roadshow";
			}
		}
		else if (type == TYPE_WEBINAR) {
			if (count) {
				return "webinar-x";
			}
			else {
				return "webinar";
			}
		}
		else {
			if (count) {
				return "community-x";
			}
			else {
				return "community";
			}
		}
	}

	public static int[] getTypes(int configurationType) {
		if (configurationType == CONFIGURATION_TYPE_CONFERENCE) {
			return new int[] {TYPE_CONFERENCE};
		}
		else if (configurationType == CONFIGURATION_TYPE_INDUSTRY) {
			return new int[] {TYPE_INDUSTRY};
		}
		else if (configurationType == CONFIGURATION_TYPE_PARTNER) {
			return new int[] {TYPE_PARTNER};
		}
		else if (configurationType == CONFIGURATION_TYPE_ROADSHOW) {
			return new int[] {TYPE_ROADSHOW};
		}
		else if (configurationType == CONFIGURATION_TYPE_WEBINAR) {
			return new int[] {TYPE_WEBINAR};
		}
		else {
			return new int[] {TYPE_COMMUNITY};
		}
	}

}