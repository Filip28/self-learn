create table if not exists address
(
    id           bigserial primary key,
    street_name1 varchar(255) not null,
    street_name2 varchar(255) default null,
    zip_code     varchar(255) not null,
    city         varchar(255) not null,
    person_id    bigserial    not null references person (id)
);

