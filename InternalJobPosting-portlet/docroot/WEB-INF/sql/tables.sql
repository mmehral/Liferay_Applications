create table emp_InternalReference (
	refId LONG not null primary key,
	title VARCHAR(75) null,
	from_ VARCHAR(75) null,
	to_ VARCHAR(75) null,
	body VARCHAR(75) null,
	flag LONG,
	createDate DATE null
);

create table empp_InternalReference (
	refId LONG not null primary key,
	title VARCHAR(200) null,
	from_ VARCHAR(200) null,
	to_ VARCHAR(200) null,
	body VARCHAR(1000) null,
	flag LONG,
	createDate DATE null,
	modifiedDate DATE null
);