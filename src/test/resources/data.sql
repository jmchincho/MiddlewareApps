insert into administrator(name, surname) values ('nameAdmin1', 'surnameAdmin1');
insert into administrator(name, surname) values ('nameAdmin2', 'surnameAdmin2');

insert into customer(name, surname, dni, telephone) values ('nameCustomer1', 'surnameCustomer1', '12345678D', 656000565);
insert into customer(name, surname, dni, telephone) values ('nameCustomer2', 'surnameCustomer2', '86543221A', 650909090);

insert into company(name, logo, cif, url, urlState, telephone) values ('nameCompany1', 'logo', '12345678D', 'url', 'A', 650606999);
insert into company(name, logo, cif, url, urlState, telephone) values ('nameCompany2', 'logo', '12345678D', 'url', 'A', 640506321);

insert into user(deleted, username, password, mail, state, administrator_id, company_id, customer_id)
    values (0, 'admin1', 'password', 'admin1@capitanoferta.com', 'A', 1, null, null);
insert into user(deleted, username, password, mail, state, administrator_id, company_id, customer_id)
    values (0, 'admin2', 'password', 'admin2@capitanoferta.com', 'A', 2, null, null);
insert into user(deleted, username, password, mail, state, administrator_id, company_id, customer_id)
    values (0, 'company1', 'password', 'company1@capitanoferta.com', 'A', null, 1, null);
insert into user(deleted, username, password, mail, state, administrator_id, company_id, customer_id)
    values (0, 'company2', 'password', 'company2@capitanoferta.com', 'A', null, 2, null);
insert into user(deleted, username, password, mail, state, administrator_id, company_id, customer_id)
    values (0, 'customer1', 'password', 'customer1@capitanoferta.com', 'A', null, null, 1);
insert into user(deleted, username, password, mail, state, administrator_id, company_id, customer_id)
    values (0, 'customer2', 'password', 'customer2@capitanoferta.com', 'A', null, null, 2);

insert into address(deleted, street, postalCode ,number ,floor ,stairs ,user_id) values (0, 'Calle Jerico', 41710, 6, 0, 0, 1);
insert into address(deleted, street, postalCode ,number ,floor ,stairs ,user_id) values (0, 'Calle Romero de Torres', 41710, 6, 0, 0, 1);
insert into address(deleted, street, postalCode ,number ,floor ,stairs ,user_id) values (1, 'Calle Borrada', 41710, 6, 0, 0, 1);