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
    active       bool,
    foreign key (gender_id) references GENDER (id)
);

create table CONTINUANCE
(
    id   int primary key auto_increment,
    type varchar(128) not null,
    days int          not null
);

create table SUBSCRIPTION
(
    id             int primary key auto_increment,
    name           varchar(128) not null,
    price          int,
    continuance_id int,
    hall_id        int,
    trainer_id     int,
    foreign key (hall_id) references HALL (id),
    foreign key (continuance_id) references CONTINUANCE (id),
    foreign key (trainer_id) references trainer (id)
);

create table Position
(
    id   int primary key auto_increment,
    type varchar(128) not null
);

create table SERV_SUB
(
    id int primary key auto_increment
);

create table ACCOUNTING
(
    id              int primary key auto_increment,
    start           date,
    end             date,
    client_id       int,
    SUBSCRIPTION_ID int,
    foreign key (client_id) references CLIENT (id),
    foreign key (SUBSCRIPTION_ID) references SUBSCRIPTION (id)
);

create table TRAINER
(
    id          int primary key auto_increment,
    name        varchar(128),
    phone       varchar(128),
    image       varchar(256),
    birthday    date,
    gender_id   int,
    position_id int,
    foreign key (gender_id) references GENDER (id),
    foreign key (position_id) references position (id)
);

insert into ADMIN(login, password)
    value ('admin', '$2a$10$JXQID.XbrviNFf9xScU3R.V..RiFbtdPpe6KYpK9rqbMtAVpK/37O');

insert into GENDER (type)
    value ('Мужской');

insert into GENDER (type)
    value ('Женский');


delimiter
$

create procedure getAllGender()
select *
from GENDER;
$

create procedure getAllPosition()
select *
from Position;
$

create procedure createGender(_type varchar(128))
insert into GENDER(type) value (_type);
$
create procedure createPosition(_type varchar(128))
insert into gym.position(type) value (_type);
$

create procedure deleteGender(_id int)
delete
from GENDER
where id = _id;
$

create procedure deletePosition(_id int)
delete
from gym.position
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
create procedure getAllTrainers()
select *
from trainer;
$
create procedure getHallById(_id int)
select *
from HALL
where id = _id;
$
create procedure getTrainerById(_id int)
select *
from trainer
where id = _id;
$

create procedure createHall(_name varchar(128))
insert into HALL(name) value (_name);
$

create procedure getAllCONTINUANCE()
select *
from CONTINUANCE;
$
create procedure getCONTINUANCEById(_id int)
select *
from CONTINUANCE
where id = _id;
$

create procedure createCONTINUANCE(_days int, _name varchar(128))
insert into CONTINUANCE(type, days)
VALUES (_name, _days);
$

create procedure deleteCONTINUANCE(_id int)
delete
from CONTINUANCE
where id = _id;
$
create procedure deleteHall(_id int)
delete
from HALL
where id = _id;
$

create procedure getAllSubscription()
select *
from SUBSCRIPTION
$

create procedure createSubscription(_name varchar(128),
                                    _price int,
                                    _conti_id int,
                                    _hall_id int,
                                    _trainer_id int)
insert into SUBSCRIPTION(name, price, continuance_id, hall_id, trainer_id)
    VALUE (_name, _price, _conti_id, _hall_id, _trainer_id);
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

create procedure deleteTrainer(_id int)
delete
from trainer
where id = _id;
$
create procedure deleteSubscription(_id int)
delete
from SUBSCRIPTION
where id = _id;
$
create procedure deleteAccounting(_id int)
delete
from ACCOUNTING
where id = _id;
$
create procedure createAccounting(_start date,
                                  _end date,
                                  _client_id int,
                                  _SUBSCRIPTION_ID int
)
insert into ACCOUNTING (start, end, client_id, SUBSCRIPTION_ID)
values (_start, _end, _client_id, _SUBSCRIPTION_ID);
$

create procedure createClient(_firstname varchar(128),
                              _lastname varchar(128),
                              _phone varchar(128),
                              _birthday date,
                              _registration date,
                              _gender int,
                              _email varchar(128))
insert into client(firstname, lastname, phone, birthday, registration, gender_id, active, email)
    VALUE (_firstname, _lastname, _phone, _birthday, _registration, _gender, 1, _email);

$

create procedure createTrainer(_name varchar(128),
                               _phone varchar(128),
                               _position_id int,
                               _birthday date,
                               _gender_id int,
                               _image varchar(256))
insert into trainer(name, phone, position_id, birthday, gender_id, image)
    VALUE (_name, _phone, _position_id, _birthday, _gender_id, _image);
$
create procedure setToken(_id int, _token varchar(128))
update client set token = _token where client.id;
$
create procedure getAccountingByClient(_client_id int)
select *
from ACCOUNTING
where client_id = _client_id;
$
create procedure getAccounting(_id int)
select *
from ACCOUNTING
where id = _id;
$
create procedure getPosition(_id int)
select *
from gym.position
where id = _id;
$
create procedure getGender(_id int)
select *
from GENDER
where id = _id;
$
