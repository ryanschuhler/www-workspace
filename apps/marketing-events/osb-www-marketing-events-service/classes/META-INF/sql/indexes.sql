create index IX_EED5EFA6 on OSB_MarketingEvent (globalRegion);
create index IX_B0D243C8 on OSB_MarketingEvent (siteGroupId);
create index IX_5AE99366 on OSB_MarketingEvent (type_, startDate);

create index IX_1EF95061 on OSB_MarketingEventAnnouncement (marketingEventId, displayDate, status);
create index IX_8E6D8112 on OSB_MarketingEventAnnouncement (uuid_[$COLUMN_LENGTH:75$]);

create index IX_A7BB5DE on OSB_MarketingEventSession (marketingEventId, marketingEventSessionRoomId);
create index IX_9360B350 on OSB_MarketingEventSession (marketingEventId, status);
create index IX_63B92ADB on OSB_MarketingEventSession (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_EE2FEF65 on OSB_MarketingEventSessionRoom (marketingEventId);

create index IX_31FE061B on OSB_MarketingEventSessions_MarketingEventUsers (companyId);
create index IX_A9C3F140 on OSB_MarketingEventSessions_MarketingEventUsers (marketingEventSessionId);
create index IX_8408C51B on OSB_MarketingEventSessions_MarketingEventUsers (marketingEventUserId);

create index IX_658AFC9B on OSB_MarketingEventSponsor (marketingEventId, marketingEventSponsorLevelId);

create index IX_733A8328 on OSB_MarketingEventSponsorLevel (marketingEventId);

create index IX_B87DF6CF on OSB_MarketingEventUser (marketingEventId, status);
create index IX_D9355D5A on OSB_MarketingEventUser (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_A157F22C on OSB_SocialLink (marketingEventUserId, socialLinkTypeId);
create index IX_E42E0B3E on OSB_SocialLink (socialLinkTypeId);