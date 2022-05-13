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
reimbursement_id int primary key not null generated always as identity,
amount float,
submitted_date date,
resolved_date date,
description varchar(300),
reimbursement_author int references employee(employee_id) not null,
reimbursement_resolver int references employee(employee_id),
reimbursement_status int references reimbursement_status(status_id),
reimbursement_type int references reimbursement_type(type_id)
);

drop table reimbursement cascade;

/*the reimbursement table must reference the users table*/

create table if not exists reimbursement_status (
status_id int primary key not NULL unique,
status varchar(15)
);

create table if not exists reimbursement_type (
type_id int primary key not null,
type varchar(30)
);

create table if not exists user_roles (
role_id int primary key not NULL unique,
role boolean
);


/*
*we have created our main 5 tables, tables with "lu" in front are referenced as LOOKUP tables,
*therefore, we need to create data into these 3 LOOKUP tables
*/

INSERT INTO reimbursement_status (status_id, status)
values(1, 'Approve'), (2, 'Decline'), (3, 'Pending');

INSERT INTO reimbursement_type (type_id, type)
values(1, 'LODGING'), (2, 'TRAVEL'), (3, 'FOOD'), (4, 'OTHER');

-- we use boolean TO determine our positon, 1 = manager, 2 = associate
INSERT INTO user_roles (role_id, role) 
values(1, true), (2, false);

insert into reimbursement (amount, submitted_date, description, reimbursement_author, reimbursement_type) 
values (200.25, '2022-02-11', 'desc', 4, 2 );

insert into employee (employee_id, first_name,last_name, email, password, user_role) 
values (4,'Ethan', 'McCill', 'email.email.com', 'pass', 1);