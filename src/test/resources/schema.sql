DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS administrator;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS company;
DROP TABLE IF EXISTS address;

create table administrator
(
	id integer not null auto_increment,
	name varchar(120) not null,
	surname varchar(120) not null,
    primary key(id)
);

create table customer
(
	id integer not null auto_increment,
	name varchar(120) not null,
	surname varchar(120) not null,
	dni varchar(9) not null,
	telephone integer(10) not null,
    primary key(id)
);

create table company
(
	id integer not null auto_increment,
	name varchar(50) not null,
	logo varchar(255) not null,
	cif varchar(9) not null,
	url varchar(255) not null,
	urlState varchar(50) not null,
	telephone integer(10) not null,
    primary key(id)
);

create table user
(
	id integer not null auto_increment,
	deleted Bool not null,
	username varchar(50) not null,
	password varchar(255) not null,
    mail varchar(100) not null,
    state varchar(255) not null,
    administrator_id integer,
    customer_id integer,
    company_id integer,
    FOREIGN KEY (administrator_id) REFERENCES administrator(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (company_id) REFERENCES company(id),
    primary key(id)
);

create table address
(
   id integer not null auto_increment,
   deleted Bool not null DEFAULT 0,
   street varchar(50) not null,
   postalCode integer not null,
   number integer not null,
   floor integer not null,
   stairs integer not null,
   user_id integer not null,
   primary key(id),
   FOREIGN KEY (user_id) REFERENCES user(id)
);