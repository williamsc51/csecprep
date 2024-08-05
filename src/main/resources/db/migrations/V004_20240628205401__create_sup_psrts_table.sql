create table sub_parts(
    id bigint not null,
    prompt varchar(255) not null,
    correct_answer varchar(255) not null,
    type varchar(255) check (type in ('MULTIPLECHOICE','MULTIPART','SINGLEVALUE')),
    question_id bigint not null,
    primary key (id)
)