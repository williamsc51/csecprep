create table users (
    id integer not null,
    email varchar(255) not null,
    password varchar(255) not null,
    username varchar(255),
    primary key (id)
);