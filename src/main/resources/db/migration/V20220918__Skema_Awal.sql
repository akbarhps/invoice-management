CREATE TABLE payment_provider
(
    id varchar(36),
    primary key (id)
);

CREATE TABLE invoice_type
(
    id varchar(36),
    primary key (id)
);

CREATE TABLE invoice
(
    id varchar(36),
    primary key (id)
);

CREATE TABLE virtual_account
(
    id varchar(36),
    primary key (id)
);

CREATE TABLE payment
(
    id varchar(36),
    primary key (id)
);
