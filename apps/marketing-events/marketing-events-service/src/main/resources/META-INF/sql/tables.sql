create table OSB_MarketingEvent (
	marketingEventId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	type_ INTEGER,
	title STRING null,
	titleURL VARCHAR(1000) null,
	hostedBy VARCHAR(75) null,
	hostedByURL VARCHAR(1000) null,
	summary STRING null,
	siteGroupId LONG,
	imageFileEntryId LONG,
	slidesFileEntryId LONG,
	videoTitle VARCHAR(150) null,
	timeZoneId VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	dateTBA BOOLEAN,
	addressId LONG,
	latitude DOUBLE,
	longitude DOUBLE,
	globalRegion INTEGER,
	online_ BOOLEAN,
	registrationType INTEGER,
	registrationURL STRING null,
	extraSettings VARCHAR(1000) null
);

create table OSB_MarketingEventAnnouncement (
	uuid_ VARCHAR(75) null,
	marketingEventAnnouncementId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	marketingEventId LONG,
	title STRING null,
	message STRING null,
	summary STRING null,
	imageFileEntryId LONG,
	linkURL VARCHAR(150) null,
	linkLabel VARCHAR(150) null,
	displayDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table OSB_MarketingEventSession (
	uuid_ VARCHAR(75) null,
	marketingEventSessionId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	marketingEventId LONG,
	marketingEventSessionRoomId LONG,
	title STRING null,
	description STRING null,
	keywords STRING null,
	slidesFileEntryId LONG,
	videoURL VARCHAR(150) null,
	startDate DATE null,
	endDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table OSB_MarketingEventSessionRoom (
	marketingEventSessionRoomId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	marketingEventId LONG,
	name VARCHAR(75) null,
	imageFileEntryId LONG
);

create table OSB_MarketingEventSessions_MarketingEventUsers (
	companyId LONG not null,
	marketingEventSessionId LONG not null,
	marketingEventUserId LONG not null,
	primary key (marketingEventSessionId, marketingEventUserId)
);

create table OSB_MarketingEventSponsor (
	marketingEventSponsorId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	marketingEventId LONG,
	marketingEventSponsorLevelId LONG,
	name VARCHAR(75) null,
	description STRING null,
	imageFileEntryId LONG,
	url VARCHAR(150) null
);

create table OSB_MarketingEventSponsorLevel (
	marketingEventSponsorLevelId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	marketingEventId LONG,
	name STRING null,
	priority INTEGER
);

create table OSB_MarketingEventUser (
	uuid_ VARCHAR(75) null,
	marketingEventUserId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	marketingEventId LONG,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	companyName VARCHAR(75) null,
	companyLogoFileEntryId LONG,
	jobTitle STRING null,
	description STRING null,
	imageFileEntryId LONG,
	phoneNumber VARCHAR(75) null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table OSB_SocialLink (
	socialLinkId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	marketingEventUserId LONG,
	socialLinkTypeId LONG,
	url VARCHAR(150) null
);

create table OSB_SocialLinkType (
	socialLinkTypeId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	imageFileEntryId LONG
);