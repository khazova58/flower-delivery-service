-- liquibase formatted sql

-- changeset yakhazova:update-table-clients
alter table delivery.clients
    add first_name varchar(100)