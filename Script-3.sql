CREATE TABLE if not exists employee (
employee_id int primary key not null,
username varchar(64),
password varchar(64),
first_name varchar(64),
last_name varchar(64),
email varchar(100),
user_role int  references user_roles(role_id)
);


create table if not exists reimbursement (
reimbursement_id int primary key not null,
amount float,
submitted_date date,
resolved_date date,
description varchar(300),
reimbursement_author int references employee(employee_id) not null,
reimbursement_resolver int references employee(employee_id),
reimbursement_status int references reimbursement_status(status_id),
reimbursement_type int references reimbursement_type(type_id)
);


/*the reimbursement table must reference the users table*/

create table if not exists reimbursement_status (
status_id int primary key not null,
status boolean
);

create table if not exists reimbursement_type (
type_id int primary key not null,
type varchar(30)
);

create table if not exists user_roles (
role_id int primary key not null,
role varchar(20)
);


/*
*we have created our main 5 tables, tables with "lu" in front are referenced as LOOKUP tables,
*therefore, we need to create data into these 3 LOOKUP tables
*/