-- liquibase formatted sql

-- changeset yakhazova:create-table-status
create table if not exists delivery.status
(
    status_id    integer     not null primary key,
    status_order varchar(10) not null unique
)