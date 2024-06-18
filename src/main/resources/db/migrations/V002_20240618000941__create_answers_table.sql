create table answers (
    id integer not null,
    is_correct boolean,
    question_id integer not null,
    value varchar(255) not null,
    primary key (id)
);