insert into administrator(name, surname) values ('nameAdmin1', 'surnameAdmin1');
insert into administrator(name, surname) values ('nameAdmin2', 'surnameAdmin2');

insert into customer(name, surname, dni, telephone) values ('nameCustomer1', 'surnameCustomer1', '12345678D', 656000565);
insert into customer(name, surname, dni, telephone) values ('nameCustomer2', 'surnameCustomer2', '86543221A', 650909090);

insert into company(name, logo, cif, url, urlState, telephone) values ('nameCompany1', 'logo', '12345678D', 'url', 'A', 650606999);
insert into company(name, logo, cif, url, urlState, telephone) values ('nameCompany2', 'logo', '12345678D', 'url', 'A', 640506321);

insert into user(deleted, username, password, mail, state, administrator_id, company_id, customer_id)
    values (0, 'admin1', '$2a$10$097XijqkCWcEyiKYXRzSFuznaCGO2io55p2xWawTSslC7R1v10tGG', 'admin1@capitanoferta.com', 'A', 1, null, null);
insert into user(deleted, username, password, mail, state, administrator_id, company_id, customer_id)
    values (0, 'admin2', '$2a$10$097XijqkCWcEyiKYXRzSFuznaCGO2io55p2xWawTSslC7R1v10tGG', 'admin2@capitanoferta.com', 'A', 2, null, null);
insert into user(deleted, username, password, mail, state, administrator_id, company_id, customer_id)
    values (0, 'company1', '$2a$10$097XijqkCWcEyiKYXRzSFuznaCGO2io55p2xWawTSslC7R1v10tGG', 'company1@capitanoferta.com', 'A', null, 1, null);
insert into user(deleted, username, password, mail, state, administrator_id, company_id, customer_id)
    values (0, 'company2', '$2a$10$097XijqkCWcEyiKYXRzSFuznaCGO2io55p2xWawTSslC7R1v10tGG', 'company2@capitanoferta.com', 'A', null, 2, null);
insert into user(deleted, username, password, mail, state, administrator_id, company_id, customer_id)
    values (0, 'customer1', '$2a$10$097XijqkCWcEyiKYXRzSFuznaCGO2io55p2xWawTSslC7R1v10tGG', 'customer1@capitanoferta.com', 'A', null, null, 1);
insert into user(deleted, username, password, mail, state, administrator_id, company_id, customer_id)
    values (0, 'customer2', '$2a$10$097XijqkCWcEyiKYXRzSFuznaCGO2io55p2xWawTSslC7R1v10tGG', 'customer2@capitanoferta.com', 'A', null, null, 2);

insert into country(deleted, name, state) values (0, 'España', 'enabled');
insert into country(deleted, name, state) values (0, 'Francia', 'disabled');

insert into province(deleted, name, state, country_id) values (0, 'Sevilla', 'enabled', 1);
insert into province(deleted, name, state, country_id) values (0, 'Madrid', 'disabled', 1);

insert into location(deleted, name, state, province_id) values (0, 'Utrera', 'enabled', 1);
insert into location(deleted, name, state, province_id) values (0, 'Madrid', 'disabled', 2);

insert into address(deleted, street, postalCode ,number ,floor ,stairs ,user_id, location_id) values (0, 'Calle Jerico', 41710, 6, 0, 0, 1, 1);
insert into address(deleted, street, postalCode ,number ,floor ,stairs ,user_id, location_id) values (0, 'Calle Romero de Torres', 41710, 6, 0, 0, 1, 1);
insert into address(deleted, street, postalCode ,number ,floor ,stairs ,user_id, location_id) values (1, 'Calle Borrada', 41710, 6, 0, 0, 1, 1);

insert into category(deleted, name, state, sequence) values (0, 'Alimentación', 'disabled', 1);
insert into category(deleted, name, state, sequence) values (0, 'Deportes', 'disabled', 2);

insert into subcategory(deleted, name, state, sequence, category_id) values (0, 'Futbol', 'enabled', 1, 1);
insert into subcategory(deleted, name, state, sequence, category_id) values (0, 'Padel', 'disabled', 1, 2);

insert into bannerAds(deleted, title, description, image, url, state, sequence, startDate, finishDate)
    values(0, 'title1', 'description1', 'image1', 'url1', 'enabled', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into bannerAds(title, description, image, url, state, sequence, startDate, finishDate)
    values('title2', 'description2', 'image2', 'url2', 'enabled', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into subcription(customer_id, company_id) values (1, 1);
insert into subcription(customer_id, company_id) values (1, 2);

insert into purchaseOrder(paymentType, paidOrder, observations, state, priceTotal, address_id) values ('paymentType', 'paidOrder', 'observations1', 'enabled', 200.40, 1);
insert into purchaseOrder(paymentType, paidOrder, observations, state, priceTotal, address_id) values ('paymentType', 'paidOrder', 'observations2', 'enabled', 1200.50, 1);

insert into item(name, descriptions, conditions, sendType, state, type, price, sendPrice, stock, company_id, subcategory_id)
            values ('item1', 'descriptions1', 'conditions1', 'sendType', 'enabled', 'type', 40.00, 0.00, 3, 1, 1);
insert into item(name, descriptions, conditions, sendType, state, type, price, sendPrice, stock, company_id, subcategory_id)
            values ('item2', 'descriptions2', 'conditions2', 'sendType', 'enabled', 'type', 30.00, 0.00, 5, 2, 1);

insert into orderDetail(quantity, sendState, price, order_id, item_id) values (3, 'sendState', 500.00, 1, 1);
insert into orderDetail(quantity, sendState, price, order_id, item_id) values (5, 'sendState', 130.00, 1, 2);

insert into offer(state, paymentType, price, item_id) values ('enabled', 'paymentType', 130.00, 1);
insert into offer(state, paymentType, price, item_id) values ('enabled', 'paymentType', 10.00, 2);

insert into comment(name, description, approved, denounced, score, customer_id, item_id) values ('name1', 'description1', 'approved', 'denounced', 3, 1, 1);
insert into comment(name, description, approved, denounced, score, customer_id, item_id) values ('name2', 'description2', 'approved', 'denounced', 3, 1, 2);

insert into variant(type, size, color, state, stock, price, item_id) values ('type', 'size', 'color','enabled', 5, 10.00, 1);
insert into variant(type, size, color, state, stock, price, item_id) values ('type', 'size', 'color','enabled', 3, 9.00, 2);