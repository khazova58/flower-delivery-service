-- liquibase formatted sql

-- changeset yakhazova:create-table-couriers
create table if not exists DELIVERY.couriers
(
    courier_id   varchar      not null primary key,
    name         varchar(100) not null,
    last_name    varchar(150) not null,
    phone_number varchar(15)  not null unique
)