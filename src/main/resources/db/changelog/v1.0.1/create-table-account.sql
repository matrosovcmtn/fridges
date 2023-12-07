-- liquibase formatted sql

-- changeSet Danil:1
CREATE TABLE account
(
    id   integer generated always AS IDENTITY PRIMARY KEY,
    username varchar(50) NOT NULL,
    email varchar(100) NOT NULL,
    password varchar(50) NOT NULL,
    role varchar not null
);