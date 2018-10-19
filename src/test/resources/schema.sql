DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS address;

create table user
(
	id integer not null auto_increment,
	deleted Bool not null,
	username varchar(50) not null,
	password varchar(255) not null,
    mail varchar(100) not null,
    state varchar(255) not null,
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