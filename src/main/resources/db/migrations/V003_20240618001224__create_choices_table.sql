create table choices (
    id bigint not null,
    choice_text varchar(255) not null,
    is_correct boolean not null,
    question_id bigint not null,
    primary key (id)
);