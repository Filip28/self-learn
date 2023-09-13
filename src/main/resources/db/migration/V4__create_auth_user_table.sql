create table if not exists auth_user
(
    id         bigserial primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) null,
    email      varchar(255) not null,
    password   varchar(255) not null,
    role       varchar(255) not null check ( role in ('ADMIN', 'USER') )
);

