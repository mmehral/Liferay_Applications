create table organizationAnnouncement_organization (
	organization_id LONG not null primary key,
	organization_tite VARCHAR(100) null,
	organization_description TEXT null,
	organization_image_name VARCHAR(75) null,
	organization_image_path VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);