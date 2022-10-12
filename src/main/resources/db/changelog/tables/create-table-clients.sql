-- liquibase formatted sql

-- changeset yakhazova:create-table-clients
create table if not exists delivery.clients
(
    client_id    integer      not null primary key,
    name         varchar(100) not null,
    last_name    varchar(150) not null,
    phone_number varchar(15)  not null,
    email        varchar(300) not null
)
