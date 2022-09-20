create table running_number
(
    id          varchar(36)  not null
        primary key,
    prefix      varchar(100) not null,
    last_number bigint       not null
);

create table customer
(
    id            varchar(36)  not null
        primary key,
    created_at    timestamp,
    created_by    varchar(255),
    record_status varchar(255) not null,
    updated_at    timestamp,
    updated_by    varchar(255),
    code          varchar(100) not null,
    name          varchar(255) not null,
    email         varchar(100) not null,
    mobile_phone  varchar(30)  not null
);

create table payment_provider
(
    id            varchar(36)  not null
        primary key,
    code          varchar(100) not null
        constraint payment_provider_unique_code
            unique,
    name          varchar(100) not null,
    created_at    timestamp,
    created_by    varchar(255),
    record_status varchar(255) not null,
    updated_at    timestamp,
    updated_by    varchar(255),
    logo          varchar(255)
);

alter table payment_provider
    owner to invoice;

create table invoice_type
(
    id            varchar(36)  not null
        primary key,
    created_at    timestamp,
    created_by    varchar(255),
    record_status varchar(255) not null,
    updated_at    timestamp,
    updated_by    varchar(255),
    code          varchar(100) not null,
    name          varchar(100) not null
);

alter table invoice_type
    owner to invoice;

create table invoice
(
    id              varchar(36)    not null
        primary key,
    created_at      timestamp,
    created_by      varchar(255),
    record_status   varchar(255)   not null,
    updated_at      timestamp,
    updated_by      varchar(255),
    amount          numeric(19, 2) not null
        constraint invoice_amount_check
            check (amount >= (0)::numeric),
    description     varchar(100)   not null,
    due_date        date           not null,
    invoice_number  varchar(100)   not null,
    is_paid         boolean        not null,
    id_invoice_type varchar(255)
        constraint fkco4sbxv9cj2oevm6cdpq76ffb
            references invoice_type,
    id_customer     varchar(255)
        constraint fk_invoice_id_customer
            references customer
);

alter table invoice
    owner to invoice;

create table invoice_type_provider
(
    id_invoice_type     varchar(36) not null
        constraint fk_invoice_type_provider_provider
            references invoice_type,
    id_payment_provider varchar(36) not null
        constraint fk_invoice_type_provider_type
            references invoice_type,
    primary key (id_invoice_type, id_payment_provider)
);

create table virtual_account
(
    id                   varchar(36)  not null
        primary key,
    created_at           timestamp,
    created_by           varchar(255),
    record_status        varchar(255) not null,
    updated_at           timestamp,
    updated_by           varchar(255),
    account_number       varchar(255) not null,
    company_id           varchar(255) not null,
    virtual_account_type varchar(255) not null,
    id_invoice           varchar(255) not null
        constraint fkbbdwdxpgdisiikyyhf2xteblc
            references invoice,
    id_payment_provider  varchar(255)
        constraint fkt3t7f64hvgk4xjblsovqqkpll
            references payment_provider
);

alter table virtual_account
    owner to invoice;

create table payment
(
    id                 varchar(36)    not null
        primary key,
    created_at         timestamp,
    created_by         varchar(255),
    record_status      varchar(255)   not null,
    updated_at         timestamp,
    updated_by         varchar(255),
    amount             numeric(19, 2) not null
        constraint payment_amount_check
            check (amount >= (1)::numeric),
    provider_reference varchar(255)   not null,
    transaction_time   timestamp      not null,
    id_virtual_account varchar(255)
        constraint fkptriq88d7e8io9mhri8p10cq0
            references virtual_account
);

alter table payment
    owner to invoice;

