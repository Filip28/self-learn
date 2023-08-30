create table IF NOT EXISTS person
(
    id      bigserial primary key,
    age     integer          NOT NULL,
    gender  varchar(255)     NOT NULL,
    height  double precision NOT NULL,
    name    varchar(255)     NOT NULL,
    surname varchar(255)     NOT NULL
);