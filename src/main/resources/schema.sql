DROP TABLE IF EXISTS subcription;
DROP TABLE IF EXISTS purchaseOrder;
DROP TABLE IF EXISTS bannerAds;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS administrator;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS company;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS province;
DROP TABLE IF EXISTS country;
DROP TABLE IF EXISTS subcategory;
DROP TABLE IF EXISTS category;

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
	deleted Bool not null default 0,
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

create table country
(
   id integer not null auto_increment,
   deleted Bool not null default 0,
   name varchar(50) not null,
   state varchar(255) not null,
   primary key(id)
);

create table province
(
   id integer not null auto_increment,
   deleted Bool not null default 0,
   name varchar(50) not null,
   state varchar(255) not null,
   country_id integer not null,
   primary key(id),
   FOREIGN KEY (country_id) REFERENCES country(id)
);

create table location
(
   id integer not null auto_increment,
   deleted Bool not null default 0,
   name varchar(50) not null,
   state varchar(255) not null,
   province_id integer not null,
   primary key(id),
   FOREIGN KEY (province_id) REFERENCES province(id)
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
   location_id integer not null,
   primary key(id),
   FOREIGN KEY (user_id) REFERENCES user(id),
   FOREIGN KEY (location_id) REFERENCES location(id)
);

create table category
(
   id integer not null auto_increment,
   deleted Bool not null default 0,
   name varchar(50) not null,
   state varchar(255) not null,
   sequence integer not null,
   primary key(id)
);

create table subcategory
(
   id integer not null auto_increment,
   deleted Bool not null default 0,
   name varchar(50) not null,
   state varchar(255) not null,
   category_id integer not null,
   sequence integer not null,
   primary key(id),
   FOREIGN KEY (category_id) REFERENCES category(id)
);

create table bannerAds
(
   id integer not null auto_increment,
   deleted Bool not null default 0,
   title varchar(50) not null,
   description varchar(255) not null,
   image varchar(50) not null,
   url varchar(50) not null,
   state varchar(255) not null,
   sequence integer not null,
   createDate datetime not null default CURRENT_TIMESTAMP,
   startDate datetime not null,
   finishDate datetime not null,
   primary key(id)
);

create table subcription
(
   id integer not null auto_increment,
   deleted Bool not null default 0,
   createDate datetime not null default CURRENT_TIMESTAMP,
   customer_id integer not null,
   company_id integer not null,
   primary key(id),
   FOREIGN KEY (customer_id) REFERENCES customer(id),
   FOREIGN KEY (company_id) REFERENCES company(id)
);

create table purchaseOrder
(
	id integer not null auto_increment,
	deleted Bool not null default 0,
	paymentType varchar(50) not null,
	paidOrder varchar(50) not null,
    observations varchar(1000) not null,
    state varchar(255) not null,
    createDate datetime not null default CURRENT_TIMESTAMP,
    modifyDate datetime not null default CURRENT_TIMESTAMP,
    priceTotal decimal,
    address_id integer not null,
    FOREIGN KEY (address_id) REFERENCES address(id),
    primary key(id)
);

create table item
(
	id integer not null auto_increment,
	deleted Bool not null default 0,
	name varchar(200) not null,
	descriptions varchar(1000) not null,
    conditions varchar(1000) not null,
    state varchar(255) not null,
    url varchar(255),
    image1 varchar(255),
    image2 varchar(255),
    image3 varchar(255),
    image4 varchar(255),
    image5 varchar(255),
    sendType varchar(255),
    type varchar(255),
    price decimal default 0.0,
    sendPrice decimal default 0.0,
    stock integer not null,
    startDate datetime not null default CURRENT_TIMESTAMP,
    finishDate datetime not null default CURRENT_TIMESTAMP,
    createDate datetime not null default CURRENT_TIMESTAMP,
    publishDate datetime not null default CURRENT_TIMESTAMP,
    company_id integer not null,
    subcategory_id integer not null,
    FOREIGN KEY (company_id) REFERENCES company(id),
    FOREIGN KEY (subcategory_id) REFERENCES subcategory(id),
    primary key(id)
);

create table orderDetail
(
	id integer not null auto_increment,
	deleted Bool not null default 0,
	quantity integer not null,
	sendState varchar(50) not null,
	price decimal not null,
    sendDate datetime not null default CURRENT_TIMESTAMP,
    deliveredDate datetime not null default CURRENT_TIMESTAMP,
    cancelledDate datetime not null default CURRENT_TIMESTAMP,
    order_id integer not null,
    item_id integer not null,
    FOREIGN KEY (order_id) REFERENCES purchaseOrder(id),
    FOREIGN KEY (item_id) REFERENCES item(id),
    primary key(id)
);

create table offer
(
	id integer not null auto_increment,
	deleted Bool not null default 0,
	state varchar(50) not null,
	paymentType varchar(50) not null,
	price decimal not null,
    createDate datetime not null default CURRENT_TIMESTAMP,
    startDate datetime not null default CURRENT_TIMESTAMP,
    finishDate datetime not null default CURRENT_TIMESTAMP,
    publishDate datetime not null default CURRENT_TIMESTAMP,
    item_id integer not null,
    FOREIGN KEY (item_id) REFERENCES item(id),
    primary key(id)
);

create table comment
(
	id integer not null auto_increment,
	deleted Bool not null default 0,
	name varchar(50) not null,
	description varchar(1000) not null,
	approved varchar(50) not null,
	denounced varchar(50) not null,
    createDate datetime not null default CURRENT_TIMESTAMP,
    score integer not null,
    customer_id integer not null,
    item_id integer not null,
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (item_id) REFERENCES item(id),
    primary key(id)
);

create table variant
(
	id integer not null auto_increment,
	deleted Bool not null default 0,
	type varchar(50) not null,
	size varchar(50) not null,
	state varchar(50) not null,
	color varchar(50) not null,
	price decimal not null,
	stock integer not null,
    createDate datetime not null default CURRENT_TIMESTAMP,
    startDate datetime not null default CURRENT_TIMESTAMP,
    finishDate datetime not null default CURRENT_TIMESTAMP,
    publishDate datetime not null default CURRENT_TIMESTAMP,
    item_id integer not null,
    FOREIGN KEY (item_id) REFERENCES item(id),
    primary key(id)
);



