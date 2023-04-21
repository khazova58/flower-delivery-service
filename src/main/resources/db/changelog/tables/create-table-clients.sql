-- liquibase formatted sql

-- changeset yakhazova:create-table-clients
create table if not exists delivery.clients
(
    client_id    varchar             not null primary key,
    last_name    varchar(50)         not null,
    first_name   varchar(50)         not null,
    middle_name  varchar(50)         not null,
    phone_number varchar(15)         not null,
    email        varchar(100) unique not null
)
