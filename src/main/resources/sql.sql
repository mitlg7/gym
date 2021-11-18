create table HALL
(
    id   int primary key auto_increment,
    name varchar(128) not null
);

create table ADMIN
(
    id       int primary key auto_increment,
    login    varchar(128) unique,
    password varchar(256) not null
);

create table GENDER
(
    id   int primary key auto_increment,
    type varchar(128)
);

create table CLIENT
(
    id           int primary key auto_increment,
    firstname    varchar(128),
    lastname     varchar(128),
    phone        varchar(128),
    registration date not null,
    birthday     date,
    gender_id    int,
    foreign key (gender_id) references GENDER (id)
);

create table CONTINUANCE
(
    id   int primary key auto_increment,
    name varchar(128) not null,
    days int          not null
);

create table SUBSCRIPTION
(
    id             int primary key auto_increment,
    name           varchar(128) not null,
    price          int,
    continuance_id int,
    hall_id        int,
    foreign key (hall_id) references HALL (id),
    foreign key (continuance_id) references CONTINUANCE (id)
);

create table SERV_SUB
(
    id int primary key auto_increment
);

create table ACCOUNTING
(
    id         int primary key auto_increment,
    date_start date,
    date_end   date,
    client_id  int,
    foreign key (client_id) references CLIENT (id)
);

delimiter $

create procedure getAllGender()
select *
from GENDER;
$

create procedure createGender(_type varchar(128))
insert into GENDER(type) value (_type);
$

create procedure deleteGender(_id int)
delete
from GENDER
where id = _id;
$

create procedure getClientsByGenderId(_id int)
select *
from CLIENT
where gender_id = _id;
$

create procedure getAllClients()
select *
from CLIENT
         join GENDER G on G.id = CLIENT.gender_id;
$

create procedure getClientById(_id int)
select *
from CLIENT
         join GENDER G on G.id = CLIENT.gender_id
where CLIENT.id = _id;
$

create procedure getAdminByLogin(_login varchar(128))
select *
from ADMIN
where login = _login;
$

create procedure getAllAccounting()
select *
from ACCOUNTING;
$

create procedure getAllHall()
select *
from HALL;
$

create procedure createHall(_name varchar(128))
insert into HALL(name) value (_name);
$

create procedure getAllCONTINUANCE()
select *
from CONTINUANCE;
$

create procedure createCONTINUANCE(_days int, _name varchar(128))
insert into CONTINUANCE(name, days)
VALUES (_name, _days);
$

create procedure deleteCONTINUANCE(_id int)
delete
from CONTINUANCE
where id = _id;
$

create procedure getAllSubscription()
select *
from SUBSCRIPTION
         join HALL H on H.id = SUBSCRIPTION.hall_id
         join CONTINUANCE C on C.id = SUBSCRIPTION.continuance_id;
$

create procedure getSubscriptionById(_id int)
select *
from SUBSCRIPTION
where id = _id;
$

create procedure deleteClient(_id int)
delete
from CLIENT
where id = _id;
$

create procedure createClient(_firstname varchar(128), _lastname varchar(128), _birthday date, _registration date)

create procedure getAccountingByClient(_client_id int)
select *
from ACCOUNTING
where client_id = _client_id;
$



