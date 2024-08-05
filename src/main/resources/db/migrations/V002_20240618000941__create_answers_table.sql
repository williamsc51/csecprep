create table answers (
    id bigint not null,
    value varchar(255),
    question_id bigint not null,
    user_id bigint,
    primary key (id)
);