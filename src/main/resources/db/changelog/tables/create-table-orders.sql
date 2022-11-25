-- liquibase formatted sql

-- changeset yakhazova:create-table-orders
create table if not exists delivery.orders
(
    order_id         varchar       not null primary key,
    date_of_order    smalldatetime not null,
    date_of_update   smalldatetime not null,
    address_client   varchar(300)  not null,
    address_delivery varchar(300)  not null,
    status_order     varchar(10),
    version_order    integer,
    client_id        varchar       not null references delivery.clients (CLIENT_ID),
    courier_id       varchar references delivery.couriers (COURIER_ID)
)