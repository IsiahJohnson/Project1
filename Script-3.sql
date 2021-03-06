CREATE TABLE if not exists employee (
employee_id int primary key not null generated always as identity,
username varchar(64),
password varchar(64),
first_name varchar(64),
last_name varchar(64),
email varchar(100),
user_role int references user_roles(role_id) not null
);

drop table employee cascade;

insert into employee (employee_id, first_name,last_name, email, password, role_id) values
	(4,'Ethan', 'McCill', 'email.email.com', 'pass', 1);
ssssss

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

insert into reimbursement (amount, submitted_date, description, reimbursement_author, reimbursement_type) values 
	(200.25, '2022-02-11', 'desc', 4, 2 );



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
role_id int primary key,
role boolean
);

drop table user_roles cascade;
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

create or replace function get_reimbursement_by_employee(e_id int)
returns refcursor as $$
declare ref refcursor;
begin
	open ref for select * from reimbursement r inner join employee e on r.reimbursement_author = e.employee_id where r.reimbursement_author = e_id;
	return ref;
end;
$$ language 'plpgsql';

create or replace function get_reimbursement_by_employee(e_id int)
returns refcursor as $$
declare ref refcursor;
begin
	open ref for select * from reimbursement r inner join employee e on r.reimbursement_author = e.employee_id where r.reimbursement_author = e_id;
	return ref;
end;
$$ language 'plpgsql';
