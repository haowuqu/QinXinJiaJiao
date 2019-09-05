drop database if exists qingxinjiajiao;
create database qingxinjiajiao;

use qingxinjiajiao;

create table parent
(
    id        int(11)      not null auto_increment,
    phone_num varchar(11)  not null unique,
    password  varchar(255) not null,
    icon      varchar(255),
    address   varchar(255),
    key (id)
);

create table teacher
(
    id            int(11)      not null auto_increment,
    teach_phone   varchar(255) not null,
    teach_sex     varchar(11)  not null,
    teach_name    varchar(255) not null unique,
    teach_icon    varchar(255) not null,
    teach_address varchar(255) not null,
    teach_exper   varchar(255),
    teach_sub     varchar(10)  not null,
    grade         varchar(255) not null,
    key (id)
);

create table par_money
(
    id             int(11)      not null auto_increment,
    phone_num      varchar(11)  not null,
    parent_balance varchar(255) not null,
    yue            varchar(11)  not null,
    jifen          varchar(11)  not null,
    key (id)
);

create table par_order
(
    id           int(11)      not null auto_increment,
    parent_phone varchar(11)  not null,
    book_name    varchar(255) not null,
    count        varchar(255) not null,
    price        varchar(255) not null,
    state        varchar(255) not null,
    key (id)
);

drop table if exists par_reward;
create table par_reward
(
    id        int(11)      not null auto_increment,
    phone_num varchar(11)  not null,
    account   varchar(255) not null,
    date      varchar(255) not null,
    key (id)
);

create table plant
(
    id              int(11)      not null auto_increment,
    plant_phone_num varchar(11)  not null,
    plant_content   varchar(255) not null,
    date            varchar(255) not null,
    key (id)
);

drop table if exists reserve;
create table reserve
(
    id           int(11)      not null auto_increment,
    parent_phone varchar(255) not null,
    teach_phone  varchar(255) not null,
    teach_name   varchar(255) not null,
    subject      varchar(255) not null,
    date         varchar(255) not null,
    key (id),
    primary key (parent_phone, teach_phone)
);

create table evaluate
(
    id           int(11)      not null auto_increment,
    parent_phone varchar(255) not null,
    teach_phone  varchar(255) not null,
    content      varchar(255) not null,
    date         varchar(255) not null,
    subject      varchar(255) not null,
    key (id)
);

