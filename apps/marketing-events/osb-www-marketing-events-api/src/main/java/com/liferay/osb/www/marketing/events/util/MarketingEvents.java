package com.liferay.osb.www.marketing.events.util;

import com.liferay.osb.www.marketing.events.model.MarketingEventSession;
import com.liferay.osb.www.marketing.events.model.MarketingEventUser;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Allen Ziegenfus
 */
public interface MarketingEvents {

	Map<MarketingEventUser, List<MarketingEventSession>> 
		getMarketingEventUserMarketingEventSessionsMap(
			long marketingEventId, String vocabularyName, String categoryName) throws PortalException;

	List<MarketingEventSession> getMarketingEventSessions(long marketingEventId, Date date)
		throws PortalException;

	List<MarketingEventUser> getMarketingEventUsers(
		long marketingEventId, String vocabularyName, String categoryName) throws PortalException;

}