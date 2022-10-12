-- liquibase formatted sql

-- changeset yakhazova:create-table-orders
create table if not exists delivery.orders
(
    order_id         integer                  not null primary key,
    date_of_order    timestamp with time zone not null,
    date_of_update   timestamp with time zone not null,
    address_client   varchar(300)             not null,
    address_delivery varchar(300)             not null,
    status_order     varchar(50),
    version_order    integer,
    client_id        integer                  not null references delivery.clients,
    courier_id       integer                  not null references delivery.couriers
)