-- liquibase formatted sql

-- changeset Roman:create-table-operators
create table if not exists delivery.operators
(
    operator_id  varchar      not null primary key,
    name         varchar(100) not null,
    last_name    varchar(150) not null,
    phone_number varchar(15)  not null,
    email        varchar(300) not null
    );

-- changeset Roman:update
    ALTER TABLE delivery.operators ADD COLUMN test VARCHAR (20);

-- changeset Roman:update1
    ALTER TABLE delivery.operators ALTER COLUMN test RENAME TO test1;

-- changeset Roman:update2
    ALTER TABLE delivery.operators DROP COLUMN test1;
