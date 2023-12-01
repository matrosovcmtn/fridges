-- liquibase formatted sql

-- changeSet Danil:1
CREATE TABLE specialization
(
    id   integer generated always AS IDENTITY PRIMARY KEY,
    name varchar(200) NOT NULL
);

CREATE TABLE warehouse
(
    id                    integer generated always AS IDENTITY PRIMARY KEY,
    warehouse_information varchar(500) NOT NULL,
    details_information   varchar(500) NOT NULL
);

CREATE TABLE employee
(
    id           integer generated always AS IDENTITY PRIMARY KEY,
    first_name   varchar(120) NOT NULL,
    second_name  varchar(120) NOT NULL,
    middle_name  varchar(120),
    phone_number varchar(20),
    full_name    text,
    warehouse_id integer REFERENCES warehouse,
    spec_id      integer REFERENCES specialization
);

CREATE TABLE item
(
    id           integer generated always AS IDENTITY PRIMARY KEY,
    name         varchar(500)                 NOT NULL,
    quantity     integer                      NOT NULL,
    warehouse_id integer REFERENCES warehouse NOT NULL
);

CREATE TABLE piece
(
    id           integer generated always AS IDENTITY PRIMARY KEY,
    name         varchar(500)                 NOT NULL,
    quantity     integer                      NOT NULL,
    warehouse_id integer REFERENCES warehouse NOT NULL
);

CREATE TABLE detail
(
    id           integer generated always AS IDENTITY PRIMARY KEY,
    name         varchar(500)                 NOT NULL,
    quantity     integer                      NOT NULL,
    warehouse_id integer REFERENCES warehouse NOT NULL
);

CREATE TABLE customer
(
    id           integer generated always AS IDENTITY PRIMARY KEY,
    first_name   varchar(120) NOT NULL,
    second_name  varchar(120),
    middle_name  varchar(120),
    phone_number varchar(20)
);

CREATE TABLE application
(
    id            integer generated always AS IDENTITY PRIMARY KEY,
    customer_id   integer REFERENCES customer NOT NULL,
    employee_id   integer REFERENCES employee NOT NULL,
    creation_date date                        NOT NULL
);

CREATE TABLE product
(
    id               integer generated always AS IDENTITY PRIMARY KEY,
    item_name        varchar(100) NOT NULL,
    item_information varchar(500)
);

CREATE TABLE application_composition
(
    id             integer generated always AS IDENTITY PRIMARY KEY,
    quantity       int check (quantity > 0)       NOT NULL,
    application_id integer REFERENCES application NOT NULL,
    product_id     integer REFERENCES product     NOT NULL
);
